package ch13.ex2;

import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.*;

/**
 * Project: ch13.ex2
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex132a
{
    public void start()
    {
        try (FileOutputStream file = new FileOutputStream("Output.txt", true))
        {
            int key;
            int available;
            final int LINE_FEED = 10;

            do {
                // Consume excess input
                if ((available = in.available()) > 0)
                    in.skip(available);

                out.print("\nEnter employee name: ");
                while((key = in.read()) != LINE_FEED)
                {
                    file.write(key);
                }
                file.write(' ');
                out.print("Enter employee number: ");
                while((key = in.read()) != LINE_FEED)
                {
                    file.write(key);
                }
                file.write('\n');

                out.print("Enter Ctrl + Z to end or any key to continue . . . ");
            }
            while (in.read() != -1);
        }
        catch (IOException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex132a().start();
    }
}
