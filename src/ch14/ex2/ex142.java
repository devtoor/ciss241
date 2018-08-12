package ch14.ex2;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

/**
 * Project: ch14.ex2
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex142 extends JApplet
{
    private int hour,
            minute,
            second;
    private boolean firstRun;

    @Override
    public void init()
    {
        hour = LocalTime.now().getHour();
        minute = LocalTime.now().getMinute();
        second = LocalTime.now().getSecond();
        firstRun = true;
    }

    @Override
    public void start()
    {
        firstRun = true;
        repaint();
    }


    @Override
    public void paint(Graphics g)
    {
        int temp;

        if (firstRun)
        {
            firstRun = false;
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.BOLD, 40));
            g.drawString("The time is", 100, 100);
            g.drawString(String.format("%02d : ", hour), 100, 160);
            g.drawString(String.format("%02d : ", minute), 180, 160);
            g.drawString(String.format("%02d", second), 260, 160);
        }
        else
        {
            g.setFont(new Font("Serif", Font.BOLD, 40));
            if ((temp = LocalTime.now().getSecond()) != second)
            {
                g.setColor(Color.WHITE);
                g.drawString(String.format("%02d : ", second), 260, 160);
                second = temp;
                g.setColor(Color.BLACK);
                g.drawString(String.format("%02d", second), 260, 160);
            }

            if ((temp = LocalTime.now().getMinute()) != minute)
            {
                g.setColor(Color.WHITE);
                g.drawString(String.format("%02d : ", minute), 180, 160);
                minute = temp;
                g.setColor(Color.BLACK);
                g.drawString(String.format("%02d : ", minute), 180, 160);
            }

            if ((temp = LocalTime.now().getHour()) != hour)
            {
                g.setColor(Color.WHITE);
                g.drawString(String.format("%02d : ", hour), 100, 160);
                hour = temp;
                g.setColor(Color.BLACK);
                g.drawString(String.format("%02d : ", hour), 100, 160);
            }
        }
        repaint();
    }
}