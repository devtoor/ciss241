package ch12.ex4;

import javax.swing.JOptionPane;
import java.util.*;
import static java.lang.System.*;

/**
 * Project: ch12.ex4
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex124
{
    public void start(Scanner sc) throws Exception
    {
        try
        {
            String line;
            int howMany;
            int nums[] = new int[3];

            out.print("How many numbers?  ");
            howMany = Integer.parseInt(sc.nextLine());

            if (howMany < 0 || howMany > 3)
                throw new IndexOutOfBoundsException();

            for (int i = 0; i < howMany; i++)
            {
                line = JOptionPane.showInputDialog(null,
                        "Enter an integer",	"Input",
                        JOptionPane.QUESTION_MESSAGE);
                nums[i] = Integer.parseInt(line);

                try
                {
                    out.printf("Next number is %f\n", nums[i]);
                }
                catch (IllegalFormatConversionException e)
                {
                    err.printf("\n3. Next number is %d\n", nums[i]);
                }

                if (nums[i] == 0)
                    throw new ArithmeticException();
                out.println("Division by the number is " +
                        (double)howMany / nums[i]);
            }
        }
        catch (InputMismatchException e)
        {
            throw new InputMismatchException("1. Console: Invalid Input");
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("2. Dialog: Invalid Input");
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new IndexOutOfBoundsException("4. Out of bounds");
        }
        catch (ArithmeticException e)
        {
            throw new ArithmeticException("5. Division by zero");
        }
        catch (Exception e)
        {
            throw new Exception("6. Anything else");
        }
    }

    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in))
        {
            new ex124().start(sc);
        }
        catch (Exception e)
        {
            err.println(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
        exit(0);
    }
}