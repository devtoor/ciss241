12-1

Create a program that will create an array.  You will then try print the array using a loop, but go beyond the bounds of the array. Catch the exception, print an error message, print the `getMessage()`, and the `printStackTrace()`. 

```java
package exceptions12;
/* Bill Wohlleber
 * Exercise 12-1
 * This program will loop too far through an array
 */
public class ex121
{
    public static void main(String[] args)
    {
        int i;
        int[] values = {1, 3, 5, 7, 9};
        try              // try looking up array values
        {
            for (i = 0; i <= values.length; i++)
                System.out.println(values[i]);
                    /* when gets to index 5, automatically creates
                       and throws ArrayIndexOutOfBoundsException */
        }
        catch(ArrayIndexOutOfBoundsException ex) 
              /* if go beyond the array, catch the Exception,
                 then print error messages */
        {
            System.out.println("You have gone too far");
            System.out.println(ex.getMessage()); // value
            System.out.println(ex.toString()); // type
            ex.printStackTrace();    // where occurred
            System.exit(1);
        }
    }
}
```

