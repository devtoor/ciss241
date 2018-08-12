package ch16;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

/**
 * Project: ch16
 * Date:    3/25/2018
 *
 * @author Jay Morales
 */

public class ex164 extends JApplet implements ActionListener
{
    private JButton b = new JButton("Brosius");
    private JButton m = new JButton("Martinez");
    private JButton j = new JButton("Jeter");
    private JToolBar bar = new JToolBar(SwingConstants.VERTICAL);
    private JMenuItem br = new JMenuItem("Brosius");
    private JMenuItem ma = new JMenuItem("Martinez");
    private JMenuItem je = new JMenuItem("Jeter");
    private JMenu homers = new JMenu("Home Runs");
    private JMenuBar mbar = new JMenuBar();
    private Image bros, mart, jet;

    public void init()
    {
        setSize(500, 500);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        /* set hot keys, add buttons to the toolbar, add the toolbar into the
           applet, listen to the buttons, and get the images */
        // then add menu bar with menu and menu items
        b.setMnemonic('b');
        m.setMnemonic('m');
        j.setMnemonic('j');
        br.setMnemonic('b');
        ma.setMnemonic('m');
        je.setMnemonic('j');
        homers.setMnemonic('h');

        bar.add(b);
        bar.add(m);
        bar.add(j);
        homers.add(br);
        homers.add(ma);
        homers.add(je);
        mbar.add(homers);

        c.add(bar);
        setJMenuBar(mbar);

        b.addActionListener(this);
        m.addActionListener(this);
        j.addActionListener(this);
        br.addActionListener(this);
        ma.addActionListener(this);
        je.addActionListener(this);

        try
        {
            URL base = new URL("file:C:\\Users\\devtoor\\Documents\\IdeaProjects\\ciss241\\src\\ch16\\");
            bros = getImage(base, "brosius1.jpg");
            mart = getImage(base, "martinez1.jpg");
            jet = getImage(base, "jeter1.jpg");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        Graphics g = getGraphics();  // to draw
        paint(g);  // clear screen

        // add e.getSource() being the menu items (or toolbar) to if tests
        // if click on b button draw brosius at 100, 100
        if (e.getSource() == b || e.getSource() == br)
            g.drawImage(bros, 100, 100, this);
        else if (e.getSource() == m || e.getSource() == ma)
            g.drawImage(mart, 100, 100, this);
        else if (e.getSource() == j || e.getSource() == je)
            g.drawImage(jet, 100, 100, this);
    }
}
