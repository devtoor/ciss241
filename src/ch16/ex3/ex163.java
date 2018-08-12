package ch16.ex3;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Project: ch16.ex3
 * Date:    3/5/2018
 *
 * @author Jay Morales
 */

public class ex163 extends JApplet implements ActionListener
{
    private JLabel instruct = new JLabel("Enter two integers and click button");
    private Font insfont = new Font("Courier", Font.ITALIC, 18);
    private JLabel num1lab = new JLabel("Integer #1");
    private JTextField num1field = new JTextField(7);
    private JLabel num2lab = new JLabel("Integer #2");
    private JTextField num2field = new JTextField(7);
    private JLabel answerlab = new JLabel("Quotient the Numbers");
    private JTextField answerfield = new JTextField(7);
    private JButton calc = new JButton("Calculate");
    private FlowLayout flow = new FlowLayout();

    @Override
    public void init()
    {
        Container c = getContentPane();
        c.setLayout(flow);
        c.setBackground(Color.cyan);
        instruct.setFont(insfont);
        instruct.setForeground(Color.blue);
        instruct.setBorder(new LineBorder(Color.BLUE, 10));
        c.add(instruct);
        num1lab.setForeground(Color.blue);
        c.add(num1lab);
        num1field.setForeground(Color.blue);
        c.add(num1field);

        num2lab.setForeground(Color.blue);
        c.add(num2lab);
        num2field.setForeground(Color.blue);
        c.add(num2field);

        answerlab.setForeground(Color.blue);
        c.add(answerlab);
        answerfield.setForeground(Color.blue);
        answerfield.setEnabled(false);
        c.add(answerfield);
        calc.setForeground(Color.blue);
        calc.setBorder(new BevelBorder(BevelBorder.RAISED));
        c.add(calc);
        num1field.requestFocus();
        num2field.addActionListener(this);
        calc.addActionListener(this);

        try
        {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception e)
        {
            System.out.println("Exception occurred");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int num1, num2;
        double ans;
        num1 = Integer.parseInt(num1field.getText());
        num2 = Integer.parseInt(num2field.getText());
        if (num2 != 0)
        {
            ans = (double)num1 / num2;
            answerfield.setText(Double.toString(ans));
        }
        else
            answerfield.setText("Can't / by 0");
    }
}
