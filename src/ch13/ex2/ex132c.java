package ch13.ex2;


import java.io.*;
import static java.lang.System.*;

/**
 * Project: ch13.ex2
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex132c
{
    public void start()
    {
        final int EOF = -1;
        int charCode;
        String inFilename,
                outFilename;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
        {
            out.print("Enter input filename: ");
            inFilename = input.readLine();
            out.print("Enter output filename: ");
            outFilename = input.readLine();

            try (FileReader inFile = new FileReader(inFilename);
                 FileWriter outFile = new FileWriter(outFilename))
            {
                while((charCode = inFile.read()) != EOF)
                    outFile.write(charCode);
            }
            out.println("File copy completed.");
        }
        catch (IOException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex132c().start();
    }
}
