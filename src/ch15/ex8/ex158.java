package ch15.ex8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static java.awt.Font.*;

/**
 * Project: ch15.ex8
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex158 extends JApplet
{
    private final static int COMPONENT_WIDTH = 500;
    private final static int COMPONENT_HEIGHT = 300;
    private final static int BORDER_THICKNESS = 5;
    private final static int MARGIN = 10;
    private final static int NUM_REC = 5;
    private final static Random RAND = new Random();
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
        final Graphics2D G2D = (Graphics2D) g;
        G2D.setFont(TNR);
        final FontMetrics FM = G2D.getFontMetrics();
        final int TEXT_WIDTH = FM.stringWidth(input);
        final int TEXT_HEIGHT = FM.getHeight();

        int x = getWidth() / 2 - TEXT_WIDTH / 2;
        int y = getHeight() /2 + FM.getAscent() / 2;

        G2D.drawString(input, x, y);

        x -= MARGIN;
        y -= FM.getAscent() + MARGIN;

        G2D.setStroke(new BasicStroke(BORDER_THICKNESS));
        for (int i = 1; i <= NUM_REC; i++, x -= MARGIN, y -= MARGIN )
        {
            G2D.setColor(new Color(RAND.nextInt(256), RAND.nextInt(256), RAND.nextInt(256)));
            G2D.drawRect(x, y, TEXT_WIDTH + 2 * i * MARGIN, TEXT_HEIGHT + 2 * i * MARGIN);
        }
    }
}