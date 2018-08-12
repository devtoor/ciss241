package ch13.ex6;

import java.io.*;
import static java.lang.System.*;
/**
 * CISS 241-300
 * @author  Jay Morales
 * Exercise 13-6
 */
public class ex136
{
    public static void main(String[] args)
    {
        Pizza p1 = new Pizza('L', 11.00);
        Pizza p2;

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("pizza.txt"));
             ObjectInputStream is = new ObjectInputStream(new FileInputStream("pizza.txt")))
        {
            // connect to output file of objects
            os.writeObject(p1);             // write the p1 pizza object

            // connect to input file of objects
            p2 = (Pizza) is.readObject();   // read the pizza object back

            System.out.println("Pizza size is " + p2.getSize());
            // print individual fields
            System.out.printf("Pizza price is %.2f\n", p2.getPrice());
        }
        catch (IOException | ClassNotFoundException e)
        {
            err.println("Error: " + e.getMessage());
            exit(1);
        }
    }
}
