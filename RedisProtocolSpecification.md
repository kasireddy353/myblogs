
What is Redis?

As we all know, redis is a in-memory data structure store used as a cahce (or maybe a database ) to store wide variety of data structures like Sets, Maps, hashes, strings etc.

How redis works?

To understand this, we must first understand what is a file descriptor and socket. 

<b>Socket</b> is just an endpoint of two way communication between a client and server. The endpoint we are referring to is combination of IP address and port number. So, in other words when we want to open a new connection with the remote server, the client should be aware of IP address and port (excluding few standard protocols like HTTP, HTTPS as they operate on a standard port. For instance, HTTP uses port 80 and HTTPS uses port 443).

https://stackoverflow.com/questions/3329641/how-do-multiple-clients-connect-simultaneously-to-one-port-say-80-on-a-server

Lets understand this a little more. What happens when you type google.com on the web browser.

<b>Step1:</b> Your web browser engine (every browser has it own engine running in the background. For instance Blink for chrome) forwards the request to TCP/IP stack present on the Operating System.

<b>Step2:</b> The TCP/IP stack takes the request and resolves google.com to an IP address and then forms a TCP Packet. The TCP packet contains the below information.

  (Source IP, Source Port, Destination IP, Destination Port, Protocol)
   ----------------------
       (Socket) 
   
   So essentially, socket is nothing but a virtual thing that the program uses to communicate over the network. Also, whenever    TCP stack opens a new connection with the remote server, it chooses a a random port on the client machine. If you are curious to know more about it, run the program <b>TCPServer.java</b> and use telnet to connect to the program and observer the port that is being used.




  
  
