package as3;

import java.io.IOException;
import java.sql.*;
import static database.SimpleDataSource.*;
import static java.lang.System.*;

/**
 * Project: Spiderman Database Exercise 1
 * Date:    3/25/2018
 *
 * Purpose:
 *      This program create a comics database using apache derby and create a
 *      spiderman table. Also it inset record into the table, base on the
 *      requirements of the assignment, then print the Spiderman table to the
 *      console using <code>ResultSet</code>.
 *
 * @author Jay Morales
 */


public class spiddb_ex1
{
    private final static String COMICSDB_PROPERTIES = "comicsdb.properties";

    /**
     * Create a spiderman table.
     * @param stmt Object used for executing a static SQL statement.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex1 createTable(Statement stmt) throws SQLException
    {
        stmt.execute(
                "CREATE TABLE Spiderman (" +
                "ComicName VARCHAR(255) NOT NULL," +
                "IssueNumber INT NOT NULL," +
                "IssueDate VARCHAR(8) NOT NULL," +
                "IssueName VARCHAR(255) NOT NULL," +
                "IssueValue DECIMAL(6, 2) NOT NULL," +
                "MintCondition VARCHAR(3) NOT NULL" +
                ")"
        );
        return this;
    }

    /**
     * Insert initial records to the table.
     * @param stmt Object used for executing a static SQL statement.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private void insertInitData(Statement stmt) throws SQLException
    {
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Amazing SM', 89, '10/1/70', 'Doc Ock Lives', 6.50, 'No')"
        );
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Spectacular SM', 92, '7/1/84', 'What Is The Answer', 4.50, 'No')"
        );
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Web Of SM', 35, '2/1/88', 'You Can Go Home Again', 4.00, 'No')"
        );
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Amazing SM', 382, '10/1/93', 'Emerald Rage', 4.00, 'Yes')"
        );
    }

    /**
     * This method print the spiderman table to the console window.
     * @param con A connection (session) with a specific database.
     *            SQL statements are executed and results are returned
     *            within the context of a connection.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private static void displayTable(Connection con) throws SQLException
    {
        ResultSet result = con
                .createStatement()
                .executeQuery(
                        "SELECT * FROM Spiderman"
                );

        // Table headings
        out.println(String.format("%123s", " ").replace(' ', '-'));
        out.println("| " + center("Comic Name", 16) + " | Issue Number | Issue Date | " +
                center("Issue Name", 40) + " | Issue Value | Mint Condition? |");

        out.println(String.format("%123s", " ").replace(' ', '-'));
        while (result.next())
        {
            String comicName = result.getString("ComicName");
            int issueNumber = result.getInt("IssueNumber");
            String issueDate = result.getString("IssueDate");
            String issueName = result.getString("IssueName");
            String issueValue = String.format("$%.2f", result.getDouble("IssueValue"));
            String mintCondition = result.getString("MintCondition");

            out.printf("| %-16s | %12s | %10s | %-40s | %11s | %15s |\n", comicName, issueNumber,
                    issueDate, issueName, issueValue, mintCondition);
        }
        out.println(String.format("%123s\n", " ").replace(' ', '-'));
    }

    /**
     * This method return a string centered align according to the width size
     * @param s String need to be centered.
     * @param size The width size
     * @return Center aligned string, padded with ' ' both ends.
     */
    private static String center(String s, int size)
    {
        // If null or size is less than or equalt the string length
        // return the string.
        if (s == null || size <= s.length())
            return s;

        char pad = ' ';
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++)
        {
            sb.append(pad);
        }

        sb.append(s);
        while (sb.length() < size)
        {
            sb.append(pad);
        }
        return sb.toString();
    }

    /**
     * The class main method is the entry point of an executable program,
     * it is where the program control starts and ends.
     * @param args Command-line arguments.
     */
    public static void main(String[] args)
    {
        try (Connection con = getConnection(COMICSDB_PROPERTIES);
             Statement stmt = con.createStatement())
        {
            new spiddb_ex1()
                    .createTable(stmt)
                    .insertInitData(stmt);

            displayTable(con);
        }
        catch (SQLException | IOException e)
        {
            err.print(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
    }
}