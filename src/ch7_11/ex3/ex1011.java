package ch7_11.ex3;

/* Bill Wohlleber
Exercise 10-11
This program will draw a smiley face
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex1011 extends JApplet implements ActionListener
{
    JButton smilebutton = new JButton("Change Expressions");
    boolean smile = true;
    Container c;

    public void init()
    {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        c.setBackground(Color.blue);
        smilebutton.setForeground(Color.cyan);
        c.add(smilebutton);
        smilebutton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        smile = !smile;
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.yellow);
        g.fillOval(50, 50, 100, 100);
        g.setColor(Color.black);
        g.fillOval(85, 80, 10, 20);
        g.fillOval(105, 80, 10, 20);
        if (smile)
            g.drawArc(70, 70, 60, 60, 200, 140);
        else
            g.drawArc(70, 110, 60, 60, 160, -140);
    }
}