package ch15.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.util.Random;

/**
 * Project: ch15.ex2
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex152 extends JApplet
{
    private final static  int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 500;
    private final static Random RAND = new Random();
    private final static Path2D PATH_2D = new GeneralPath();

    @Override
    public void init()
    {
        setSize(COMPONENT_WIDTH, COMPONENT_HEIGHT);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        final Graphics2D G2D = (Graphics2D) g;

        PATH_2D.reset();
        PATH_2D.moveTo(RAND.nextInt(getWidth()), RAND.nextInt(getHeight()));
        PATH_2D.lineTo(RAND.nextInt(getWidth()), RAND.nextInt(getHeight()));
        PATH_2D.lineTo(RAND.nextInt(getWidth()), RAND.nextInt(getHeight()));
        PATH_2D.closePath();

        G2D.setColor(new Color(RAND.nextInt(256), RAND.nextInt(256), RAND.nextInt(256)));
        G2D.setStroke(new BasicStroke(RAND.nextFloat() * 20));
        G2D.draw(PATH_2D);
    }
}