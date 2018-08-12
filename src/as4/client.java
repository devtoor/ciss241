package as4;

import java.io.*;
import java.net.*;
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
 *      This client program will prompt the user to enter the server's host name or
 *      address and the server's preassigned port number for a connection. Then the user
 *      will also be prompted to enter the filename of the file to fetch. The file then be
 *      read back over the network and displayed on the console.
 *
 * @author Jay Morales
 */

public class client implements Runnable
{
    /**
     * The general contract of the method run is that it may take any action whatsoever.
     */
    @Override
    public void run()
    {
        final Scanner scanner = new Scanner(in);    // Object that produces values scanned from the specified input stream
        final InetAddress server;                   // Represents an IP address of the server
        final int port;                             // Port number to be to access

        try
        {
            // Ask the user to enter server's name or address
            out.print("Enter the server's host address or name (if empty the address of the loopback interface is used): ");
            server = InetAddress.getByName(scanner.nextLine());

            // Ask the user to enter the preassigned port number
            out.print("Enter port number: ");
            port = Integer.parseInt(scanner.nextLine());

            // Create a connection to the server
            try (Socket socket = new Socket(server, port))
            {
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                try (BufferedReader inputSocket = new BufferedReader(inputStreamReader);
                     PrintWriter outputSocket = new PrintWriter(outputStreamWriter, true))
                {
                    out.println("\n" + inputSocket.readLine());

                    // Ask the user to enter the filename
                    out.print("Enter filename: ");

                    outputSocket.println(scanner.nextLine());
                    out.println();
                    String input;

                    // Scan the response and display the result
                    while ((input = inputSocket.readLine()) != null)
                    {
                        out.println(input);
                    }
                }
            }
        }
        catch (UnknownHostException e)
        {
            err.println("No IP address for the host could be found.");
            exit(1);
        }
        catch (NumberFormatException e)
        {
            err.println("Input is not a valid port number");
            exit(1);
        }
        catch (IllegalArgumentException e)
        {
            err.println("The port is outside the specified range of valid port (0 - 65535), inclusive.");
            exit(1);
        }
        catch (IOException e)
        {
            err.println(e.getMessage());
            e.getStackTrace();
            exit(1);
        }
    }

    /**
     * The class main method is the entry point of an executable program,
     * it is where the program control starts and ends.
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        new Thread(new client())
                .start();
    }
}
