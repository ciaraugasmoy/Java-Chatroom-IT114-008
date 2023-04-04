<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> Ciara Ugas-Moy (ccu3)</td></tr>
<tr><td> <em>Generated: </em> 4/4/2023 7:42:53 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/ccu3" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229933606-ba5384f4-a7c5-4dca-ac26-e90a34fad9b6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payloads CONNECT, CLIENT_ID, RESET_USER_LIST,<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229935128-e27ef49c-3c86-496c-b30e-2a527ef5bacd.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>CONNECT - when new client joins, sets name, gets name, DISCONNECT - when client disconnects removes them <br>MESSAGE - sends out message to client and server<br>CLIENT_ID - set id when client joins<br> RESET_USER_LIST - sent when new userjoins/ joins new room to update list<br>SYNC_CLIENT - client in synced to room updating the list <br>CREATE_ROOM - sent when client creates room to add new room to list <br>JOIN_ROOM - sent when client calls room to add client to room<br>GET_ROOMS - gets rooms when there are multiple rooms <br>READY - not used in chatroom<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229936637-953f32be-50b0-466a-a0a0-3416da341653.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payloads MESSAGE, SYNC_CLIENT, CREATE_ROOM, JOIN_ROOM,<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229945216-c587f078-4f78-44f7-860e-28003b500a81.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>use of payloads in serverthread<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229945387-3d429064-7f0f-46ec-bc6e-38f81f4c15a9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>use of payloads in client.java<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229683461-fddf5424-2e4b-4691-8e69-91b53e597a09.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code which checks for roll or flip command, code calls roll based on<br>the format of the command<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229683607-a0b965e6-e471-4b37-9e84-4ca0e4883ee1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>function roll which takes amount of dice and dice sides as input and<br>outputs result as string<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229685084-018985dc-ec53-4954-b3e5-d233cff4d794.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>flip function<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <div>My code first checks to see if the message starts with a slash<br>(/), then if the command is equal to "<b>/roll</b>" it gets the second<br>part of the command and if in format<b>&nbsp;/roll [number]d[number]</b> it sends the first<br>and second number as arguments to my function <b>roll()</b>, if it is in<br>format <b>/roll [number]</b>&nbsp;it sends 1 as the first argument for a single die<br>and the number as the second argument for how many sides. (Die sides<br>start at 0. If the die has 6 sides output will range from<br>0-5)</div><div>The roll function generates a random result based on how many sides the<br>die has, for each die and then returns the result as a string</div><div>If<br>the command is <b>/flip </b>then the function flip() is called. This function randomly<br>generates a number between 0 and 1 and returns heads or tails respectively<br>as string.</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling via markdown or special characters</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229685884-7244d8a0-3d26-4673-90f5-4c8485c4afc4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>markdown converter function<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229686005-c92bd226-e348-4895-b3cb-e46a3832b7d9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>markdown converter function being called before sending message out to everyone<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229689971-e60e316d-6c4a-4f5f-860b-0d0f5668b1f0.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>output showing clients messages with markdown converted and outputted with appropriate html tags<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/98501033/229690444-5321819a-264f-4555-b00f-638622bb06ae.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>demonstration of nested tags after conversion of nested markdown<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <div>Format , markdown</div><b>bold</b> = *bold*<div><i>italics</i> = _italics_</div><div><u>underline</u>&nbsp;= ~underline~</div><div>red,green,blue = &amp;rtext&amp;,&amp;gtext&amp;,&amp;btext&amp;</div><div><br></div><div>I used regex to<br>find if any of the markdown patterns were found, and replaced each section<br>with the appropriate HTML tags which would produce the equivalent expected output.</div><div>Tags can<br>be nested as whenever the outer markdown patterns are replaced the loop checks<br>the updated message and seeks any remaining regex matches to my markdown.</div><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="https://user-images.githubusercontent.com/54863474/211707773-e6aef7cb-d5b2-4053-bbb1-b09fc609041e.png"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/ciaraugasmoy/IT114-008/pull/6">https://github.com/ciaraugasmoy/IT114-008/pull/6</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-008-S23/it114-chatroom-milestone-2/grade/ccu3" target="_blank">Grading</a></td></tr></table>