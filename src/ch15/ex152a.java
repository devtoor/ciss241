package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Random;

import static java.awt.Color.*;
import static java.awt.BasicStroke.*;

/**
 * Project: ch15
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex152a extends JApplet
{
    private final static int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 500;
    private final static int MAX_THICKNESS = 50;

    private final static Random RAND = new Random();
    private final static Color[] COLOR = {WHITE, LIGHT_GRAY, GRAY, DARK_GRAY, BLACK, RED,
                                            PINK, ORANGE, YELLOW, GREEN, MAGENTA, CYAN, BLUE};

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
        double yPointer = 0.0;

        while (yPointer < getHeight())
        {
            int vacant = (int)(getHeight() - yPointer);
            int ran = RAND.nextInt(MAX_THICKNESS) + 1;
            int entry = vacant >= ran ? ran : vacant;

            G2D.setColor(COLOR[RAND.nextInt(COLOR.length)]);
            G2D.setStroke(new BasicStroke(entry, CAP_ROUND, JOIN_ROUND));

            yPointer += entry / 2.0;
            G2D.draw(new Line2D.Double(0, yPointer, RAND.nextInt(getWidth()), yPointer));
            yPointer += entry / 2.0;
        }
    }
}