16-2

Write an applet that will use a vertical toolbar (that the user can float out of the applet) to let the user pick what graphic they would like to display.  Use hot keys for the buttons on the toolbar as well.  Attached are three Yankee home run images that the user can pick from (remember to add them to the project, where the program is in the 
package gui16).

Fill in the missing code below in the `init()` method:

```java
package gui16;
/* Bill Wohlleber
 * Exercise 16-2
 * This program will use a toolbar to pick a graphic
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ex162 extends JApplet implements ActionListener
{
    JButton b = new JButton("Brosius");
    JButton m = new JButton("Martinez");
    JButton j = new JButton("Jeter");
    JToolBar bar = new JToolBar(SwingConstants.VERTICAL);
    Container c;
    Image bros, mart, jet;

    public void init()
    {
        setSize(500, 500);
        c = getContentPane();
        c.setLayout(new FlowLayout());

        /* 	set hot keys, add buttons to the toolbar, add the 				toolbar into the
           	applet, listen to the buttons, and get the images */

    }

    public void actionPerformed(ActionEvent e)
    {
        Graphics g = getGraphics();  // to draw
        paint(g);  // clear screen
 		// if click on b button draw brosius at 100, 100     
        if (e.getSource() == b) 
            g.drawImage(bros, 100, 100, this);
        else if (e.getSource() == m)
            g.drawImage(mart, 100, 100, this);
        else if (e.getSource() == j)
            g.drawImage(jet, 100, 100, this);
    }
}
```

