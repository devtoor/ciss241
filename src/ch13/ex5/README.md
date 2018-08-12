13-5

Create a text file of the alphabet. Then write a program that will let the user pick a spot in the file (by number) you will move up to that spot in the file. You will print the 5 letters from that spot forward. If there are not 5 letters left, just print the letters to the end of the alphabet file, so check for reading beyond the eof marker. The alphabet file is attached.

Here is a walk through of the program:

```java
package files13;

/* Bill Wohlleber
Exercise 13-5b
This program will let the user print 5 characters from different spots
in an alphabet file
*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex135b extends JFrame implements ActionListener
{
    JLabel ins = new JLabel("Enter a position in file:  ");
    JTextField pos = new JTextField(3);
    JLabel message = new JLabel("Contents are");
    JTextField contents = new JTextField(6);
    JButton getdata = new JButton("Get Data");
    Container c;
    RandomAccessFile alpha;

    public ex135b()
    {
        super("Read File");
        c = getContentPane();

        try
        {
/* connect RandomAccessFile stream to the alphabet.txt file for reading */
            alpha = new RandomAccessFile("files13\\alphabet.txt", "r");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        setSize(400, 300);
        c.setLayout(new FlowLayout());
        c.add(ins);
        c.add(pos);
        c.add(message);
        c.add(contents);
        c.add(getdata);
        pos.addActionListener(this);
        getdata.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        int c, i, p;
        String s = "";
        try
        {
    /* user tells number of letters to move up */
            p = Integer.parseInt(pos.getText());
    /* move up to user's spot in file,
    ex. spot 5 which is 4 characters up to to letter e */
            alpha.seek(p - 1);
            for (i = 1; i <= 5; i++)
            {
                c = alpha.read(); // read char one by one
                if (c != -1)
                    s += (char)c; // concatenate to 5 char string
                else
                    break;
            }
            contents.setText(s);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            System.exit(1);
        }
        catch(NumberFormatException nf)
        {
            nf.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args)
    {
        ex135b f = new ex135b();
    }
}
```

