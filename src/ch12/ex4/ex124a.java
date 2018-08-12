package ch12.ex4;
/* Add a try block and at least 6 catch blocks with a specific error
message for each type of exception to the following program.
1. User doesn't input an int for howmany numbers
2. User doesn't input an int for number in dialog box
3. You can't print with printf (also fix in code so you can run the rest)
4. User trys to input too many ints into the array
5. User inputs a zero for number in dialog box (because of division, check for a zero yourself, then create and throw an arithmetic exception)
6. For anything else, add a super Exception catch
*/
import javax.swing.JOptionPane;
import java.util.*;
public class ex124a
{
	public static void main(String[] args)
	{
		String line;
		int input, i, howmany;
		int nums[] = new int[3];
		Scanner sc = new Scanner(System.in);
		System.out.print("How many numbers?  ");
		howmany = sc.nextInt();
		for (i = 0; i < howmany; i++)
		{
			line = JOptionPane.showInputDialog(null,
				"Enter an integer",	"Input",
					JOptionPane.QUESTION_MESSAGE);
			input = Integer.parseInt(line);
			nums[i] = input;
			System.out.printf("Next number is %f\n", nums[i]);
			System.out.println("Division by the number is " +
				(double)howmany/nums[i]);
		}
	}
}