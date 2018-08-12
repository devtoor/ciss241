package ch14.ex3;

import javax.swing.*;
import java.awt.*;
import static java.lang.Math.*;

/**
 * Project: ch14.ex3
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex143 extends JApplet
{
    private final int numFrames = 100;
    private int[] lhx1 = new int[numFrames];
    private int[] lhy1 = new int[numFrames];
    private int[] lhx2 = new int[numFrames];
    private int[] lhy2 = new int[numFrames];
    private int[] rhx1 = new int[numFrames];
    private int[] rhy1 = new int[numFrames];
    private int[] rhx2 = new int[numFrames];
    private int[] rhy2 = new int[numFrames];
    private int[] lfx1 = new int[numFrames];
    private int[] lfy1 = new int[numFrames];
    private int[] lfx2 = new int[numFrames];
    private int[] lfy2 = new int[numFrames];
    private int[] rfx1 = new int[numFrames];
    private int[] rfy1 = new int[numFrames];
    private int[] rfx2 = new int[numFrames];
    private int[] rfy2 = new int[numFrames];

    private int frame;
    private boolean forward;
    private boolean initial;

    @Override
    public void init()
    {
        for (int i = 0; i < numFrames; i++)
        {
            lhx1[i] = 80 + (int)(abs(80.0 - 110) / numFrames * i);
            lhy1[i] = 120 - (int)(abs(120.0 - 30) / numFrames * i);
            lhx2[i] = 160 + (int)(abs(160.0 - 160) / numFrames * i);
            lhy2[i] = 100 + (int)(abs(100.0 - 100) / numFrames * i);

            rhx1[i] = 240 - (int)(abs(240.0 - 210) / numFrames * i);
            rhy1[i] = 120 - (int)(abs(120.0 - 30) / numFrames * i);
            rhx2[i] = 160 + (int)(abs(160.0 - 160) / numFrames * i);
            rhy2[i] = 100 + (int)(abs(100.0 - 100) / numFrames * i);

            lfx1[i] = 120 + (int)(abs(120.0 - 150) / numFrames * i);
            lfy1[i] = 270 + (int)(abs(270.0 - 280) / numFrames * i);
            lfx2[i] = 160 + (int)(abs(160.0 - 160) / numFrames * i);
            lfy2[i] = 160 + (int)(abs(160.0 - 160) / numFrames * i);

            rfx1[i] = 200 - (int)(abs(200.0 - 170) / numFrames * i);
            rfy1[i] = 270 + (int)(abs(270.0 - 280) / numFrames * i);
            rfx2[i] = 160 + (int)(abs(160.0 - 160) / numFrames * i);
            rfy2[i] = 160 + (int)(abs(160.0 - 160) / numFrames * i);
        }
        frame = 0;
        forward = true;
        initial = true;
    }

    @Override
    public void start()
    {
        initial = true;
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        if (initial)
        {
            initial = false;
            g.setColor(Color.BLACK);
            g.fillOval(145, 50, 30, 30);
            g.drawLine(160, 80, 160, 160);
            drawLines(g);
        }
        else
        {
            g.setColor(Color.WHITE);
            drawLines(g);
            if (forward)
            {
                frame++;
                g.setColor(Color.BLACK);
                drawLines(g);

                if (frame == (numFrames -1))
                    forward = false;
            }
            else
            {
                frame--;
                g.setColor(Color.BLACK);
                drawLines(g);

                if (frame == 0)
                    forward = true;
            }
        }

        try
        {
            Thread.sleep(5);
        }
        catch (InterruptedException e) {}

        repaint();
    }

    private void drawLines(Graphics g)
    {
        g.drawLine(lhx1[frame], lhy1[frame], lhx2[frame], lhy2[frame]);
        g.drawLine(rhx1[frame], rhy1[frame], rhx2[frame], rhy2[frame]);
        g.drawLine(lfx1[frame], lfy1[frame], lfx2[frame], lfy2[frame]);
        g.drawLine(rfx1[frame], rfy1[frame], rfx2[frame], rfy2[frame]);
    }
}