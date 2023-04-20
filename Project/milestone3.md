<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone3</td></tr>
<tr><td> <em>Student: </em> Ciara Ugas-Moy (ccu3)</td></tr>
<tr><td> <em>Generated: </em> 4/19/2023 11:39:43 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/ccu3" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone3 from the proposal document:&nbsp;&nbsp;<a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Connection Screens </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the screens with the following data</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233197555-e1ea1b50-fc5c-4094-9f9a-864720259db1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>host and port shown in the UI<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233197749-39d94982-3518-4090-8077-f9cb15185f12.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>user entering username in UI<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233198068-11de03d3-d707-4c7d-aba4-11899a69d995.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>first client entering lobby, username shown at the top of window, and client<br>shown at the side<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain the code for each step of the process</td></tr>
<tr><td> <em>Response:</em> <div><b>Host &amp; Port shown</b></div><div><ol><li>An instance of the class ConnectionPanel&nbsp; (extends Jpanel) is created<br>by the client UI upon clicking the Jbutton "next".&nbsp;</li><li>The port value and host<br>value are retrieved from the text field and returned to the UI through<br>the functions getHost and getPort (called in the connect function in ClientUI to<br>connect the client itself).</li></ol></div><div>Client Entering username</div><div><br></div><div>Client entering room</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Chatroom view </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing the related UI</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233234555-7dcb3b9b-c7cc-4ee4-9d32-3401ddc4cad1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>list of user in room on right, chat message area with chat history<br>on left, create message area on bottom, send message button on bottom right<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233240589-6fc29e03-7b8e-4e2b-ba3b-90363c8eeab6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>snippet for the code puts the message through UI to chat panel<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233241123-b1322ad9-bfb8-4560-89e0-54aa68101fab.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>snippet of code which listens for input to jbutton &quot;send&quot; to send message<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Chat Activities </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show screenshots of the result of the following commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233244112-edaa96cf-03bc-4a3e-9c10-8921deed518c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client using roll command of both formats and flip command, client also incorrectly<br>typing command (command not executed when incorrectly typed). Results output in magenta<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the code snippets for each command</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233246241-c62f27ba-ce50-4f4c-b6dd-ca329db76a99.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>processing command &quot;/flip&quot; , &quot;/roll #&quot; and &quot;roll #d#&quot;<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233246622-98eff346-5c09-44ee-be4d-fb07b7c1ce1b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>processing roll and flip commands and returning output as message<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code flow of each command</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Custom Text </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of examples</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233248429-3add9973-a18d-4702-829f-2e26c8f3d34c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>output showing bold, italics, underline, red, green and blue colors as well as<br>the effects combined<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how you got the UI side to render the text accordingly</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Whisper </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots showing a demo of whisper commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233248954-3fa46e35-edb8-4ff1-b2fd-9cf5f93499f2.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>message sent from ciara to alicia privately<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233249255-01603bd7-7de2-4ddb-916d-af83e80b595d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>message sent from gabby to ciara privately, with text that would trigger this<br>whisper feature in the input box below<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show the server-side code snippets of how this feature works</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233249582-b551be8d-2a18-4e50-be1d-3a992d9d7160.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>processing of command beginning with @. Regex used to split string to input<br>the recipient of the message and message into the private message function<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233249855-975555d5-32da-46d1-8274-7741936e2c43.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>private message function which finds the recipient and sender showing the message to<br>only them, if the recipient has not muted the sender<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 6: </em> Mute/Unmute </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707834-bf5a5b13-ec36-4597-9741-aa830c195be2.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshots demoing this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233250621-f751b6e9-5996-4b45-aa0f-839f584fd883.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>anna muted ciara and cannot recieve messages from her. When ciara sends messages<br>only gabby will see, when she tries to send messages privately anna still<br>will not see them<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233251233-55b11954-bbde-4307-9ccc-3d03af0db19a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>anna unmuted ciara. ciara can now send both public and private messages which<br>anna will see<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshots of the code snippets that achieve this feature</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233251669-dcfc64ea-10e1-4d3b-bdfb-0b96448b63a3.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>command to add or remove person from muted list (blockedlist) processed. Room uses<br>functions from serverthread<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233251806-53005d4a-a54b-4055-ba6f-5c5d7243bd35.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client cannot recieve messages from user in blocked/muted list publicly (room)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233251981-d376c1c3-bdfa-4b31-a3e1-daa419cf6aa6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client cannot recieve messages from user in blocked/muted list privately (room)<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/233252097-ab0f24a7-3453-4b96-bb97-33eb473bbcf4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>blockedlist declared in server thread, functions to add name or remove name from<br>blocked list (muted list)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the code logic of how this was achieved</td></tr>
<tr><td> <em>Response:</em> <p>(missing)</p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 7: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull request from milestone3 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ciaraugasmoy/IT114-008/pull/7">https://github.com/ciaraugasmoy/IT114-008/pull/7</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone3/grade/ccu3" target="_blank">Grading</a></td></tr></table>