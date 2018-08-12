package ch15;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

import static java.awt.Color.*;

/**
 * Project: ch15.ex10
 * Date:    2/27/2018
 *
 * @author Jay Morales
 */

public class ex1510 extends JApplet
{
    private Image logo;
    private int bg = 0;
    private URL base;
    private Color[] bground = {YELLOW, PINK, LIGHT_GRAY, CYAN};
    private static final int APP_WIDTH = 800;
    private static final int APP_HEIGHT = 150;

    @Override
    public void init()
    {

        setSize(APP_WIDTH, APP_HEIGHT);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(bground[bg++]);
        c.add(new JCheckBox("Web") {{
            setBackground(null);
            doClick();
            setBounds(320, 40, 80, 20);
        }});
        c.add(new JCheckBox("Image") {{
            setBackground(null);
            setBounds(420, 40, 80, 20);
        }});
        c.add(new TextField(100) {{
            setBounds(320, 70, 320, 25);
        }});
        c.add(new JButton("Search") {{
            setBounds(650, 70, 80, 25);
        }});

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            // You may edit this. The getgetCodeBase() and getDocumentBase() doesn't work in intelliJ
            base = new URL("file:C:\\Users\\devtoor\\Documents\\IdeaProjects\\ciss241\\src\\ch15\\");
            logo = getImage(base, "lycos.png");

        }
        catch (Exception ignore){ignore.getMessage();}

        new Thread(() ->
        {
            while (true)
            {
                try
                {
                    c.setBackground(bground[bg = bg < bground.length - 1 ? ++bg : 0]);
                    repaint();
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
            }
        }).start();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(logo, 50, 30, this);
    }
}