package as1;
// package files13;

import java.io.*;
import static java.lang.System.*;

/**
 * Project: Yankees File Streams
 * Date:    2/27/2018
 *
 * This program will read an entire record (an object from yankees.yanks file) and
 * convert each object fields into a character stream
 *
 * @author Jay Morales
 */

public final class yankeesfile
{
    /**
     * An Object method that read the the entire record of yankees object from the file
     * (yankees.yanks), and convert each object's field to an array of characters then
     * write each character to the file (yankees.txt) one character at a time.
     * The output separate each record in line; and a space between each field and a
     * line feed at the end of each record.
     * @throws IOException Any of the usual Input/Output related exceptions.
     * @throws ClassNotFoundException Class of a serialized cannot be found.
     */
    private void start() throws IOException, ClassNotFoundException
    {
        final int LINE_FEED = 10;   // Char code for line feed or new line
        final int SPACE = 32;       // Char code for space
        yankees player;             // Holds the player object

        // Try-with-resources to ensure that each resources is closed at the end of the try block or
        // in case of an exception.
        try (ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("yankees.yanks"));
            OutputStream outFile = new FileOutputStream("yankees.txt"))
        {
            while (true)
            {
                try
                {
                    player = (yankees) inFile.readObject();

                    // Convert <name> to an array of characters, then write one character at a time.
                    for (char character : player.getname().toCharArray())
                        outFile.write(character);

                    outFile.write(SPACE);

                    // Convert <pos> to an array of characters, then write one character at a time.
                    for (char character : player.getpos().toCharArray())
                        outFile.write(character);

                    outFile.write(SPACE);

                    // Convert <num> to String first, then to an array of characters,
                    // then write one character at a time.
                    for (char character : String.valueOf(player.getnum()).toCharArray())
                        outFile.write(character);

                    outFile.write(LINE_FEED);
                    outFile.flush();    // Forces any buffered output bytes to be written out.
                }
                catch (EOFException e)
                {
                    break; // If EOF found, break the loop
                }
            }
        }
    }

    /**
     * The class main method is the entry point of an executable program,
     * it is where the program control starts and ends.
     * Roughly 46-55ms for each iteration of 10 objects to read and write to the file
     * in a clean run.
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        try
        {
            new yankeesfile().start();
        }
        catch (IOException | ClassNotFoundException e)
        {
            err.println("Error: " + e.getMessage());
            e.printStackTrace();
            exit(1);
        }
    }
}