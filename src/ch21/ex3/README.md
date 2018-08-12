21-3

Redo Exercise 21-2 but write the server and client program using a datagram socket. If possible, again use a group of 2 or more student. One student will run the server, the other students can be the clients. 

a. The server will run (list the host name and decide on a port number for the clients) and listen for a message from clients. It will accept that message as a part of a datagram packet and print the message to the screen. It will then send back a packet saying the message was received.

b. The client(s) will run and send a message to the server as a part of a datagram packet. It will use the server's host name and port number.  Again, use the `getByName()` with the server computer's name for the host. It will then receive a packet back saying the message was received.

Here are the server and client.  Fill in the missing part of the run() method for both files.

Server:

```java
package net21;
/* Bill Wohlleber
 * Exercise 21-2 server
 * This program will be a server to receive messages from a client
 * using TCP/IP socket
 */
import java.io.*;
import java.net.*;

public class ex213server
{
    private InetAddress host;
    private int port;

    public ex213server()
    {
        try
        {
            host = InetAddress.getLocalHost(); // host computer
            port = 7777;   // wait on port 7777
            System.out.println("Server address is " + host);
            System.out.println("Port is " + port);
        }
        catch(UnknownHostException u)
        {
            u.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            /* Create DatagramSocket connected to port, create byte array, create
             DatagramPacket for byte array.  Wait to receive packet, then get the
             message and sender address from the packet.  Print to screen who the
             sender is, what the sender's name is, and what the message is.  Close
             the socket.
          	*/

        }
        catch(SocketException ss)
        {
            ss.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ex213server s = new ex213server();
        s.run();
    }
}
```

Client:

```java
package net21;
/* Bill Wohlleber
 * Exercise 21-2 client
 * This program will be a client to send messages to a server
 */
import java.io.*;
import java.net.*;

public class ex213client
{
    private int port;
    private InetAddress host;

    public ex213client()
    {
        try
        {
            port = 7777;  // server's port number
            //     host = InetAddress.getByName("bt20402.hvcc.edu"); // if at school
            // fill in your server's computer name
            //       host = InetAddress.getLocalHost(); // same computer as server, but use server's name instead
        }
        catch(UnknownHostException u)
        {
            u.printStackTrace();
        }
    }

    public void run(String mes)
    {
        try
        {
         /* Create DatagramSocket, create DatagramPacket out of message and who
         the host and port are.  Send the packet.  Create byte array and the
         DatagramPacket for the byte array.  Receive the incoming packet.  Get
         the message out of the packet and print it to the screen.  Close the socket
  		*/

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        String line;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a message:  ");
        line = br.readLine();

        ex213client c = new ex213client();
        c.run(line);  // send message to run()
    }
}
```



