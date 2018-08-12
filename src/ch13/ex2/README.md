13-2

a. Write a program that will let the user input information about an employee to save to an output file.  Include their name and number on a single line in a character stream with the InputStream and OutputStream.  When the user is done entering information, they will hit the eof.  Check the created file that the information was written.

b. Modify the program to use an input and output file.

c. Modify the program to use a FileReader and FileWriter. 

d. Modify the program to use a StreamTokenizer on the input file and output to the screen.

Here is 13-2b as an example:

```java
package files13;
/* Bill Wohlleber
 * Exercise 13-2b
 * This program will input into a file using character streams
 */
import java.io.*;
public class ex132b
{
    public static void main(String[] args) throws IOException
    {
        InputStream is;  // super input stream
        OutputStream os;  // super output stream
        int value;
        String filenamein, filenameout;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
        File fout, fin;
        try
        {
            System.out.print("Enter input filename:  ");
            filenamein = br.readLine();
            fin = new File(filenamein); // file object connected to input file
            System.out.print("Enter output filename:  ");
            filenameout = br.readLine();
            fout = new File(filenameout); // file object connected to output file
            is = new FileInputStream(fin); // file streams connected to objects
            os = new FileOutputStream(fout);
            value = is.read();  // read one character from input file
            while (value != -1) // while not eof marker -1
            {
                os.write(value); // write one character to output file
                value = is.read(); // loop through input file character by character
            }
            is.close(); // close streams
            os.close();
            System.out.println("\n" + fout + " created");
        }
        catch(IOException e) // read of write problems
        {
            e.printStackTrace();
        }
    }
}
```

