package ch14;

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