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

