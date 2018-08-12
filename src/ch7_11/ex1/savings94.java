package ch7_11.ex1;

/* Bill Wohlleber
Exercise 9-4 sub class
This class will define a savings account
*/
public class savings94 extends account94
{
    private double intrate;

    public savings94(int n, double r)
    {
        super(n);
        intrate = r;
    }

    public String getaccountinfo()
    {
        return "Savings Account Information\n" + acctnum + " "
                + bal + " " + intrate;
    }
}