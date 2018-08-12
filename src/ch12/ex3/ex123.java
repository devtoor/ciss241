package ch12.ex3;

import javax.swing.JOptionPane;
import static java.lang.System.*;

/**
 * Project: ch12.ex3
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex123
{
    public void start()
    {
        int num;

        do
        {
            try
            {
                String input = JOptionPane
                        .showInputDialog("Enter number grade (0-100):");

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
                            ("Out of bounds!");

                out.println("Grade input: " + num);
                return;
            }
            catch (NumberFormatException | IllegalStateException e)
            {
                err.println(e.getMessage());
                e.printStackTrace();
                exit(1);
            }
        }
        while (true);
    }

    public static void main(String[] args)
    {
        new ex123().start();
        exit(0);
    }
}