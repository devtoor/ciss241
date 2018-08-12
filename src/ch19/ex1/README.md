19-1

Write a program that will recursively find the greatest common 
divisor of two integers.  The GCD of two integers can be found 
recursively by using the following over and over to break the numbers 
down to smaller and smaller values until one number divides into the 
other evenly (modulus result of zero means it is a divisor and we work 
down so the first one we find is the greatest).  Keep dividing the 
second number into the first and find the modulus (the amount that 
didn't go in evenly).  Now find the greatest common divisor of the 
second number (that was the divisor on the previous modulus) and the 
modulus. 

```java
/* Bill Wohlleber
Exercise 19 - 1
This program will use recursion to find the gcd of 2 integers.
Write the gcd method using recursion.  Try your program with:
10 and 4, gcd = 2.
9 and 15, gcd = 3.
*/
package recursion19;

import java.util.Scanner;

public class ex191a
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
	// write gcd method using recursion as described above
}
```