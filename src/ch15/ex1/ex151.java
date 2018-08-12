package ch15.ex1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Project: ch15.ex1
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex151 extends JApplet
{
    private final static int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 500;
    private final static double GAP = 30.0;
    private final static int NUM_LINES = 7;

    @Override
    public void init()
    {
        setSize(COMPONENT_WIDTH, COMPONENT_HEIGHT);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        final Graphics2D G2D = (Graphics2D) g;
        final double CENTER_X = getWidth() / 2;
        final double CENTER_Y = getHeight() / 2;

        double rad = GAP * NUM_LINES;

        while (rad > GAP)
        {
            G2D.draw(new Ellipse2D.Double(CENTER_X - rad, CENTER_Y - rad, rad * 2, rad * 2));
            rad -= GAP;
        }
        G2D.fill(new Ellipse2D.Double(CENTER_X - rad, CENTER_Y - rad, rad * 2, rad * 2));
    }
}