package ch19.ex1;

import java.util.Scanner;

/**
 * Project: ch19.ex1
 * Date:    4/7/2018
 *
 * @author Jay Morales
 */

public class ex191
{
    public static void main(String[] args)
    {
        int x, y, g;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 2 integers:  ");
        x = sc.nextInt();
        y = sc.nextInt();
        g = gcd(x, y);
        System.out.println("GCD of " + x + " and " + y + " = " + g);
    }

    private static int gcd(int a, int b)
    {
        if (b==0)
            return a;
        else
            return gcd(b, a % b);
    }
}
