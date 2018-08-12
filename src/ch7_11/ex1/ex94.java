package ch7_11.ex1;

/* Bill Wohlleber
Exercise 9-4 main class
This program will create account references
*/
public class ex94
{
    public static void main(String[] args)
    {
        account94[] a = new account94[2];
        int i;

        a[0] = new checking94(100);
        a[1] = new savings94(200, 1.5);

        a[0].trans(250.75);
        a[1].trans(325.65);

        for (i = 0; i < a.length; i++)
        {
            System.out.println("\na[" + i + "]");
            System.out.println(a[i]);
            System.out.println(a[i].getaccountinfo());
            // dynamic method binding
        }
    }
}