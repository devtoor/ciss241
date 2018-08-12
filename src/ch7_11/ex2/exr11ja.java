package ch7_11.ex2;

/* Bill Wohlleber
Exercise r1-1ja
This program create a GUI
*/
import java.awt.*;
import javax.swing.*;

public class exr11ja extends JFrame
{
    JCheckBox snap = new JCheckBox("Snap to Grid");
    JCheckBox show = new JCheckBox("Show Grid");
    JPanel check = new JPanel();
    JLabel xlab = new JLabel("    X:");
    JTextField xfield = new JTextField("8", 3);
    JLabel ylab = new JLabel("    Y:");
    JTextField yfield = new JTextField("8", 3);
    JPanel field = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    JButton help = new JButton("Help");
    JPanel buttons = new JPanel();
    Container c;

    public exr11ja()
    {
        super("Align");
    }

    public static void main(String[] args)
    {
        exr11ja f = new exr11ja();
    }
}