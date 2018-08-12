package ch14;

import static java.lang.System.*;

/**
 * Project: ch14
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class racehorse141 extends Thread
{
    private String name;

    public racehorse141(String n)
    {
        name = n;
    }

    public void run()
    {
        long startTime = currentTimeMillis();
        for (int i = 1; i <= 100; i++)
        {
            out.println(name + " : " + i);
        }
        long time = currentTimeMillis() - startTime;
        out.printf("%s is Done with priority: %d in %dms\n", name, getPriority(), time);
    }
}