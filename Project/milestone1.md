<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> Ciara Ugas-Moy (ccu3)</td></tr>
<tr><td> <em>Generated: </em> 3/11/2023 8:36:41 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/ccu3" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><ol><li>You will be updating this folder with new code as you do milestones</li><li>You won't be creating separate folders for milestones; milestones are just branches</li></ol><li>Create a milestone1.md file inside the Project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example of the lessons</li><ol><li>Recommended Part 5 (clients should be having names at this point and not ids)</li><li><a href="https://github.com/MattToegel/IT114/tree/Module5/Module5">https://github.com/MattToegel/IT114/tree/Module5/Module5</a>&nbsp;<br></li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224507958-99fdeebb-80ea-4ac5-8321-74db44477637.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server is listening on port 3000 from the terminal<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224508086-aff4851a-b224-4175-a292-698065226c74.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client waiting for input before connecting<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224508133-f41e4362-ee1a-4fc9-9c4b-81116d587dd5.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client connecting to server after setting name, server creating default room lobby upon<br>client connecting<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <p>The server starts up creating a new socket binds an address (port 3000).<br>The server then waits listens for input from clients.<div><br><div>Upon starting a new thread<br>is created, the client takes input but only connects to server (connect function)<br>if given a a command to do so in the correct format (/connect<br>localhost:3000) AND a name is already set (/name [name]). The connect function creates<br>a new socket using the same port</div></div><div>On the server side, the socket is<br>first created via the socket function and binded to an address (port number<br>on localhost). The server then listens for and accepts incoming client connections. On&nbsp;<br>the client side they connect using the correct address+port.</div><div><br></div><div><br></div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224508289-83f2e63b-236f-4687-9b9f-70ea613028ff.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>two clients connected to the server, each in the same room, sending messages.<br>Server broadcasts message to all clients showing their name before the message<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224508415-0e9210b8-5354-448e-981c-4152c6bd7e03.png"/></td></tr>
<tr><td> <em>Caption:</em> <ol>
<li>client ciara creates a new room, 2)client sends message in new room<br> and disconnects from the old one3) server only sends messages to client<br>in the new room, and the other client will only receive messages from<br>those in his respective room(the lobby)<br></li>
</ol>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <p>The client accepts input and valid input creates a new payload with the<br>payload type, message and respective client name. The payload type is set as<br>message, and the message is the given string inputted.<div>The server thread processes messages<br>based on the payload type, if the payload type is set as message<br>the message is sent to the current room. This message is then propagated<br>to all the other clients in the respective room via the sendMessage function<br>in room. This function works by iterating through all the clients. Each client<br>in the room is then shown the message</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224508653-b149bc26-c5ef-4380-8eef-0dbf4cb8ef9b.png"/></td></tr>
<tr><td> <em>Caption:</em> <ol>
<li>client disconnecting from server, 2)remaining client in room sees the other has<br>disconnected, 3) thread cleanup by server for disconnected client<br></li>
</ol>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/224508812-06b4ce7e-ed7e-45e8-a09c-8d977ea19170.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>server killed, clients disconnected from server but still running<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <p>If the client uses the command &quot;/disconnect&quot; or becomes disconnected by some other<br>means the socket close() function is used to close the socket used by<br>the respective thread. When the server shuts down the clients do not shut<br>down as they handle this by closing their sockets. The server doesn&#39;t crash<br>from clients disconnecting as the thread cleanup() fucntion ensures that clients sockets are<br>closed safely<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ciaraugasmoy/IT114-008/pull/5">https://github.com/ciaraugasmoy/IT114-008/pull/5</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about any issues or learnings during this assignment</td></tr>
<tr><td> <em>Response:</em> <p>java jdk did not successfully run the isBlank() string function<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-milestone1/grade/ccu3" target="_blank">Grading</a></td></tr></table>
