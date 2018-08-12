15-5

Modify attached exercise 10-4 with the border layout of the java question. Keep the label on the top left, the button under it on the left, and the answer label to the right of the other two components. But now use your own layout with `setBounds()` to align them better than in the `BorderLayout`.

```java
package graphics15;

/* Bill Wohlleber
Exercise 15-5
This program will ask a Java question
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ex155 extends JApplet implements ActionListener
{
    JLabel question = new JLabel("What does this applet call itself?");
    JButton answer = new JButton("Answer");
    Font resfont = new Font("TimesRoman", Font.BOLD, 36);
    JLabel results = new JLabel("");
    Container c;

    public void init()
    {
        setSize(400, 300);
        c = getContentPane();
        c.setLayout(null);   // take off layout
        c.setBackground(Color.cyan);
        question.setForeground(Color.blue);
        question.setHorizontalAlignment(JLabel.CENTER);  // center in area
        question.setBounds(10, 10, 200, 25);  // set area where placed
        c.add(question);
        answer.setForeground(Color.blue);
        answer.setBounds(10, 40, 100, 25);
        c.add(answer);
        results.setForeground(Color.blue);
        results.setFont(resfont);
        results.setBounds(170, 30, 100, 55);
        results.setVerticalAlignment(JLabel.CENTER);
        results.setHorizontalAlignment(JLabel.CENTER);
        c.add(results);
        answer.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        results.setText("this");
    }
}
```

