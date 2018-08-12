# Layout review flow with grid panels

`exr11jb.java`
```java
package revpack;

/* Bill Wohlleber
Exercise r1-1ja
This program create a GUI
*/
import java.awt.*;
import javax.swing.*;

public class exr11jb extends JFrame
{
    JCheckBox snap = new JCheckBox("Snap to Grid");
    JCheckBox show = new JCheckBox("Show Grid");
    JPanel check = new JPanel();
    JLabel xlab = new JLabel("    X:");
    JTextField xfield = new JTextField("8", 3);
    JLabel ylab = new JLabel("    Y:");
    JTextField yfield = new JTextField("8", 3);
    JPanel field = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    JButton help = new JButton("Help");
    JPanel buttons = new JPanel();
    Container c;
    FlowLayout flow = new FlowLayout();
    
    public exr11jb()
    {
        super("Align");
        c = getContentPane();
        c.setLayout(flow);
        c.setBackground(Color.lightGray);
        
        GridLayout grid1 = new GridLayout(2, 1);
        check.setLayout(grid1);
        snap.setBackground(Color.lightGray);
        check.add(snap);
        show.setBackground(Color.lightGray);
        check.add(show);
        check.setBackground(Color.lightGray);
        c.add(check);
        
        GridLayout grid2 = new GridLayout(2, 2);
        field.setLayout(grid2);
        field.add(xlab);
        field.add(xfield);
        field.add(ylab);
        field.add(yfield);
        field.setBackground(Color.lightGray);
        c.add(field);
        
        GridLayout grid3 = new GridLayout(3, 1);
        buttons.setLayout(grid3);
        buttons.add(ok);
        buttons.add(cancel);
        buttons.add(help);
        buttons.setBackground(Color.lightGray);
        c.add(buttons);
        
        setSize(300, 125);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        exr11jb f = new exr11jb();
    }
}
```