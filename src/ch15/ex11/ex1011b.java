package ch15.ex11;

/* Bill Wohlleber
Exercise 10-11b
This program will draw a smiley face
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex1011b extends JApplet implements ActionListener
{
    JButton smilebutton = new JButton("Change Expressions");
    JButton winkbutton = new JButton("Wink At You");
    boolean smile = true, wink = false;
    Container c;

    public void init()
    {
        setSize(300, 200);
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.blue);
        smilebutton.setForeground(Color.cyan);
        c.add(smilebutton);
        winkbutton.setForeground(Color.cyan);
        c.add(winkbutton);
        smilebutton.addActionListener(this);
        winkbutton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == smilebutton)
            smile = !smile;
        else
            wink = !wink;
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.yellow);
        g.fillOval(50, 50, 100, 100);
        g.setColor(Color.black);
        g.fillOval(85, 80, 10, 20);
        if (wink)
            g.fillOval(105, 88, 10, 5);
        else
            g.fillOval(105, 80, 10, 20);
        if (smile)
            g.drawArc(70, 70, 60, 60, 200, 140);
        else
            g.drawArc(70, 110, 60, 60, 160, -140);
    }
}