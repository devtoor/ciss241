15-7

Write an applet where the user is asked their name in an input dialog box. You will then draw their name in blue in a large sized font on the applet. Using font metrics draw 2 rectangles in red and cyan around the user's name (the size will be dependent on the string but will be determined by the font metrics). 

```java
/* Bill Wohlleber
 * Exercise 15-7
 * This applet will draw my name with rectangles
 */
package graphics15;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class ex157 extends JApplet
{
    String name;
    Font f = new Font("Perpetua", Font.PLAIN, 20);
    Container c;

    public void init()
    {
        c = getContentPane();
        c.setBackground(Color.lightGray);
        name = JOptionPane.showInputDialog(null,
                "What is your name?", "Name Input",
                    JOptionPane.QUESTION_MESSAGE);
    }

    public void start()
    {
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g.setFont(f);
        FontMetrics fm = g.getFontMetrics();
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        int width = fm.stringWidth(name);
        int x = 60, y = 80;
        int border = 1;
        g2.setColor(Color.blue);
        g2.drawString(name, x, y);

 /* create a rectangle border around your name.  Move from lower left of string to upper left
of rectangle - back one border from x and up one border from y (also up the ascent amount). 
Then draw the width and height - width of string plus both borders, height of both borders
(also move back down ascent and descent of string). */

        Rectangle2D.Float r1 = new Rectangle2D.Float(x - 1 * border,
                y - (ascent + 1 * border),
                    width + 2 * border,
                        ascent + descent + 2 * border);

/* repeat by drawing second rectangle so increase size by border on all sides */

        Rectangle2D.Float r2 = new Rectangle2D.Float(x - 2 * border,
                y - (ascent + 2 * border),
                    width + 4 * border,
                        ascent + descent + 4 * border);

        g2.setColor(Color.red);
        g2.draw(r1);
        g2.setColor(Color.cyan);
        g2.draw(r2);

        System.out.println("Ascent = " + ascent);
        System.out.println("Descent = " + descent);
        System.out.println("Width = " + width);
    }
}
```