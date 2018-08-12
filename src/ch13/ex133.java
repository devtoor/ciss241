package ch13;

import java.io.*;
import static java.lang.System.*;

/**
 * Project: ch13
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public final class ex133
{
    private final int EOF = -1;         // End of file char code
    private final int LINE_FEED = 10;   // Line feed char code
    private String filename,
                    nameInput,          // Holds the employee's name
                    numInput;           // Holds the employee's number
    private int keyEntered;             // User's keystrokes

    // To disable no-arg constructor
    private ex133() {}

    /**
     * This method starts the process by asking for filename, it handles
     * the exceptions and the loop for input.
     */
    public void start()
    {
        try (BufferedReader console =
                     new BufferedReader(new InputStreamReader(in)))
        {
            out.print("\nEnter output filename: ");
            filename = console.readLine();
            out.println("\n======== INPUT =========\n");

            try (DataOutputStream file =
                         new DataOutputStream(new FileOutputStream(filename)))
            {
                do {
                    getNameInput(console);
                    getNumInput(console);
                    writeToFile(file);
                    out.println();
                }
                while (keyEntered != EOF);
            }
            readFromFile();
        }
        catch (IOException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }

    /**
     * This method will record keystroke inputs, and only stage alphabetic
     * characters for file writing. (Since name doesn't have numeric characters)
     * @param console Buffered stream attach to "standard" input stream.
     * @throws IOException If an I/O error occurs.
     */
    private void getNameInput(BufferedReader console) throws IOException
    {
        nameInput = "";
        out.print("Enter employee name: ");
        while ((keyEntered = console.read()) != LINE_FEED)
        {
            if (keyEntered == EOF)
                break;

            if (!Character.isDigit((char) keyEntered))
                nameInput = nameInput.concat(String.valueOf((char) keyEntered));
        }
    }

    /**
     * This method will record keystroke inputs, and only stage numeric
     * characters for file writing. If empty the default value is (0) zero.
     * @param console Buffered stream attach to "standard" input stream.
     * @throws IOException If an I/O error occurs.
     */
    private void getNumInput(BufferedReader console) throws IOException
    {
        if (keyEntered == EOF)
        {
            numInput = "0";
            return;
        }

        numInput = "";
        out.print("Enter employee number: ");
        while ((keyEntered = console.read()) != LINE_FEED)
        {
            if (keyEntered == EOF)
                break;

            if (Character.isDigit((char) keyEntered))
                numInput = numInput.concat(String.valueOf((char) keyEntered));
        }
        if (numInput.isEmpty())
            numInput = "0";
    }

    /**
     * This method write primitive Java data types to an output stream
     * in a portable way.
     * @param file The underlying output stream, to be saved for later use.
     * @throws IOException If an I/O error occurs.
     */
    private void writeToFile(DataOutputStream file) throws IOException
    {
        if (!numInput.equals("0") || !nameInput.isEmpty())
        {
            file.writeUTF(nameInput.trim());
            file.writeInt(Integer.valueOf(numInput));
            file.flush();
        }
    }

    /**
     * This method read primitive Java data types from an underlying input
     * stream in a machine-independent way.
     * @throws IOException If an I/O error occurs.
     */
    private void readFromFile() throws IOException
    {
        out.println("\n======== OUTPUT ========\n");
        try (DataInputStream file =
                     new DataInputStream(new FileInputStream(filename)))
        {
            while(true)
            {
                try
                {
                    out.printf("%-15s %8d\n", file.readUTF(), file.readInt());
                }
                catch (EOFException e)
                {
                    out.println();
                    break;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new ex133().start();
    }
}