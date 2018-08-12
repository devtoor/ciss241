package ch14;

import java.awt.*;
import javax.swing.*;
import static java.awt.Color.red;
import static java.awt.Color.white;

/**
 * Project: ch14
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ball144 extends JFrame implements Runnable
{
/*
    since extends JFrame, must implements Runnable since can
    only extends one class
 */
    private boolean stopflag;
    private int x, y;
    private boolean first;

    public ball144()
    {
        // The default close operation is HIDE_ON_CLOSE.
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBackground(white);
        stopflag = false;
        x = 0;
        y = 50;
        setTitle("Ball");
        first = true;
    }
    /*
        write run() method that will switch stopflag and loop and keep
        calling repaint() while the ball is not stopped and the ball is
        on the frame (the ball width less than the right side).

        When done, end the ball thread.
     */
    @Override
    public void run()
    {
        try
        {
            while (!stopflag && x < getWidth() - 30)
            {
                repaint();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException ignore) {}
        // I need to dispose the frame object, although the task is done
        // the frame object and button listeners are still active on the
        // background and consuming memory resources.
        super.dispose();
    }
    /*
        write update method to not clear frame and call paint()
     */
    @Override
    public void update(Graphics g)
    // FYI: JFrame class already overridden this method from Container class to prevent
    // an unnecessary call to clear the background. No need if extends the JFrame class.
    // The JFrame's update(Graphics g) method has 1 statement and only calls paint(g).
    {
        paint(g);
    }
    /*
        write paint() method to cover old ball, move x across the screen and
        draw new ball
     */
    @Override
    public void paint(Graphics g)
    {
        if (first)
        {
            first = false;
            g.setColor(red);
            g.fillOval(x, y, 20,20);
        }
        else
        {
            g.setColor(white);
            g.fillOval(x, y, 20,20);
            g.setColor(red);
            g.fillOval(++x, y, 20,20);
        }
    }
    /*
        write end() method that will switch stopflag and draw final ball
     */
    public void end()
    {
        stopflag = true;
    }
}