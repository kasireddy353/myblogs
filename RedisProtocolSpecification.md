
What is Redis?

As we all know, redis is a in-memory data structure store used as a cahce (or maybe a database ) to store wide variety of data structures like Sets, Maps, hashes, strings etc.

How redis works?

To understand this, we must first understand what is a file descriptor and socket. 

Socket is just an endpoint of two way communication between a client and server. The endpoint we are referring to is combination of IP address and port number. So, in other words when we want to open a new connection with the remote server, the client should be aware of IP address and port (excluding few standard protocols like HTTP, TTTPS).

https://stackoverflow.com/questions/3329641/how-do-multiple-clients-connect-simultaneously-to-one-port-say-80-on-a-server

Lets understand this a little more. What happens when you type google.com on the web browser.
