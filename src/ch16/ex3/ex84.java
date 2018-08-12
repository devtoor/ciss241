package ch16.ex3;

/* Bill Wohlleber
Exercise 8-4
This applet will sum two numbers
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex84 extends JApplet implements ActionListener
{
	JLabel instruct = new JLabel("Enter two integers and click button");
	Font insfont = new Font("Courier", Font.ITALIC, 18);
	JLabel num1lab = new JLabel("Integer #1");
	JTextField num1field = new JTextField(7);
	JLabel num2lab = new JLabel("Integer #2");
	JTextField num2field = new JTextField(7);
	JLabel answerlab = new JLabel("Quotient the Numbers");
	JTextField answerfield = new JTextField(7);
	JButton calc = new JButton("Calculate");
	Container c;
	FlowLayout flow = new FlowLayout();

	public void init()
	{
		c = getContentPane();
		c.setLayout(flow);
		c.setBackground(Color.cyan);
		instruct.setFont(insfont);
		instruct.setForeground(Color.blue);
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
		c.add(calc);
		num1field.requestFocus();
		num2field.addActionListener(this);
		calc.addActionListener(this);
	}

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