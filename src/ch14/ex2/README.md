14-2

Write a program that will display a ticking clock. You will draw a string on an frame with a bigger font saying "The time is " and then telling the time in hours, minutes, and seconds. Update the clock every second. Print preceding zeros for when the minute and/or second is between 0 and 9. Use the background and foreground colors and override the `update()` method to lessen flicker. Only redraw the time part and not "The time is " part.  Use the `Date` class and get the new hour, minute, and second over and over after sleeping for one second.

```java
/* Bill Wohlleber
 * Exercise 14-2
 * This frame will display a ticking clock
 */
package threads14;
import java.awt.*;
import javax.swing.*;
import java.util.Date;

public class ex142 extends JFrame
{
    Date today;
    int hour, minute, second;
    boolean first = true;
    Container c;
    Font clock = new Font("Arial", Font.BOLD, 36);
   
    public ex142()
    {
        setSize(400, 200);
        setTitle("Clock");
        setResizable(false);
        c = getContentPane();
        c.setBackground(Color.cyan);
        setForeground(Color.blue);
        setVisible(true);
    }
   
    public void update(Graphics g)
    {
        paint(g);
    }
   
    public void paint(Graphics g)
    {
        g.setFont(clock);
       
        // first time draw The time is
       
        if (first)
        {
            super.paint(g);
            g.setColor(getForeground());
            g.drawString("The time is ", 10, 100);
            first = false;
        }
       
        // cover old time
       
        g.setColor(c.getBackground());
       
        if (second <= 9 && minute <= 9)
            g.drawString(hour + ":0 " + minute + ":0" + second,  200,  100);
        else if (second <= 9)
            g.drawString(hour + ":" + minute + ":0" + second, 200, 100);
        else if (minute <= 9)
            g.drawString(hour + ":0" + minute + ":" + second, 200, 100);
        else
            g.drawString(hour + ":" + minute + ":" + second, 200, 100);
       
        // get new time
       
        today = new Date();
        hour = today.getHours();
        minute = today.getMinutes();
        second = today.getSeconds();
       
        // draw new time
       
        g.setColor(getForeground());

        if (second <= 9 && minute <= 9)
     g.drawString(hour + ":0 " + minute + ":0" + second,  200,  100);
        else if (second <= 9)
            g.drawString(hour + ":" + minute + ":0" + second, 200, 100);
        else if (minute <= 9)
            g.drawString(hour + ":0" + minute + ":" + second, 200, 100);
        else
            g.drawString(hour + ":" + minute + ":" + second, 200, 100);
       
        // go to sleep 1 second
       
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        { }
       
        // repaint
       
        repaint();
    }
   
    public static void main(String[] args)
    {
        ex142 f = new ex142();
    }
}
```