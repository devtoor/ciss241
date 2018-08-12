This is a review of inheritance.  It has a super class for a bank account.  Then it has two sub classes of an account.  A checking "is an" account and a savings "is an" account.  The account class has the general properties and methods for a bank account.  To be more specific, a checking class and a savings class is created, but instead of building them from scratch, we can build upon the general properties and methods (like having an account number, being able to perform a transaction, etc.).  A main class is included to create the accounts and perform transactions. Since savings and checking accounts are both subclasses of the account class, they can be in an array together.  The array type needs to be something that "is an" account, so the array type are abstract super references to account subclasses.

Open your ciss241 project and revpack package.  Save all the classes attached.  Right click on the package and Import - File System and locate your files.  Right click on the package and New - Class for the new cd class.  This is exercise 1 in the chapter Review 7-11 notes (under the Notes on the left) and is built off original exercise 9-4.

r-1

Update the `bankaccount` super class with the checking and savings subclasses.  Add another subclass for a cd account, that has an interest rate field and a new field with a number of months you must keep the money in the cd.  Add a cd object to the array of abstract super references in the main program.
  
Run your program with <kbd>Ctrl</kbd> + <kbd>F11</kbd> and input into the Eclipse Console window.