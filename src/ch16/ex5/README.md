16-5

Write a program that uses a `JSlider `to let the user pick the radius of a filled in oval to draw on a `JApplet`.  Let the user draw an oval with a radius from 50 to 150 pixels.  Include tick marks and labels on the slider.

The following is a walk through:

```java
package gui16;
/* Bill Wohlleber
 * Exercise 16-5
 * This applet will use a slider to draw an oval
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ex165 extends JApplet implements ChangeListener
{
    JSlider js;
    int radius = 0;
    Container c;
   
    public void init()
    {
        setSize(400, 400);
		/* slider bar horizontal */
        js = new JSlider(SwingConstants.HORIZONTAL, 50, 150, 50);
        js.setMajorTickSpacing(10); // mark every 10 pixels
        js.setPaintTicks(true);     // show tick marks
        js.setPaintLabels(true);    // show tick mark labels
        js.addChangeListener(this);  // listen to any changes in slider
        c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(js, "South");    // put slider in bottom of applet
        c.setBackground(Color.blue);
    }
   
    public void stateChanged(ChangeEvent e) // ChangeListener abstract method
    {
        radius = js.getValue(); // get value off of slider
        repaint();  // redraw circle based upon new radius value from slider
    }
   
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.cyan);
  		/* width and height is 2 * radius from slider value */
        g.fillOval(10, 10, 2 * radius, 2 * radius);
    }
}
```

