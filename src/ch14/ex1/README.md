4-1

a. Write a class definition that extends Thread for a racehorse. It will have a string data field for the name of the racehorse, a constructor to set the name, and the `run()` method. The racetrack will be from spot 1 to 100, the `run()` will use a loop to print their spot number (the loop variable that increments) and name 100 times before printing they are done at the end of the loop. If there are multiple threads, the 100 time for loops will be running for each racehorse at the same time. 

Here is the code: 

```java
package threads14;
/* Bill Wohlleber
 * Exercise 14-1
 * This class will define a racehorse
 */
public class racehorse141 extends Thread
{
    private String name;
   
    public racehorse141(String n)
    {
        name = n;
    }

    public void run()  // override run() method from Thread, called by start()
    {
        int i;
        for (i = 1; i <= 100; i++)
            System.out.print(i + name + " ");
        System.out.println(name + " done");
    }
}
```

b. Write the main class that will declare 4 racehorses and set their priority based upon random numbers (from 1 - 10, then `setPriority()` for each racehorse object). Then `start()` all 4 racehorses and see which racehorse can get to 25 times through their for loops first and win the race. If there seems to not be enough switching back and forth between racehorse threads, you can change to loop to 100 times. 