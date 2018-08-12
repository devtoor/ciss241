package ch12.ex1;

import static java.lang.System.*;

/**
 * Project: ch12.ex1
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public final class ex121
{
    public void start()
    {
        int[] values = {1, 3, 5, 7, 9};
        try
        {
            for (int i = 0; i <= values.length; i++)
                out.println(values[i]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            err.println("You have gone too far");
            err.println(e.getMessage());
            err.println(e.toString());
            e.printStackTrace();
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex121().start();
    }
}