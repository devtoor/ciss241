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


public class ex213server
{
    private int port;

    public ex213server()
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
        try (DatagramSocket datagramSocket = new DatagramSocket(port))
        {
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);

            String response = "Message received!!";
            DatagramPacket outPacket;

            while (true)
            {
                datagramSocket.receive(inPacket);
                String input = new String(inPacket.getData(), 0, inPacket.getLength());

                if (input.toUpperCase().equals("Q"))
                    break;

                out.println(input);

                outPacket = new DatagramPacket(response.getBytes(), response.length(),
                        inPacket.getAddress(), inPacket.getPort());
                datagramSocket.send(outPacket);
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
        new ex213server()
                .run();
    }
}