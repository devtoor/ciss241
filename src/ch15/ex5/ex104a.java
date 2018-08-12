package ch15.ex5;

/* Bill Wohlleber
Exercise 10-4a
This applet will ask a Java question
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex104a extends JApplet implements ActionListener
{
    JLabel question = new JLabel("What does this applet call itself?");
    JButton answer = new JButton("Answer");
    Font resfont = new Font("TimesRoman", Font.BOLD, 36);
    JLabel results = new JLabel("             ");
    BorderLayout bord = new BorderLayout();
    Container c;

    public void init()
    {
        c = getContentPane();
        c.setLayout(bord);
        c.setBackground(Color.cyan);
        question.setForeground(Color.blue);
        question.setHorizontalAlignment(JLabel.CENTER);
        c.add(question, bord.NORTH);
        answer.setForeground(Color.blue);
        c.add(answer, bord.WEST);
        results.setForeground(Color.blue);
        results.setFont(resfont);
        c.add(results, bord.EAST);
        answer.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        results.setText("this");
    }
}