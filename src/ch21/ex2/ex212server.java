package ch21.ex2;

import java.io.*;
import java.net.*;
import static java.lang.System.*;

/**
 * Project: ch21.ex2
 * Date:    4/19/2018
 *
 * @author Jay Morales
 */

public class ex212server
{
    private int port;

    public ex212server()
    {
        try
        {
            InetAddress host = InetAddress.getLocalHost();
            port = 7777;
            out.println("Server address: " + host);
            out.println("Port: " + port);
            out.println();
        }
        catch(UnknownHostException e)
        {
            err.println(e.getMessage());
            exit(1);
        }
    }

    public void run()
    {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter =
                     new PrintWriter(socket.getOutputStream(), true))
        {
            String input;
            printWriter.println("Connected!");
            while ((input = bufferedReader.readLine()) != null && !input.toUpperCase().equals("Q"))
            {
                out.println(input);
                printWriter.println("Message received!");
            }
            out.println("\nShutting down...");
        }
        catch(IOException e)
        {
            err.println(e.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex212server()
                .run();
    }
}