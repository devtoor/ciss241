
14-4

Write a program that will define a runnable frame to have a ball move across the frame left to right. While that is happening, have another frame that will let the user do something like click a button or input into a textfield, but keep the ball moving in the other frame.  When the ball reaches the right edge of the frame or when the user takes action - enters in textfield or clicks the button, end the thread. The frame application will be running while the ball runnable thread is running.

The one frame class is shown below and the second ball frame class is partially done. Finish the ball frame class, filling in the missing methods shown with comments below.

First, here is the Frame class with the ball thread instantiated:

```java
package threads14;
/* Bill Wohlleber
 * Exercise 14-4
 * This program will let the user click a button while a ball is moving
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex144 extends JFrame implements ActionListener 
{
    ball144 b = new ball144();  
         // create ball frame runnable thread object
    JButton jb = new JButton("Click");
    JLabel jl = new JLabel("          ");
    
    public ex144(String s)
    {
        super(s);
        setSize(100, 100);
        setLayout(new FlowLayout());
        add(jb);
        add(jl);
        jb.addActionListener(this);
        setVisible(true);
        
        b = new ball144();  // run constructor
        b.setSize(500, 300); // set size of frame
        b.setVisible(true);
        new Thread(b).start();  
          /* start the runnable ball b by converting to subclass
             Thread and call Thread start() method */
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        jl.setText("You clicked");
        b.end();  // end the runnable ball b
    }
    
    public static void main(String[] args) 
    {
        ex144 jf = new ex144("Click");
    }
}
```
Next, here is the ball runnable thread:

```java
package threads14;
/* Bill Wohlleber
 * Exercise 14-4
 * This class will define a moving ball
 */
import java.awt.*;
import javax.swing.*;

public class ball144 extends JFrame implements Runnable 
        /* since extends JFrame, must implements Runnable
           since can only extends one class */
{
    boolean stopflag;
    int x, y;
    Container c;
    
    public ball144()
    {
        c = getContentPane();
        c.setBackground(Color.cyan);
        stopflag = false;
        x = 0;
        y = 50;
        setTitle("Ball");
        setForeground(Color.blue);
    }
    
        /* write run() method that will switch stopflag and loop and keep 
           calling repaint() while the ball is not stopped and the ball is 
           on the frame (the ball width less than the right side). 

 When done, end the ball thread. */

    
        // write update method to not clear frame and call paint()

    
        /* write paint() method to cover only old ball, move x across the
           screen and draw only new ball */


       /* write end() method that will switch stopflag and 
          draw final ball (if necessary) */ 
```

