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

public class ex212client
{
    private int port;
    private InetAddress host;

    public ex212client()
    {
        try
        {
            port = 7777;
            host = InetAddress.getByName("MSI-GT70");
        }
        catch(UnknownHostException e)
        {
            err.println(e.getMessage());
            exit(1);
        }
    }

    public void run()
    {
        try (Socket socket = new Socket(host, port);
            PrintWriter printWriter =
                    new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(in)))
        {
		    String input;
		    do
            {
                out.println(bufferedReader.readLine());
                out.print("Enter a message ('q' to Quit): ");
                input = inputReader.readLine();
                printWriter.println(input);
            }
            while (!input.toUpperCase().equals("Q"));
		    out.println("\nShutting down...");
        }
        catch(IOException e)
        {
            err.println(e.getMessage());
            e.getStackTrace();
            exit(1);
        }
    }

    public static void main(String[] args)
    {
       new ex212client()
               .run();
    }
}