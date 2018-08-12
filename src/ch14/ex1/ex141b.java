package ch14.ex1;

import java.util.Random;
import static java.lang.System.*;

/**
 * Project: ch14.ex1
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex141b extends Thread
{
    private String horseName;

    private ex141b(String horseName)
    {
        this.horseName = horseName;
    }

    @Override
    public void run() {
        for (int i = 1; i < 25; i++)
        {
            out.println("Horse: " + horseName + " spot: " + i);
        }
        out.println("Horse: " + horseName + " is DONE with priority: " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args)
    {
        new Random()
                .ints(1, 11)
                .limit(4)
                .forEach(e ->
                {
                    ex141b horse = new ex141b(String.valueOf((char) (64 + e)));
                    horse.setPriority(e);
                    horse.start();
                });
    }
}