package ch15.ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import static java.awt.BasicStroke.*;
import static java.awt.Color.*;

/**
 * Project: ch15.ex3
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex153 extends JApplet
{
    private final static int MARGIN = 15;
    private final static int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 500;
    private final static Path2D PATH_2D = new GeneralPath();

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
        final double CENTER_X = getWidth() / 2 - baseLength(1.0);
        final Point P1 = new Point(CENTER_X, MARGIN);
        final Point P2 = new Point(CENTER_X + baseLength(5.5), baseLength(7.5));
        final Point P3 = new Point(CENTER_X - baseLength(3.0), baseLength(9.5));
        final Point P4 = new Point(CENTER_X - baseLength(3.5), baseLength(6.0));

        PATH_2D.reset();
        moveTo(P1);
        lineTo(P3);
        lineTo(P4);
        PATH_2D.closePath();
        G2D.setColor(GRAY);
        G2D.fill(PATH_2D);

        PATH_2D.reset();
        moveTo(P1);
        lineTo(P2);
        lineTo(P3);
        PATH_2D.closePath();
        G2D.setColor(LIGHT_GRAY);
        G2D.fill(PATH_2D);

        lineTo(P4);
        lineTo(P3);
        G2D.setStroke(new BasicStroke(3, CAP_ROUND, JOIN_ROUND));
        G2D.setColor(BLACK);
        G2D.draw(PATH_2D);
    }

    private double baseLength(final double LEN)
    {
        return (getHeight() - (MARGIN * 2.0)) * LEN / 10.0;
    }

    private static void moveTo(final Point p)
    {
        PATH_2D.moveTo(p.X, p.Y);
    }

    private static void lineTo(final Point p)
    {
        PATH_2D.lineTo(p.X, p.Y);
    }

    private final static class Point
    {
        final double X;
        final double Y;

        private Point(final double x, final double y)
        {
            this.X = x;
            this.Y = y;
        }
    }
}