package ch13.ex5;

import java.io.*;
import static java.lang.System.*;

/**
 * Project: ch13.ex5
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex135
{
    public void start()
    {
        final int BYTES_PER_REC = 3;
        final int LETTERS_TO_READ = 5;
        final long INDEX_LIMIT;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(in)))
        {
            out.print("Enter filename: ");
            try (RandomAccessFile file = new RandomAccessFile(input.readLine(), "r"))
            {
                out.print("Enter record number: ");
                file.seek((Long.parseLong(input.readLine()) - 1) * BYTES_PER_REC);
                INDEX_LIMIT = file.getFilePointer() + (LETTERS_TO_READ * BYTES_PER_REC);

                while (file.getFilePointer() < INDEX_LIMIT)
                {
                    out.print(Character.toUpperCase((char)file.readByte()));
                }
            }
            catch (EOFException e)
            {
                out.println();
            }
        }
        catch (IOException | NumberFormatException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex135().start();
    }
}