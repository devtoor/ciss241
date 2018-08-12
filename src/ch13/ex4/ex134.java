package ch13.ex4;

import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

/**
 * Project: ch13.ex4
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex134
{
    private String sourceFilename;
    private String outputFilename;

    public void start()
    {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(in)))
        {
            out.print("Enter source filename: ");
            sourceFilename = console.readLine();
            out.print("Enter output filename: ");
            outputFilename = console.readLine();
            scanFile();
        }
        catch (IOException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }

    private void scanFile() throws IOException
    {
        try (Scanner inFile = new Scanner(new FileReader(sourceFilename));
             PrintWriter outFile = new PrintWriter(outputFilename))
        {
            while (inFile.hasNext())
            {
                if (inFile.hasNextInt())
                    outFile.println(toCelsiusFormat(inFile.nextInt()));
                else
                    outFile.printf("Invalid entry: \"%s\"\n", inFile.next());
            }
            out.println("\nProcess completed successfully!");
        }
    }

    private String toCelsiusFormat(int fah)
    {
        return String.format(fah + " Fahrenheit = %,.3f Celsius",
                (fah - 32) * 5.0 / 9.0);
    }

    public static void main(String[] args)
    {
        new ex134().start();
    }
}