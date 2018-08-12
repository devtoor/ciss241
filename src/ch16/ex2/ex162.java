package ch16.ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Objects;

/**
 * Project: ch16.ex2
 * Date:    3/5/2018
 *
 * @author Jay Morales
 */

public class ex162 extends JApplet implements ActionListener
{
    private JButton b = new JButton("Brosius");
    private JButton m = new JButton("Martinez");
    private JButton j = new JButton("Jeter");
    private JToolBar bar = new JToolBar(SwingConstants.VERTICAL);
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
        m.setMnemonic('m');
        m.addActionListener(this);
        j.setMnemonic('j');
        j.addActionListener(this);

        bar.add(b);
        bar.add(m);
        bar.add(j);

        getContentPane().add(bar);

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
            g.drawImage(image, 100, 100, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == b)
            image = bros;
        else if (e.getSource() == m)
            image = mart;
        else if (e.getSource() == j)
            image = jet;

        repaint();
    }
}