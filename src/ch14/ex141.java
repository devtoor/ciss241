package ch14;

import java.util.Random;

/**
 * Project: ch14
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex141
{
    public static void main(String[] args)
    {
        racehorse141 horse1 = new racehorse141("Red Horse");
        horse1.setPriority(new Random().nextInt(10) + 1);
        racehorse141 horse2 = new racehorse141("Black Horse");
        horse2.setPriority(new Random().nextInt(10) + 1);
        racehorse141 horse3 = new racehorse141("Brown Horse");
        horse3.setPriority(new Random().nextInt(10) + 1);
        racehorse141 horse4 = new racehorse141("White Horse");
        horse4.setPriority(new Random().nextInt(10) + 1);

        horse1.start();
        horse2.start();
        horse3.start();
        horse4.start();
    }
}
