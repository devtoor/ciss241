package ch13.ex2;

import java.io.*;
import static java.lang.System.*;
import static java.io.StreamTokenizer.*;

/**
 * Project: ch13.ex2
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex132d
{
    public void start()
    {
        int token;

        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in)))
        {
            out.print("Enter input filename: ");

            try (FileReader reader = new FileReader(input.readLine()))
            {
                StreamTokenizer stream = new StreamTokenizer(reader);
                stream.eolIsSignificant(true);
                stream.wordChars(' ', ' ');

                while ((token = stream.nextToken()) != TT_EOF)
                {
                    switch (token)
                    {
                        case TT_WORD:
                            out.print(stream.sval);
                            break;
                        case TT_NUMBER:
                            out.print(stream.nval);
                            break;
                        case TT_EOL:
                            out.println();
                            break;
                    }
                }
                out.println("\n");
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
        new ex132d().start();
    }
}