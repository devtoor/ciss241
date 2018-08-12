package ch13.ex6;

import java.io.Serializable;

/**
 * Project: ch13.ex6
 * Date:    2/26/2018
 *
 * @author Jay Morales
 */

public class Pizza implements Serializable
{
    private static final long serialVersionUID = 1223967978034932905L;
    private final char size;
    private final double price;

    public Pizza(char size, double price)
    {
        this.size = size;
        this.price = price;
    }

    public char getSize()
    {
        return size;
    }

    public double getPrice()
    {
        return price;
    }
}