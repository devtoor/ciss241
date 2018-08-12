13-6

Write a program that creates a pizza object (with size and price data fields). Write the entire object to a file. Then read the object back and call get methods to get values for that object. 

The pizza class definition (note the pizza class must be serializable) is attached and here is the main program: 

```java
package files13;
/* Bill Wohlleber
 * Exercise 13-6
 * This program will create a pizza object
 * and write and read the object from a file
 */
import java.io.*;
public class ex136
{
    public static void main(String[] args)
    {
        pizza136 p1 = new pizza136('L', 11.00);
        pizza136 p2;
       
        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new
                FileOutputStream("pizza136.txt"));
                       // connect to output file of objects
            os.writeObject(p1);   // write the p1 pizza object
           
            ObjectInputStream is = new ObjectInputStream(new
                FileInputStream("pizza136.txt"));
                      // connect to input file of objects
            p2 = (pizza136)is.readObject(); // read the pizza object back
           
            System.out.println("Pizza size is " + p2.getsize());
                // print individual fields
            System.out.printf("Pizza price is %.2f\n", p2.getprice());
           
            os.close();
            is.close();
        }
        catch (EOFException ex) // if try to read past eof
        {
            System.exit(1);
        }
        catch (FileNotFoundException fe) // if can't find pizza file
        {
            fe.printStackTrace();
            System.exit(1);
        }
        catch (IOException ioe) // if problem reading or writing objects
        {
            ioe.printStackTrace();
            System.exit(1);
        }
        catch (ClassNotFoundException ce)  // if can't find pizza class
        {
            ce.printStackTrace();
            System.exit(1);
        }
    }
}
```