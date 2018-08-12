package ch20;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import static database.SimpleDataSource.getConnection;
import static java.lang.System.*;

/**
 * Project: ch20.ex2
 * Date:    3/25/2018
 *
 * @author Jay Morales
 */

public class ex202
{
    private ex202 ex202a()
    {
        try (Connection con = getConnection("baseballdb.properties");
             Statement stmt = con.createStatement())
        {
            ResultSet result = stmt.executeQuery("SELECT * FROM Yankees " +
                    "WHERE Number < 20 " +
                    "ORDER BY Position ASC");

            out.println("202a");
            while (result.next())
            {
                out.print(result.getString("Name") + " ");
                out.print(result.getString("Number") + " ");
                out.println(result.getString("Position"));
            }
        }
        catch (SQLException | IOException e)
        {
            err.println(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
        return this;
    }

    private void ex202b()
    {
        Scanner input = new Scanner(System.in);
        out.println("\n202b");
        out.print("Enter position you want see listed: ");

        try (Connection con = getConnection("baseballdb.properties"))
        {
            PreparedStatement stmt = con.prepareStatement("SELECT Name, Number FROM Yankees " +
                    "WHERE Position = ?");
            stmt.setString(1, input.nextLine().toUpperCase());
            ResultSet result = stmt.executeQuery();

            while (result.next())
            {
                out.println(result.getString("Name") + " " + result.getString("Number"));
            }
        }
        catch (SQLException | IOException e)
        {
            err.println(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex202()
                .ex202a()
                .ex202b();
    }
}
