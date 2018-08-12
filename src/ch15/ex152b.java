package ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.Random;

import static java.lang.Math.*;

/**
 * Project: ch15
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex152b extends JApplet
{
    private final static int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 500;
    private final static int STROKE_MAX_THICKNESS = 10;
    private final static int POINTS_MIN_DISTANCE = 150;
    private final static int MARGIN = 30;

    private final static Random RAND = new Random();
    private final static GeneralPath GENERAL_PATH = new GeneralPath();

    private static Point point1;
    private static Point point2;
    private static Point point3;

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
        getNewPoints();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        final Graphics2D G2D = (Graphics2D) g;

        GENERAL_PATH.reset();
        GENERAL_PATH.moveTo(point1.X, point1.Y);
        GENERAL_PATH.lineTo(point2.X, point2.Y);
        GENERAL_PATH.lineTo(point3.X, point3.Y);
        GENERAL_PATH.closePath();

        G2D.setColor(randomColor());
        G2D.fill(GENERAL_PATH);

        G2D.setColor(randomColor());
        G2D.setStroke(randomStroke());
        G2D.draw(GENERAL_PATH);

        getNewPoints();
    }

    private void getNewPoints()
    {
        do
        {
            point1 = new Point(randomX(), randomY());
            point2 = new Point(randomX(), randomY());
            point3 = new Point(randomX(), randomY());
        }
        while (isNotValidDistance(point1, point2) ||
                isNotValidDistance(point1, point3) ||
                isNotValidDistance(point2, point3));
    }

    private boolean isNotValidDistance(Point a, Point b)
    {
        return  sqrt(pow(b.X - a.X, 2) + pow(b.Y - a.Y, 2)) <= (double) POINTS_MIN_DISTANCE;
    }

    private int randomX()
    {
        return RAND.nextInt(getWidth() - 2 * MARGIN) + MARGIN;
    }

    private int randomY()
    {
        return RAND.nextInt(getHeight() - 2 * MARGIN) + MARGIN;
    }

    private Color randomColor()
    {
        return new Color(RAND.nextInt(256), RAND.nextInt(256), RAND.nextInt(256));
    }

    private BasicStroke randomStroke()
    {
        return new BasicStroke(RAND.nextInt(STROKE_MAX_THICKNESS) + 1);
    }

    private final class Point
    {
        private final int X;
        private final int Y;

        private Point(int x, int y)
        {
            X = x;
            Y = y;
        }
    }
}