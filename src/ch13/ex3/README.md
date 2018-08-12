13-3

Update the program from 13-2a (13-2b can also be used, just change how the input and output is done) with the character streams (single character by single character) for the employee name and number from the keyboard to an output file. Now use binary streams of strings and integers, so the entire string or integer can be written at once by using `writeUTF()` and `writeInt()`.  Then add another loop to read binary streams of strings and integers using `readUTF()` and `readInt()`, since data written as a block usually has to be read as a block (ex. an integer written as a four byte block, one character byte would not be readable as a character so it must be read as a four byte block to be readable).  Let the user input and output in loops. Here is the beginning, add the two try blocks with loops containing the UTF and Int write and read. 

```java
package files13;
/* Bill Wohlleber
 * Exercise 13-3
 * This program will input into a file using binary streams
 */
import java.io.*;
import java.util.Scanner;
public class ex133
{
    public static void main(String[] args) throws IOException
    {
        DataInputStream is;
        DataOutputStream os;
        int value;
        String filenamein, filenameout, name;
        BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        FileOutputStream fout;
        FileInputStream fin;
        System.out.print("Enter output filename:  ");
        filenameout = br.readLine();
```

