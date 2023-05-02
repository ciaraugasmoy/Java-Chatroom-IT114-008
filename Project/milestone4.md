<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone4</td></tr>
<tr><td> <em>Student: </em> Ciara Ugas-Moy (ccu3)</td></tr>
<tr><td> <em>Generated: </em> 5/1/2023 10:35:34 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone4/grade/ccu3" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Client can export chat history of their current session (client-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot of related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235377144-60d354f9-4c35-4999-88bf-366664b73b09.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>UI for user alice showing export button on top<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235377190-a9ef034e-a79e-427d-9e33-01f17cbc261d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>UI for user jane showing export button at top<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot of exported data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235377180-077d8e99-32fc-4f2c-93c1-2d815a3345be.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>exported chat file for alice<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235377205-74e92f3a-5d8f-4290-b8f1-9e8821aab676.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>exported chat file for jane including the private messages sent to and from<br>her<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235377673-23561721-93a3-4cc0-ba7d-3e77d80c6a76.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>A)  files stored in chatlog B) code for onclick export button C)<br>code which adds button to the top of panel<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>In chatpanel.java I created a variable Stringbuilder&nbsp;<i style=""><b>mychatlog </b></i>which stores the messages sent<br>and received by the user with a &lt; br &gt; tag in between<br>each message appended.<div>I created an export button and added it to the top<br>of the chat panel. On click the button creates a new html file<br>(named based on the date and time of export) and writes the chatlog<br>to the file (as well as HTML opening and closing tags). These files<br>are stored in the folder project/client/chatlog/...</div><div><br></div><div><br></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Client's mute list will persist across sessions (server-side) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot of how the mute list is stored</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235378018-f9cf28ac-75c4-4777-b111-3a1e998d15a2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>user ciara rejoins lobby and user alice remains muted<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235378097-3ed042f4-03f4-4762-910d-78293b969630.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>blocklists (mutelists) are stored as textfiles named by the muter/blocker and stored in<br>the folder blocklists under folder server<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the code saving/loading mute list</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235378177-957802f8-cf12-4c12-955a-ba40de25c08d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code showing functions to initialize blockedlist from file when client is connected, and<br>code to update the file when client adds or removes users off their<br>list<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235378244-1503a161-0ee6-42ff-9129-598cdbe5f64f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>function which updates file called when block and unblock function is called<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>When the client connects, if a file already exists the contents of the<br>file is read in through to an ArrayList storing the blocked users by<br>the function initBlockedList. The list is stored in the format [name,name,name] so it<br>is split via regex as an array and then looped through to add<br>each name to the list.<div>When a client is muted or unmuted the name<br>is added or removed from the arrayList <b>blocklist </b>and after the updateBlockList function<br>is called which simply overwrites the file with the updated blocklist (blocklist.toString());</div><div><br></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Client's will receive a message when they get muted/unmuted by another user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add a screenshot showing the related chat messages</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235378710-8def64ad-9cb0-4604-aac4-fafe855a2839.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>user maria can see when she is muted by user ciara<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add a screenshot of the related code snippets</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235563009-ca3ebd72-9013-4b76-987a-a4cfa7c4fd7f.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>when messages begin with the command mute or unmute, the sender of the<br>message adds/removes a specific name from their blocklist(mutelist), and then then a message<br>informing that the user is muted/unmuted is sent out<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235563369-749eb757-c6ff-4531-afa7-1ba32cc40ccc.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>helper function which gets the current id for user blocked by name<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p>Within the <b>sendMessage</b> function, the string message is checked if it begins with<br>/mute or /unmute and the senders mutelist is updated from the function unblock/block<br>(called from serverthread). After the string&nbsp;<b>message</b> is updated to show that the specific<br>client has muted a certain client. A payload is then sent BLOCK or<br>UNBLOCK respectively from serverthread by passing the blocked clientid. The updated message is<br>then and is sent to everyone in the room.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> User list should update per the status of each user </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot for Muted users by the client should appear grayed out</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235563831-2a4a3a72-a2cd-4b74-a0c5-8d07b0bb9b7d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>A) those muted by user ciara shown in grey B)all users are informed<br>that user ciara muted user tyler C) other users do not have the<br>same muted list<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235564452-ca6b3c2c-a1b2-4959-94e8-715684f6a501.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>multiple users with different mutelists<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot for Last person to send a message gets highlighted</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235564670-afec5843-ced1-414e-802a-a7cadda82f0c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>multiple users see user alex sent the last message<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235564753-2e656c51-235f-48f4-94d4-2e253e8003b5.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>multiple users see that user ciara sent the last message<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/235565056-bb366956-90cd-485d-962b-bf75fb4f4ef1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>all users see that anna sent the lest message, except for user ciara<br>who has blocked user anna and therefore alex is highlighted as the last<br>message user ciara received was from user alex<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain how you implemented this</td></tr>
<tr><td> <em>Response:</em> <p><b>Room</b><div>on clients connecting, BLOCK/UNBLOCK payloads are sent for pre-existing blocklists. These payloads are<br>also sent if the client uses mute/unmute commands<br><div><b>Client</b></div><div>if the payload is BLOCK/UNBLOCK the<br>muted/unmuted client id is sent to a function in the clientUI to handle<br>the display of this client. <b>(blocked users in grey)</b></div><div>also MESSAGE payloads call a<br>function to the UI upon receiving a message from a specific client. <b>(last<br>sender of message in red)</b></div><div><b>ClientUI</b></div><div>On receiving the client ID of the blocked/unblocked user,<br>a function in chatpanel is called to repaint the appearance of the given<br>blocked user in userlist</div><div>on receiving a message, the clientid of the last sender<br>is sent to a function in chatpanel to update the appearance of the<br>userpanel for all those who received the message (thereby excluding muted users as<br>the mutee simply would not have gotten the message)</div><div><b>ChatPanel</b></div><div>calls respective functions in userpanel<br>to update the appearance based on whether the user is blocked/unblocked, or is<br>the last sender for given recipient</div><div><b>Userpanel</b></div><div>repaints the component that holds username grey if<br>muted, black if unmuted. The message payload is always called after so this<br>component is painted red if they are the last sender of message for<br>the recipient, else the components are painted black, if not already muted (grey).<br><div><br></div></div></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone4/grade/ccu3" target="_blank">Grading</a></td></tr></table>