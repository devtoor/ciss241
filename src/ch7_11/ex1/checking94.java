package ch7_11.ex1;

/* Bill Wohlleber
Exercise 9-4 sub class
This class will define a checking account
*/
public class checking94 extends account94
{
    public checking94(int n)
    {
        super(n);
    }

    public String getaccountinfo()
    {
        return "Checking Account Information\n" + acctnum + " " + bal;
    }
}