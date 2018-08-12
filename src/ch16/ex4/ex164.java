package ch16.ex4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Objects;

/**
 * Project: ch16.ex4
 * Date:    3/5/2018
 *
 * @author Jay Morales
 */

public class ex164 extends JApplet implements ActionListener
{
    private JButton b = new JButton("Brosius");
    private JButton m = new JButton("Martinez");
    private JButton j = new JButton("Jeter");
    private JMenuItem b1 = new JMenuItem("Brosius");
    private JMenuItem m1 = new JMenuItem("Martinez");
    private JMenuItem j1 = new JMenuItem("Jeter");
    private JToolBar bar = new JToolBar(SwingConstants.VERTICAL);
    private JMenu graphics = new JMenu("Graphics");
    private JMenuBar menuBar = new JMenuBar();
    private Image bros, mart, jet;
    private Image image = null;

    @Override
    public void init()
    {
        setSize(500, 500);
        getContentPane().setLayout(new FlowLayout());

        /* 	set hot keys, add buttons to the toolbar, add the toolbar into the
            applet, listen to the buttons, and get the images */
        b.setMnemonic('b');
        b.addActionListener(this);
        b1.addActionListener(this);
        m.setMnemonic('m');
        m.addActionListener(this);
        m1.addActionListener(this);
        j.setMnemonic('j');
        j.addActionListener(this);
        j1.addActionListener(this);

        bar.add(b);
        bar.add(m);
        bar.add(j);
        graphics.add(b1);
        graphics.add(m1);
        graphics.add(j1);

        getContentPane().add(bar);
        menuBar.add(graphics);
        setJMenuBar(menuBar);

        try
        {
            URL base = new URL("file:C:\\Users\\devtoor\\Documents\\IdeaProjects\\ciss241\\src\\ch16\\ex2\\");
            bros = getImage(base, "brosius1.jpg");
            mart = getImage(base, "martinez1.jpg");
            jet = getImage(base, "jeter1.jpg");
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (Objects.nonNull(image))
        {
            g.drawImage(image, 150, 150, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b || e.getSource() == b1)
            image = bros;
        else if (e.getSource() == m || e.getSource() == m1)
            image = mart;
        else if (e.getSource() == j || e.getSource() == j1)
            image = jet;

        repaint();
    }
}