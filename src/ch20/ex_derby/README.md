Exercise Derby

**Derby works best without a separate `src` folder for your Project because of the paths. So when you make your Project, do not use a separate source folder.**

First locate the derby.jar file that comes with java, it will be somewhere like:

`C:\Program Files (x86)\Java\jdk1.8.0_74\db\lib` 

or 

`C:\Program Files\Java\jdk1.7.0_05\db\lib\derby.jar`

Then copy derby.jar into the folder where you are executing your java program.  For Eclipse, that folder will be the Project folder (for example in the project ciss241 folder).  For `TextPad` or `Dr. Java`, if you are not using separate packages, it will be the folder with the java programs (.java and .class files).  For `TextPad`, this file and all others listed below will be in this same folder.

Create a properties file and save it in the Eclipse Project folder.  This is creating the bridge from `jdbc` to derby to your database file (like we made the String URL for the bridge with Access).  For example, for lab 20-1 on the yankees part b on derby, it would be something like (naming it databaseyankees.properties):

`jdbc.url=jdbc:derby:yankees1;create=true` 

where the `jdbc` is set up with derby, yankees1 is the name of the database file folder (possibly new) created in this same project folder, and allow the creating of tables for this database file. For each new database, yankees1 would be changed to the name of the database for that program.

Copy the attached Big Java file SimpleDataSource.java into the package folder (ex. dbms20 package) with your `.java` program.  Make sure the package names match (package dbms20) or adjust.  This file makes the statement and connection (for Access we did it in the same file as our program).

Create your .java database program and save it in your dbms20 package folder, save it, and compile it in Eclipse.

If you download, install, and set up the Eclipse Derby plugin from Apache, you can continue in Eclipse with running your program, otherwise continue with the command prompt instructions or `TextPad` instructions.

Click the Windows Start Button, and go to All Program - Accessories - Command Prompt.

Change into the Project folder, for example change to drive C and then 
change into your project folder.  Adjust your path in the cd (change directory) command to your Project.  The cd c:\ will put you at the root C drive, then you can give the relative path to your Project folder.

```bash
C:\Users\Bill>cd c:\
C:>cd Users\Bill\workspace\ciss241
C:\Users\Bill\workspace\ciss241>
```

Now run the java program in the dbms20 package, dot, name of the program without any extension (here names ex201derby), including derby.jar in the classpath and load the properties file (named databaseyankees.properties or whatever you name it).

```bash
java -classpath derby.jar;. dbms20.ex201derby databaseyankees.properties
```

The results of the program will show on the command prompt console window. You can then right click and pick Select All, then press the Enter key to copy the results onto the clipboard. You can then open a new plain text file (in Eclipse, TextPad, Notepad, etc.) and paste the results.

If you are using an editor like TextPad, you can directly run by going to Tools Menu - Run ....
Command:  C:\Program Files\Java\jdk1.7.0_05\bin\java.exe (or adjust your path)
Parameters:  -classpath derby.jar;. ex202bd databaseyankees.properties (or adjust)

For example, here is my command line commands (shown in bold) for lab 20-1 using derby (it includes changing directories, compiling (optional if also done through Eclipse), and running the program (running command shown bigger and bolder). Modify to use your directory and file names, etc (you may need to set the path, check and adjust your path to the Java bin folder).

```bash
C:\Users\Bill> cd c:\
C:\> cd Users\Bill\workspace\ciss241
C:\Users\Bill\workspace\ciss241> set path=C:\Program Files(x86)\Java\jdk1.8.0_144\bin;%path%
C:\Users\Bill\workspace\ciss241> javac dbms20\ex201derby.java
C:\Users\Bill\workspace\ciss241> java -classpath derby.jar;. dbms20.ex201derby databaseyankees.properties
New York Yankees
Name              POS    Number
Bernie Wiliams    CF     51
Derek Jeter       SS     2
Mariano Rivera    P      42
Jason Giambi      DH     25
Mike Mussina      P      35
Alfonso Soriano   2B     12
C:\Users\Bill\workspace\ciss241>
```

