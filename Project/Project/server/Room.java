package Project.server;
//my imported 
import java.util.Random;
import java.util.regex.*;  
//end
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import Project.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;
    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    private static Logger logger = Logger.getLogger(Room.class.getName());

    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
            //get blocked list to send paylooad
            initBlockListForUI(client);
            reinitBlockListForUI(client);
        }
    }

    protected void initBlockListForUI(ServerThread client){
        ArrayList<String> blockedlist = client.getBlockedList();
        for (String name: blockedlist){
            long myblockedid= getClientIdFromName(name);
            client.sendBlocked(myblockedid);
        }
    }
    
     protected void reinitBlockListForUI(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getBlockedList().contains(client.getClientName())) {
                existingClient.sendBlocked(client.getClientId());
                }
        }
    }
    
    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }

    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods

    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     */
    protected synchronized void sendMessage(ServerThread sender, String message) {
        if (!isRunning) {
            return;
        }
        logger.info(String.format("Sending message to %s clients", clients.size()));
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }
        //ccu3 commands roll flip etc
        if(message.startsWith("/")){
            String command=message.split(" ")[0];
            if (command.equals("/roll") && (message.split(" ").length==2)){
                String mynums=message.split(" ")[1];
                if(mynums.matches("\\d+d{1}\\d+")){
                    int ndice=Integer.parseInt(mynums.split("d")[0]);
                    int sides=Integer.parseInt(mynums.split("d")[1]);
                    message=roll(ndice,sides);
                }
                else if(mynums.matches("\\d+")){
                    int sides=Integer.parseInt(mynums);
                    message=roll(1,sides);
                }
            }
            else if(command.equals("/flip")){
                if(message.equals("/flip")){ //must only say flip
                    message=flip();
                }  
            }
            else if(command.equals("/mute") && (message.split(" ").length==2)){
                    String blockeduser=message.split(" ")[1];
                    sender.block(blockeduser);
                    message= "_muted "+ blockeduser +"_";
                    sender.sendBlocked(getClientIdFromName(blockeduser));
            }
            else if(command.equals("/unmute") && (message.split(" ").length==2)){
                String unblockeduser=message.split(" ")[1];
                sender.unblock(unblockeduser);
                message= "_unmuted "+ unblockeduser +"_";
                //ccu3 paload block via serverthread
                sender.sendUnblocked(getClientIdFromName(unblockeduser));
            }
        }
        //ccu3 public message functionality markdown to html
        //ccu3 PRIVATE MESSAGE FUCTIONALITY
        if(message.toUpperCase().startsWith("@")){
            String mymessage= message.substring(1);
            String clientname= mymessage.split(" ")[0];
            String finalmessage= mymessage.replaceFirst(mymessage.split(" ")[0], "");
            sendPrivateMessage(sender, clientname, finalmessage);
            return;
        }
        else{
            sendPublicMessage(sender, message);
        }
    }

    //ccu3 private message

    //ccu3 get client id from name
    protected long getClientIdFromName(String name){
        long id;
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            // name = client from list
            if (client.getClientName().equals(name)){
                id = client.getClientId();
                return id;
            }
        }
        //fix if client not found
        return -1;
    }

    //ccu3 send public message
    protected void sendPublicMessage(ServerThread sender, String message){
        message = markdownConverter(message);
        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            // if sender does not exist in recipName.blockedlist then
            if (!client.getBlockedList().contains(sender.getClientName())){
                boolean messageSent = client.sendMessage(from, message);
                //ccu3 chatlog if(client.getClientName() == sender.getClientName() ){ .../ client.chatLog(message)}
                if (!messageSent) {
                    handleDisconnect(iter, client);
                }
            }
        }
    }
    //CCU3 sendprivate message
    protected void sendPrivateMessage(ServerThread sender, String recipName, String message){
        message = markdownConverter(message);
        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> it = clients.iterator();
        // if sender does not exist in recipName.blockedlist then // if !blockedlist.contains(long from)
        
        while (it.hasNext()) {
            ServerThread client = it.next();
            if (!client.getBlockedList().contains(sender.getClientName())){
                if(client.getClientName() == sender.getClientName() || client.getClientName().equals(recipName)){ 
                    //send message to client personally and show sender
                    String sentmessage= message+" [SENT PRIVATELY TO "+recipName.toUpperCase()+" ]";
                    client.sendMessage(from, sentmessage);
                }
            }
        }
    }

    //ccu3 flip function
    private String flip(){
        Random r = new Random();
        int chance = r.nextInt(2);
        if (chance == 1) {
           return"<span style=\"color:#8B008B\">_flipped coin_ <br>Result: tails</span>";
        } else {
           return"<span style=\"color:#8B008B\">_flipped coin_ <br>Result: heads</span>";
        }  
    }
    //ccu3 roll function
    private String roll(int dicenum,int dicesides){
        int result;
        String finalresult="";
        Random ran= new Random();
        //between
        for (int i=0;i<dicenum;i++){
            result = ran.nextInt(dicesides);
            int currdie=i+1;
            finalresult= finalresult+"Die"+currdie+"="+result+" ";
        }
        finalresult= "<span style=\"color:#8B008B\">_Rolled "+dicenum+" die/dice of "+dicesides+" sides_ <br>"+finalresult+"</span>";
        return finalresult;
    }
    //ccu3 handle markdown to html
    private String markdownConverter(String msg){
        String formatpattern = "(\\*([^*]){1,}\\*|\\_([^_]){1,}\\_|~([^~]){1,}~|\\&[r].{1,}\\&[r]|\\&[g].{1,}\\&[g]|\\&[b].{1,}\\&[b])";

        Pattern pattern = Pattern.compile(formatpattern);
        Matcher matcher = pattern.matcher(msg);
		String updatedmsg=msg;
        String replacement="";

    while(matcher.find()){
 		String trimmedmsg = matcher.group().substring(1,matcher.group().length()-1);
        if (matcher.group().startsWith("*")){
            replacement="<b>"+trimmedmsg+"</b>";
        }
        else if(matcher.group().startsWith("_")){
      	    replacement="<em>"+trimmedmsg+"</em>";
        }
        else if(matcher.group().startsWith("~")){
            replacement="<u>"+trimmedmsg+"</u>";
        }
        else if(matcher.group().startsWith("&")){
            trimmedmsg = matcher.group().substring(2,matcher.group().length()-2);
            //color
            if(matcher.group().startsWith("&r")){
                replacement="<span style=\"color:red\">"+trimmedmsg+"</span>";
            }
            else if(matcher.group().startsWith("&g")){
                replacement="<span style=\"color:green\">"+trimmedmsg+"</span>";
             }
            else if(matcher.group().startsWith("&b")){
                replacement="<span style=\"color:blue\">"+trimmedmsg+"</span>";
            }
        }
         updatedmsg = matcher.replaceFirst(replacement);
         matcher = pattern.matcher(updatedmsg);
    }
       // return msg+"\n Converted Message:"+updatedmsg;   
       return updatedmsg;
  }


    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}