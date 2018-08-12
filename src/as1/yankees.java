package as1;
// package files13;

/* Bill Wohlleber
Exercise yankees
This class will define yankees
*/
import java.io.Serializable;
public class yankees implements Serializable
{
	private static final long serialVersionUID = 7532751864233756487L;
	private String name;
	private String pos;
	private int num;

	public yankees(String na, String p, int nu)
	{
		name = na;
		pos = p;
		num = nu;
	}

	public String getname()
	{
		return name;
	}
	public String getpos()
	{
		return pos;
	}
	public int getnum()
	{
		return num;
	}
}