package ch16.ex5;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Project: ch16.ex5
 * Date:    3/5/2018
 *
 * @author Jay Morales
 */

public class ex165 extends JApplet implements ChangeListener
{
    private JSlider js;
    private int radius = 0;

    public void init()
    {
        setSize(400, 400);
        /* slider bar horizontal */
        js = new JSlider(SwingConstants.HORIZONTAL, 50, 150, 50);
        js.setMajorTickSpacing(10);     // mark every 10 pixels
        js.setPaintTicks(true);         // show tick marks
        js.setPaintLabels(true);        // show tick mark labels
        js.addChangeListener(this);     // listen to any changes in slider
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(js, "South");             // put slider in bottom of applet
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
        g.fillOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
    }
}