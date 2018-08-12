package ch14.ex4;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.*;

/**
 * Project: ch14.ex4
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class ex144
{
    private static class BallFrame extends JFrame implements Runnable
    {
        boolean initial = true;
        int pos = 0;

        @Override
        public void run()
        {
            try
            {
                setSize(600, 100);
                setLocation(500, 200);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);
                while (pos < 570)
                {
                    repaint();
                    Thread.sleep(5);
                }
            }
            catch (InterruptedException e) {}
            super.dispose();
        }

        @Override
        public void paint(Graphics g)
        {
            if (initial)
            {
                initial = false;
                g.setColor(red);
                g.fillOval(pos, 50, 20,20);
            }
            else
            {
                g.setColor(white);
                g.fillOval(pos++, 50, 20,20);
                g.setColor(red);
                g.fillOval(pos, 50, 20,20);
            }
        }
    }

    private static class ClickFrame extends JFrame implements Runnable
    {
        @Override
        public void run()
        {
            setSize(120, 80);
            setLocation(500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JButton button = new JButton("End me!");
            button.addActionListener(e -> super.dispose());
            getContentPane().add(new JPanel().add(button).getParent());
            setVisible(true);
        }
    }

    public static void main(String[] args)
    {
        new Thread(new BallFrame()).start();
        new Thread(new ClickFrame()).start();
    }
}