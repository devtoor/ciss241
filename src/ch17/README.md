17-3

Adjust the program from #1 and #2 so that the program also lists all the set methods (start with set, takes one argument, and returns nothing).

Note:  In the Labs Chapter 17, a Lab is included walking through Command Line Arguments.

Fill in the following program at the three comment spots for combined lab exercises 17-1, 17-2, 17-3.  Convert the user input into a command line argument of the full path class name.  Add the code in the `getm()` method for the loop to find all the get methods in the Class named `cls`. For our purpose, a get method would start with get, is not a void return, and has no arguments. Then add the code in the `setm()` method for the loop to find all the set methods in the Class named `cls`. For 
our purpose, a set method would start with set, is a void return, and has one argument.

For the `getm()` method, get all methods for the `cls` Class, loop through the methods and print all methods that are get methods - **start with get, is not a void return, and has no arguments.** 

For the `setm()` method, get all methods for the `cls` Class, loop through the methods and print all methods that are set methods - **start with set, is a void return, and has one argument.** 

For the void, check out the Void class and the TYPE data field. Try the program by inputting classes with a full path, such as: j`ava.util.Date` , `javax.swing.JLabel` and `java.lang.reflect.Method`.  Save as `ex173b.java` and submit it.

```java
/* Bill Wohlleber
Exercise 17-3
This program will let the user give a class name to find the
get and set Methods.  Test with:
java.util.Date
javax.swing.JLabel
java.lang.reflect.Method
*/

package rtti17;
import java.io.*;
import java.lang.reflect.Method;

public class ex173
{
    public static void main(String[] args) throws IOException
    {
        String classname;
        Class x;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));

        /* Convert this user input to a command line argument */

        System.out.print("Enter a full path class name:  ");
        classname = br.readLine();
        try
        {
            x = Class.forName(classname);
            getm(x);
            System.out.println();
            setm(x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void getm(Class cls)
    {
        int i;
        String methodname;
        Class rettype;
        Class[] paramtypes;
        Method[] ma;
        System.out.println("Listing get methods for " + cls);

        /* get all methods for the cls Class, loop through methods and
        print all methods that are get methods - start with get, is
        not a void return, and has no arguments
        */
    }

    public static void setm(Class cls)
    {
        int i;
        String methodname;
        Class rettype;
        Class[] paramtypes;
        Method[] ma;
        System.out.println("Listing set methods for " + cls);

        /* get all methods for the cls Class, loop through methods and
        print all methods that are set methods - start with set, is
        a void return, and has one argument
        */
    }
}
```

