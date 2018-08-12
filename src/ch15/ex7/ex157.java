package ch15.ex7;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;
import static java.awt.Font.*;

/**
 * Project: ch15.ex7
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex157 extends JApplet
{
    private final static int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 300;
    private final static int MARGIN = 10;
    private final static Font TNR = new Font("TimesRoman", BOLD, 72);
    private String input;

    @Override
    public void init()
    {
        setSize(COMPONENT_WIDTH, COMPONENT_HEIGHT);
        input = JOptionPane.showInputDialog("Enter your name");
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setFont(TNR);
        final FontMetrics FM = g.getFontMetrics();
        final int TEXT_WIDTH = FM.stringWidth(input);
        final int TEXT_HEIGHT = FM.getHeight();
        final int X = getWidth() / 2 - TEXT_WIDTH / 2;
        final int Y = getHeight() /2 + FM.getAscent() / 2;

        g.drawString(input, X, Y);
        g.setColor(CYAN);
        g.drawRect(X - MARGIN, Y - FM.getAscent() - MARGIN, TEXT_WIDTH + 2 * MARGIN, TEXT_HEIGHT + 2 * MARGIN);
        g.setColor(BLUE);
        g.drawRect(X - 2 * MARGIN, Y - FM.getAscent() - 2 * MARGIN, TEXT_WIDTH + 4 * MARGIN, TEXT_HEIGHT + 4 * MARGIN);
    }
}
