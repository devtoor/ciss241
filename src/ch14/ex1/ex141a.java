package ch14.ex1;

import static java.lang.System.*;

/**
 * Project: ch14.ex1
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex141a extends Thread
{
    private String horseName;

    private ex141a(String horseName)
    {
        this.horseName = horseName;
    }

    @Override
    public void run() {
        for (int i = 1; i < 25; i++)
        {
            out.println("Horse: " + horseName + " spot: " + i);
        }
        out.println("Horse: " + horseName + " is DONE");
    }

    public static void main(String[] args)
    {
        new ex141a("A").start();
        new ex141a("B").start();
        new ex141a("C").start();
        new ex141a("D").start();
        new ex141a("E").start();
    }
}