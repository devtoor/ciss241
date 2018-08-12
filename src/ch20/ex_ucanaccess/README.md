Exercise UCanAccess - Setting up Access database with UCanAccess

A driver to connect to an Access database is through UCanAccess. UCanAccess is a JDBC driver that can directly connect to an Access database. (Ignore extra spaces below, they occurred when the list of jars and code was copied).

Like before, create your database file in Access.
Download UCanAccess from (also listed under Links)
<http://sourceforge.net/projects/ucanaccess/>

Extract all files from the download: something like: UCanAccess-2.0.9.4-bin.zip  (updated version numbers may vary)
To set up in Eclipse, right click on Project - Build Path - Configure Build Path. In the libraries tab - Add External Jars - add each of the following `.jar` files (updated version numbers may vary) downloaded with the  UCanAccess driver:

- ucanaccess-2.0.9.4.jar
- lib/commons-lang-2.6.jar
- lib/commons-logging-1.1.1.jar
- lib/hsqldb.jar
- lib/jackcess-2.1.3.jar

You can now connect to both .accdb and .mdb Access database files using the following Connection object (adjust path and filename): 

The following String URL for ucanaccess would be:

```java
String url = "jdbc:ucanaccess://h:/241/ciss241/baseball.accdb";
    // adjust to your drive, folder, and file -
    // ex. my h drive, 241 folder,  ciss241 project folder, baseball.accdb access file
con = DriverManager.getConnection(url, "", ""); 
```

Close your Access database file, write and run your java program, then open your Access database file and see the table results.