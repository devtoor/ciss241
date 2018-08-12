21-2

Write a server and client program using a TCP/IP socket for the following. If possible, use a group of 2 or more student.  One student will run the server, the other students can be the clients. If doing lab exercise on your own, use the local host for the server and the server name for the client by using the `host = InetAddress.getByName()` method with the String argument being the server host name.

a. The server will run (list the host name and decide on a port number for the clients) and listen for a message from clients. It will accept that message and print the message to the screen. 

b. The client(s) will run and send a message to the server.  It will use the server's host name and port number. Try with a `PrintWriter` and with then with a `BufferedWriter` to try two examples of output streams.

Here are the server, client with a `PrintWriter`, and the client with a `BufferedWriter`. Fill in the missing part of the `run()` method for both files.

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

public class ex212server
{
    private InetAddress host;
    private int port;

    public ex212server()
    {
        try
        {
            host = InetAddress.getLocalHost(); // use server computer as host
            port = 7777;  // wait on port #7777
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
            /* Create ServerSocket and Socket.  Then create BufferedReader connected to Socket.
             Print where message is coming from and print the message.  Create a PrintWriter
             connected to the Socket, then send back a message over the Socket that the message
             was received.  Close all the Sockets.
          	*/
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        ex212server s = new ex212server();
        s.run();
    }
}
```

Client with `PrintWriter`:

```java
package net21;
/* Bill Wohlleber
 * Exercise 21-2 client
 * This program will be a client to send messages to a server
 */
import java.io.*;
import java.net.*;

public class ex212client
{
    private int port;
    private InetAddress host;

    public ex212client()
    {
        try
        {
            port = 7777; // use port #7777 that server is waiting on
            // if server was on campus btc instructor's console
            //   host = InetAddress.getByName("bt204in.hvcc.edu");
            //    host = InetAddress.getLocalHost(); // same computer as server

            // change name to printout of server's name - check server's printout       


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
		/* Create socket connected to host on port.  Create PrintWriter connected to
        socket and print message over socket.  Create BufferedReader connected to
        socket and print the string read over the socket to the screen.  Close
        the socket.
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

        ex212client c = new ex212client();
        c.run(line);  // call run method with string line to send to server
    }
}
```

Client redone with `BufferedWriter`:

```java
package net21;
/* Bill Wohlleber
 * Exercise 21-2 client
 * This program will be a client to send messages to a server
 */
import java.io.*;
import java.net.*;

public class ex212clientbw
{
    private int port;
    private InetAddress host;

    public ex212clientbw()
    {
        try
        {
            port = 7777; // host = InetAddress.getByName("bt20402.hvcc.edu");

            // if at school

            // host = InetAddress.getByName("bt204in.hvcc.edu");

            // instructor     
            // fill in your server's computer name
            // host = InetAddress.getLocalHost();
            // same computer as server, but use server's name instead   

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
       	/* Redo run() method from client with PrintWriter to change the output stream
         to a BufferedWriter.  Create Socket, BufferedWriter connected to Socket, write
         the message, flush the buffer, create BufferedReader connected to Socket to
         read message back, print that message back onto screen, close socket.
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

        ex212clientbw c = new ex212clientbw();
        c.run(line);
    }
}
```

