package ch18;

public class movie18 implements Comparable
{
    private String name;
    private int year;

    public movie18(String n, int y)
    {
        name = n;
        year = y;
    }

    public String getName()
    {
        return name;
    }
    public int getYear()
    {
        return year;
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.year;
    }

    @Override
    public int compareTo(Object o)
    {
        return this.name.compareTo(((movie18)o).getName());
    }
}