package as4;

import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.util.Scanner;
import static java.lang.System.*;

/**
 * Project: Read File Over Network Onto Screen
 * Date:    4/24/2018
 *
 * Purpose:
 *      This program will read a file over a network from a server and display the file
 *      on the screen of the client. It will use a TCP/IP stream socket connection
 *      between a server and a client. The implementation is flexible so it can run on
 *      two computers at the same network or on the same computer running separately.
 *      In addition, the class implements <code>Runnable</code> to provides the means
 *      for a class to be active while not subclassing <code>Thread</code>.
 *
 *      The server program will use a port number for a connection with clients. The
 *      connection will use the server's host address. The server program will send
 *      a data of a file to the client upon request of the file's name. If the file
 *      doesn't exist it will send a error response back to the client.
 *
 * @author Jay Morales
 */

public class server implements Runnable
{
    /**
     * The general contract of the method run is that it may take any action whatsoever.
     */
    @Override
    public void run()
    {
        InetAddress host;                   // Represents an IP address of the local host
        final int port = 8888;              // Port number to be allocated
        String relativePath = "src/as4/";   // Relative path of my assignment folder
        String filename;                    // Filename of request file

        // Creates a server socket, bound to the specified port.
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            // Get the name and address of the local host and display information
            host = InetAddress.getLocalHost();
            out.println("Server name: " + host.getHostName());
            out.println("Server address: " + host.getHostAddress());
            out.println();

            log("Server is online");        // log activity

            // Infinite loop to remain active, the server can only accept one client at a time
            while (true)
            {
                log("Waiting for request");     // log activity

                try (Socket socket = serverSocket.accept())
                {
                    InputStreamReader inStream = new InputStreamReader(socket.getInputStream());
                    OutputStreamWriter outStream = new OutputStreamWriter(socket.getOutputStream());

                    try (BufferedReader inputSocket = new BufferedReader(inStream);
                         PrintWriter outputSocket = new PrintWriter(outStream, true))
                    {
                        log("Connected to: " + socket.getRemoteSocketAddress());    // log activity

                        // Signal the client that the connect is successful
                        outputSocket.println("Successfully connected to the server.");

                        // Wait for the filename
                        filename = inputSocket.readLine();

                        log("Requested file: " + filename);     // log activity

                        try (Scanner inputFile = new Scanner(new FileReader(relativePath + filename)))
                        {
                            outputSocket.println("==================== Text Start ====================");
                            while (inputFile.hasNextLine())
                            {
                                // Read a line from the file and write it over the socket
                                outputSocket.println(inputFile.nextLine());
                            }
                            outputSocket.println("==================== Text End ====================");

                            log("Request successfully sent");   // log activity
                        }
                        catch (FileNotFoundException e)
                        {
                            String error = "The named file does not exist.";

                            log(error);                     // log activity
                            outputSocket.println(error);    // Sent back error response to the client
                        }
                    }
                }
                catch (SocketTimeoutException e)
                {
                    err.println("Timeout was previously set with setSoTimeout and the timeout has been reached.");
                    exit(1);
                }
            }
        }
        catch (UnknownHostException e)
        {
            err.println("The local host name could not be resolved into an address.");
            exit(1);
        }
        catch (IOException e)
        {
            e.getStackTrace();
            err.println(e.getMessage());
            exit(1);
        }
    }

    /**
     * This method primarily for logging server activity
     * @param str Output remarks
     */
    private static void log(String str)
    {
        out.println(new Timestamp(System.currentTimeMillis()) + "\t" + str);
    }

    /**
     * The class main method is the entry point of an executable program,
     * it is where the program control starts and ends.
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        new Thread(new server())
                .start();
    }
}
