package Module4.Part3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    protected String serverguide= "Commands: \n HELP - see all commands \n disconnect - disconnect from server\n SHUFFLE [message] - sends shuffled message to everyone \n DM [userid] [message] - message other client privately \n @all [message] - message all clients \n ***END OF COMMANDS***";
   
    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}
    
    protected synchronized void broadcast(String message, long id) {
        //disconnect command
        if(processCommand(message, id)){

            return;
        }

    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
            return true;
        }
        if(message.equalsIgnoreCase("help")){
            sendPrivateMessage(clientId, serverguide);
        } else
        if(message.startsWith("@all ")){
            sendPrivateMessage(clientId, "[you messaged everyone]");
            String publicmessage= "[PUBLIC] Client"+clientId+": "+message;
            sendPublicMessage(publicmessage);
            
        } else
        if(message.toUpperCase().startsWith("SHUFFLE ")){
            String mymessage= message.substring("SHUFFLE ".length());
            mymessage= shuffler(mymessage);
            String publicmessage= "[PUBLIC] Client"+clientId+": "+mymessage;
            sendPublicMessage(publicmessage);
        } else
        if(message.toUpperCase().startsWith("DM ")){
            String mymessage= message.substring(3);
            long recip= Long.parseLong(mymessage.split(" ")[0]);
            String strippedmessage= mymessage.replaceFirst(mymessage.split(" ")[0], "");
            relayPrivateMessage(clientId, recip, strippedmessage);
        }
        return false;
    }

    //FUNC FOR COMMANDS
    protected void messageAll(String message){
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }
    protected void relayPrivateMessage(long senderID, long recipID, String message){
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
          //  client.send("IT WORKS??");
            if(client.getId() == senderID){
               //send message to client personally
               String sentmessage= "[PRIVATE] YOU to "+recipID+ ": "+ message;
               client.send(sentmessage);
            }
            if(client.getId() == recipID){
                //send message to client personally
                String recmessage="[PRIVATE] From "+senderID+ " to YOU: "+ message;
                client.send(recmessage);
            }
        }
    }
    protected void sendPrivateMessage(long clientId, String message){
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            if(client.getId() == clientId){
               //send message to client personally
               client.send(message);
               break;
            }
        }
    }
    protected void sendPublicMessage(String message){
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
               //send message to all clients in array
               client.send(message);
        }
    }
    //ccu3
    protected static String shuffler(String message){
        List<String> characters = Arrays.asList(message.split(""));
        Collections.shuffle(characters);
        String afterShuffle = "";
              for (String character : characters){
                    afterShuffle += character;
              }
        return afterShuffle;
    }
    //end of my changes
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}
