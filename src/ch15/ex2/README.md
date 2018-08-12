15-2

Write an applet that will draw random colored (from an array of Color objects):                        

​a. Random thick lines - use `Line2D` objects with rounded edges.  Set it up like a horizontal bar chart with a series of lines going from left to right.  The x coordinate will be starting from the left edge, the y coordinate will increment a set amount, and the `width` and `height` will be random numbers (but keep the height on the chart and the width on the applet).  Use a for loop to loop through all the drawn lines with the loop variable being the y coordinate that will increment the lines vertically. 

​b. Random sized triangles - use `GeneralPath` objects. The series of triangles will have random x, y coordinates for all three points of each triangle. You can (partially) stack the triangles on top of each other. 

```java
/* Bill Wohlleber
 * Exercise 15-2b
 * This applet will draw random colored and random thick lines
 * */
package graphics15;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class ex152b extends JApplet
{
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
       
        Color[] colors = {Color.blue, Color.cyan, Color.red, Color.green,
                Color.yellow, Color.pink, Color.gray, Color.lightGray,
                    Color.darkGray, Color.magenta, Color.orange};
        int y, w, c;
        float h;
        BasicStroke b;
       
        int x, i;
        GeneralPath triangle;
       
        for (i = 1; i <= 10; i++)
        {
            triangle = new GeneralPath();
                       // 1st triangle point
            x = (int)(Math.random() * 351 + 25); // random x 25 - 375
            y = (int)(Math.random() * 251 + 25); // random y 25 - 275
            triangle.moveTo(x, y);
                      // 2nd triangle point
            x = (int)(Math.random() * 351 + 25);
            y = (int)(Math.random() * 251 + 25);
            triangle.lineTo(x, y);
                      // 3rd triangle point
            x = (int)(Math.random() * 351 + 25);
            y = (int)(Math.random() * 251 + 25);
            triangle.lineTo(x, y);

            triangle.closePath();
                 // random color from array
            c = (int)(Math.random() * colors.length);
            g2.setColor(colors[c]);
                 // does the actual drawing
            g2.fill(triangle);
        }
    }
}
```

