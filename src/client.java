import java.io.*;
import java.net.*;
public class client
{
    private InetAddress host;
    private int port;
    public client()
    {
        try
        {
            host = InetAddress.getLocalHost();
            System.out.println(host);
            System.out.println(host.getHostName());
            port = 7777;
        }
        catch(UnknownHostException ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    public void run() throws IOException
    {
        try
        {
            BufferedReader brin = new
                    BufferedReader(new InputStreamReader(System.in));
            DatagramSocket client = new DatagramSocket();
            String numbers;
            System.out.print("Enter some doubles: ");
            numbers = brin.readLine();
            DatagramPacket outdgp = new
                    DatagramPacket(numbers.getBytes(),
                    numbers.length(), host, port);
/* create DatagramPacket object from user input
numbers */
            client.send(outdgp);
// send the DatagramPacket from DatagramSocket
            byte[] buffer = new byte[256];
// continued23
            DatagramPacket indgp = new
                    DatagramPacket(buffer, buffer.length);
// DatagramPacket for input back - average
            client.receive(indgp); // receive from server
            String rsp = new String(indgp.getData(), 0,
                    indgp.getLength());
// convert incoming DataPacket to String
            System.out.println(rsp);
            client.close();// close socket
        }
        catch(IOException iox)
        {
            System.out.println(iox);
            iox.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        try
        {
            new client().run();
        }
        catch (UnknownHostException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}