package ch12.ex2;

import javax.swing.JOptionPane;
import static java.lang.System.*;

/**
 * Project: ch12.ex2
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex122
{
    public void start()
    {
        try
        {
            String input = JOptionPane.showInputDialog("Enter integer:");
            int num = Integer.parseInt(input);
            out.println("Input: " + num);
        }
        catch (NumberFormatException e)
        {
            err.println(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex122().start();
    }
}