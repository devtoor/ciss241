package ch15.ex4;

/* Bill Wohlleber
Exercise 8-1
This program will ask a Java question
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ex81 extends JApplet implements ActionListener
{
    JLabel question = new JLabel("What does this applet call itself?");
    JButton answer = new JButton("Answer");
    Font resfont = new Font("TimesRoman", Font.BOLD, 36);
    JLabel results = new JLabel("             ");
    Container c;
    FlowLayout flow = new FlowLayout();

    public void init()
    {
        c = getContentPane();
        c.setLayout(flow);
        c.setBackground(Color.cyan);
        question.setForeground(Color.blue);
        c.add(question);
        answer.setForeground(Color.blue);
        c.add(answer);
        results.setForeground(Color.blue);
        results.setFont(resfont);
        c.add(results);
        answer.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        results.setText("this");
    }
}