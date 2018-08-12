package ch21.ex3;

import java.io.*;
import java.net.*;
import static java.lang.System.*;

/**
 * Project: ch21.ex3
 * Date:    4/19/2018
 *
 * @author Jay Morales
 */


public class ex213client
{
    private int serverPort;
    private int clientPort;
    private InetAddress host;

    public ex213client()
    {
        try
        {
            serverPort = 7777;
            clientPort = 7878;
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
        try (DatagramSocket datagramSocket = new DatagramSocket(clientPort);
             BufferedReader inputReader = new BufferedReader(new InputStreamReader(in)))
        {
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);

            String input;
            DatagramPacket outPacket;

            while (true)
            {
                out.print("Enter a message ('q' to Quit): ");
                input = inputReader.readLine();

                outPacket = new DatagramPacket(input.getBytes(), input.length(), host, serverPort);
                datagramSocket.send(outPacket);

                if (input.toUpperCase().equals("Q"))
                    break;

                datagramSocket.receive(inPacket);
                String response = new String(inPacket.getData(), 0, inPacket.getLength());
                out.println(response);
            }
            out.println("\nShutting down...");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new ex213client()
                .run();
    }
}