package ch13.ex3;

import java.io.*;
import static java.lang.System.*;

/**
 * Project: ch13.ex3
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex133
{
    private String filename;

    public void start()
    {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(in)))
        {
            out.print("Enter out filename: ");
            filename = console.readLine();

            writeToFile(console);
            readFromFile();
        }
        catch (IOException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }

    private void writeToFile(BufferedReader console) throws IOException
    {
        try (DataOutputStream file = new DataOutputStream(new FileOutputStream(filename)))
        {
            do {
                out.print("Enter employee name: ");
                file.writeUTF(console.readLine());

                out.print("Enter employee number: ");
                file.writeInt(Integer.parseInt(console.readLine()));

                out.print("Enter 'Q' to quit or any key to continue: ");
                String strInput = console.readLine();
                if (!strInput.isEmpty() && strInput.length() == 1)
                {
                    char charInput = strInput.charAt(0);
                    if (charInput == 'Q' || charInput == 'q')
                        break;
                }
            }
            while (true);
        }
    }

    private void readFromFile() throws IOException
    {
        try (DataInputStream file = new DataInputStream(new FileInputStream(filename)))
        {
            out.println("\n====== OUTPUT ======");
            do {
                try
                {
                    out.print(file.readUTF() + " ");
                    out.println(file.readInt());
                }
                catch (EOFException e)
                {
                    break;
                }
            }
            while (true);
        }
    }

    public static void main(String[] args)
    {
        new ex133().start();
    }
}
