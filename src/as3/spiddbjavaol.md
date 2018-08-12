# Spiderman Database

You will be making a comics database with a spiderman table. You will design and create the table, add records, make changes to the fields and records, and search the table for records that match conditions. It is broken up into three separate programs so that each one can be done independent of the other parts (but much of the set up code can be copied and pasted). Each part’s program and output should be submitted. It can be completed either with Access and UCanAcess or with Derby. If using Access, you can create the empty comics database in Access first.

It is stated below, but take note of a couple of changes to simplify a little bit:

**You can keep your design to the int, double, and varchar field types, so you do not have to make dates, currency, or boolean. You do not have to include the spaces in the field names, for example you can use ComicName.**

## Java Database Exercise 1

1. You are the owner of a comic book store and have decided to create a database of your Spider-Man comic books. The information you want to keep track of includes the Comic Name, Issue Number, Issue Date, Issue Name, Value, and Whether in Mint Condition?

2. Create a comics access database and write a program that will create a spiderman table, or write a program to create a comics derby database with a spiderman table. Enter the field names, proper types, proper widths, and proper field properties based upon the data below. Design the structure of the table and enter the following records into the table. You can keep your design to the int, double, and varchar field types, so you do not have to make dates, currency, or boolean. You do not have to include the spaces in the field names, for example you can use ComicName.

| Comic Name     | Issue Number | Issue Date | Issue Name            | Issue Value | Mint Condition? |
| :------------- | -----------: | ---------: | :-------------------- | ----------: | --------------: |
| Amazing SM     |           89 |    10/1/70 | Doc Ock Lives         |       $6.50 |              No |
| Spectacular SM |           92 |     7/1/84 | What Is The Answer    |       $4.50 |              No |
| Web Of SM      |           35 |     2/1/88 | You Can Go Home Again |       $4.00 |              No |
| Amazing SM     |          382 |    10/1/93 | Emerald Rage          |       $4.00 |             Yes |

3. Whether you use access or if you use derby, print your comics spiderman table printed from your java program by using a ResultSet (use column headings, field widths to line up fields, ex. money on the right with two decimal places, etc.). If using Access, you can check the spiderman table in Access.

4. Add the 4 line documentation to the top of your program and 5 lines throughout the code.

5. Run your program and submit your program code and your output from the console window. You can copy and paste the results into a plain Eclipse text file.

## Java Database Exercise 2

1. Create a program so that will update the spiderman table in the comics database file and make the indicated corrections.

2. You have added some new comics to your collection, so add the following records to your table, after making sure your design structure is proper for the new records.

| Comic Name     | Issue Number | Issue Date | Issue Name                              | Issue Value | Mint Condition? |
| :------------- | -----------: | ---------: | :-------------------------------------- | ----------: | --------------: |
| Amazing SM     |          400 |     4/1/95 | A Death In The Family                   |       $5.00 |             Yes |
| Spectacular SM |           37 |    12/1/79 | Into The Hive                           |       $6.00 |              No |
| Amazing SM     |          194 |     7/1/79 | Never Let The Black Cat Cross Your Path |      $10.00 |              No |
| Web Of SM      |          125 |     6/1/95 | Searching                               |       $4.00 |             Yes |

3. Two of your comics have increased in value so change the Issue Value of Comic Name Amazing SM that has Issue Number 89 to $7.00. Change the Issue Value of Comic Name Spectacular SM that has Issue Number 92 to $5.00. Change the Issue Name of Comic Name Spectacular SM that has Issue Number 92 to What Is The Answer? (put in the Question Mark). Be specific in your updates (ex. don=t just say to increase all issue number 89 because there might be an Amazing and a Spectacular 89).

4. You have sold one of your comics, so delete Comic Name Amazing SM with Issue Number 382 from the database table.

5. Add a record at the bottom of the table for Comic Name Amazing SM with your name in the Issue Name field, 0 as the Issue Number, and an Issue Value of $5.00. Use today=s date as the Issue Date and you are in Mint Condition.

6. Whether you use access or if you use derby, print your comics spiderman table printed from your java program by using a ResultSet (use column headings, field widths to line up fields, ex. money on the right, etc.). If using Access, you can check the spiderman table in Access.

7. Add the 4 line documentation to the top of your program and 5 lines throughout the code.

8. Run your program and submit your program code and your output from the console window. You can copy and paste the results into a plain Eclipse text file.

## Java Database Exercise 3

1. Create a program for your spiderman table in the comics database file that will create the following queries to display each of the following. Whether you are using Access or derby, print the queries from the java program, and use column headings, field widths to line up fields, ex. money on the right, etc.

2. Create a query to display the Comic Name, Issue Date, Issue Number, and Issue Value for all comics whose Issue Value is $5.00 or over. Sort the results by the Issue Value from highest to lowest. Print the labeled results of the query from your editor.

3. Create a query to display the Issue Name, Comic Name, Issue Number, and Issue Date for all Amazing SM with Issue Number before 200. Print the labeled results of the query from your editor.

4. Add the 4 line documentation to the top of your program and 5 lines throughout the code.

5. Run your spiderman queries program. Submit your spiderman query program code from your editor and the queries output from the console window. You can copy and paste the results into a plain Eclipse text file.

Note: Derby may be substituted for Access. Field types may be limited to the basic field types used in class - int, double, varchar. Field names may be limited to names without spaces.