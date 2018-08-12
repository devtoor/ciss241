18-5

Change the Stack of movie objects in 18-4 into a `TreeSet` of  movie objects.  Add extra choices to the user's picks so they can see  what the next movie is at the beginning or end, and so they can watch  what the next movie is at the beginning or end.  Use methods to show the `TreeSet` is sorted and can not contain duplicate objects (including  telling the user if they try to add a duplicate movie). 

**Lab exercises 18-1, 18-3, 18-4 have the same setup, so they can be used as a guide (and some copy and paste).**  **Lab exercise 18-3 has the movie18 class definition header file - use that class definition.** 

Add new cases for the following: 

```java
System.out.println("Enter 1 to add movie to treeset");
System.out.println("Enter 2 to see what next movie on treeset is");
System.out.println("Enter 3 to watch next movie on treeset");
System.out.println("Enter 4 to see what last movie on treeset");
System.out.println("Enter 5 to watch last movie on treeset");       
System.out.println("Enter 6 to see treeset of movies");
```

In the switch, cases 2 and 3 would be - 2 - seeing what the first  movie18 in the `TreeSet` is (and keeping it) and 3 - watching the first  movie (so it would be removed from the `treeset`), and cases 4 and 5 would be similar - 4 - seeing and 5 - watching the last movie18 in the  `TreeSet`. 

The movie18 class definition is given in 18-3. 

Submit the ex185.java file. 