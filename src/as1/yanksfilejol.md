# YANKEES FILE

You will write a program that will convert a file of objects to a plain ASCII character text file `yankees.txt` (using plain character streams of individual characters). Copy the attached `yankees.yanks` object input file and save into your `ciss241` project folder.  Copy the attached `yankees.java` class definition file and save into your `files13` package. 

You will then create a main program that will read an entire record (an object from this `yankees.yanks` file), get each field separately and convert each field into a separate character stream, and write the character streams of individual characters (in a loop) to a plain ASCII output text file called `yankees.txt` (you can open it in Eclipse from your `ciss241` project folder). Each field value will be a separate loop and you will only write one character at a time from each field (note: the only output to the `yankees.txt` file will be to write one individual plain ASCII text character at a time).  

In the output file, put each yankees record on a separate line with a space character between each field and a new line or return character at the end of each record. Continue reading objects until you reach the EOF (at which point you will read a null, so you can read until you throw and catch an `EOFException` - but you don't have to print anything, just exit). Include catch blocks for any kinds of exceptions that might occur (print the stack trace and exit).

Input: Read yankees objects from `yankees.yanks` in form of `yankees.java`.
Output: Write individual ASCII characters from fields of yankees objects to `yankees.txt`.

Add a full paragraph of documentation (at least 4 lines each) to your main program. Supply extra documentation (at least 5 comments) throughout for all of the not easily understandable lines of code for your main program. Run your program and submit your main program and `yankees.txt` output file by attaching the files.