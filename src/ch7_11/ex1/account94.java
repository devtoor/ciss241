package ch7_11.ex1;

/* Bill Wohlleber
Exercise 9-4 super class
This class will define a bank account
*/
public abstract class account94
{
    protected int acctnum;
    protected double bal;

    public account94(int an)	// constructor
    {
        acctnum = an;
        bal = 0;
    }

    public void trans(double a)
    {
        bal += a;
    }

    public abstract String getaccountinfo();
}