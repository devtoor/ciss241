package ch12;

import javax.swing.JOptionPane;
import static java.lang.System.*;

/**
 * Project: ch12
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex123
{
    private void start()
    {
        int num;

        while (true)
        {
            try
            {
                String input = JOptionPane
                        .showInputDialog("Enter number grade (0-100):");

                // Try-Catch statement to modify error message.
                try
                {
                    num = Integer.parseInt(input);
                }
                catch (NumberFormatException e)
                {
                    throw new NumberFormatException
                            ("That is not a number. Try again . . .");
                }

                if (num < 0 || num > 100)
                    throw new IllegalStateException
                            ("Out of bounds! Try again . . .");

                out.println("Grade input: " + num);
                break;
            }
            // Catch multiple exception to avoid code duplication.
            catch (NumberFormatException | IllegalStateException e)
            {
                out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        new ex123().start();
        exit(0);
    }
}