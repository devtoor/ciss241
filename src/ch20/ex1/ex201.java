package ch20.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.System.*;

/**
 * Project: ch20.ex1
 * Date:    3/25/2018
 *
 * @author Jay Morales
 */

public class ex201
{
    // Using Access with UCanAccess
    private String url = "jdbc:ucanaccess://C:/Users/devtoor/Documents/" +
            "IdeaProjects/ciss241/src/database/baseball.accdb";

    private ex201 init()
    {
        try (Connection con = DriverManager.getConnection(url, "", "");
            Statement stmt = con.createStatement())
        {
            stmt.execute("CREATE TABLE yankees " +
                    "(Name varchar(25) NOT NULL, " +
                    "Position varchar(25) NOT NULL, " +
                    "Number int NOT NULL, " +
                    "PRIMARY KEY (Number))");

            stmt.executeUpdate("INSERT INTO yankees VALUES ('Bernie Williams', 'CF', 51)");
            stmt.executeUpdate("INSERT INTO yankees VALUES ('Derek Jeter', 'SS', 2)");
            stmt.executeUpdate("INSERT INTO yankees VALUES ('Mariano Rivera', 'P', 42)");
            stmt.executeUpdate("INSERT INTO yankees VALUES ('Jason Giambi', '1B', 25)");
            stmt.executeUpdate("INSERT INTO yankees VALUES ('Mike Mussina', 'P', 35)");
            stmt.executeUpdate("INSERT INTO yankees VALUES ('Alfonso Soriano', '2B', 12)");
        }
        catch (SQLException e)
        {
            err.println(e.getMessage());
            e.getStackTrace();
            exit(1);
        }
        return this;
    }

    private void update()
    {
        try (Connection con = DriverManager.getConnection(url, "", "");
             Statement stmt = con.createStatement())
        {
            stmt.executeUpdate("UPDATE yankees " +
                "SET Position = 'DH' WHERE Name = 'Jason Giambi'");
        }
        catch (SQLException e)
        {
            err.println(e.getMessage());
            e.getStackTrace();
            exit(1);
        }
    }

    public static void main(String[] args)
    {
        new ex201()
                .init()
                .update();
    }
}
