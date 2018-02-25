
<b>What is Redis?</b>

As we all know, redis is a in-memory data structure store used as a cache (or maybe a database ) to store wide variety of data structures like Sets, Maps, hashes, strings etc.

<b>How redis works?</b>

To understand this, we must first understand what is a file descriptor and socket. 

<b>Socket</b> is just an endpoint of two way communication between a client and server. The endpoint we are referring to is combination of IP address and port number. So, in other words when we want to open a new connection with the remote server, the client should be aware of IP address and port (excluding few standard protocols like HTTP, HTTPS as they operate on a standard port. For instance, HTTP uses port 80 and HTTPS uses port 443).

https://stackoverflow.com/questions/3329641/how-do-multiple-clients-connect-simultaneously-to-one-port-say-80-on-a-server

Lets understand this a little more. What happens when you type google.com on the web browser.

<b>Step1:</b> Your web browser engine (every browser has it own engine running in the background. For instance Blink for chrome) forwards the request to TCP/IP stack present on the Operating System.

<b>Step2:</b> The TCP/IP stack takes the request and resolves google.com to an IP address and then forms a TCP Packet. The TCP packet contains the below information, plus a lot more and sends the packet to the remote server.

      (<b>Source IP, Source Port</b>, Destination IP, Destination Port, Protocol)  
          --------Socket--------
          
      (111.111.11.1, 67543, 67.43.54.22, 443, TCP )
      
      The combination of SourceIP and Source Port is referred to as socket. In this case 111.111.11.1:67543 
      is a socket. So essentially, socket is nothing but a virtual thing that the program uses to communicate 
      over the network. Also, whenever    TCP stack opens a new connection with the remote server, it chooses 
      a random port on the client machine. If you are curious to know more about it, run the program 
      <b>TCPServer.java</b> and use telnet to connect to the program and observe the port that is being used.
   
<b>Step3:</b> The server machine accepts the packet sent from a client machine and checks if any program is listening on the destination port specified in the packet. If yes, it forwards the request to the program running on that specific port. In return, the server forms another TCP packet destined to the client.

      (Source IP, Source Port, Destination IP, Destination Port, Protocol)
      
      (67.43.54.22, 443, 111.111.11.1, 67543, TCP)
      
      Note: This is just a high level flow of how a socket is used to transfer data as there is lot more complexity 
      involved in exchanging information between two machines.


<b>Step4:</b> The same process happens again and agian until all the data is transferred between the machines.

  
  
