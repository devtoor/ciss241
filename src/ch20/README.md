20-1

Write a program that will create a yankees table for a baseball part a Access database file or a part b Derby database file. It will have fields for the name of the player, the position of the player, and the player's number. Then insert the following records into the table. Use SQL commands for the create and insert. If you use Access, set up UCanAccess or the ODBC JDBC bridge and create an Access baseball database file, then the lab exercise will 
create the yankees table. If you use Derby, set up the derby.jar file, set up the extra files, and run with the proper arguments.

| name            | position | number |
| --------------- | -------- | ------ |
| Bernie Williams | CF       | 51     |
| Derek Jeter     | SS       | 2      |
| Mariano Rivera  | P        | 42     |
| Jason Giambi    | 1B       | 25     |
| Mike Mussina    | P        | 35     |
| Alfonso Soriano | 2B       | 12     |

You then realize Giambi would be better as a DH instead of 1B, so use an SQL command to update the table accordingly in the java program.

For derby, the two new key lines in the try block are:

```java
SimpleDataSource.init("databaseyankees.properties");
    /* database configuration management in databaseyankees.properties separate file */
con = SimpleDataSource.getConnection();
    /* Connection object created from Properties object in SimpleDataSource.java file */
```

Attach your .java program either using 1 - Access **OR** 2 - Derby.  Include an output text file to show the displaying of all records and all fields to show the proper results and database table were created and connected to.

20-2

Create 2 queries for the yankees table from 20-1 from the baseball Access database or Derby database.  It will be set up similar to 20-1, then add the query and `ResultSet`. Make sure the query is properly built and printed.  List the results from the `ResultSet` on the screen. You can combine both into one java program. You can use either 1 - Access or 2 - Derby. Give the proper query statement and display the results. 

a. The first will be to list the players name, number, and position (in that order) for all players whose number is less than 20 (of course most of the low numbers have been retired because of all the great players in the history of the Yankees). Sort the list by position from lowest to highest.

b.  The second will be to ask the user what position they want to see listed, then list the name and number for all players at that position.

Attach your .java program either using 1 - Access or 2 - Derby. Include an output text file to show the connection and database table were connected to and queried.  For position, pick P. For the output file, you can run the 
program in the console, then copy the results in the console (right click, select all, enter to copy, open a plain text file in Eclipse, paste the results, then save and attach).