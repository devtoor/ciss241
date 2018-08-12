package as3;

import java.io.IOException;
import java.sql.*;
import static database.SimpleDataSource.*;
import static java.lang.System.*;

/**
 * Project: Spiderman Database Exercise 2
 * Date:    3/25/2018
 *
 * Purpose:
 *      This program will update the spiderman table in the comics database file and
 *      make the indicated corrections. First it will add four more entries into the
 *      table, then use the UPDATE clause to update some entries. It also demonstrate
 *      DELETE clause to delete an entry. The program will print every time an update
 *      to the table to show changes.
 *
 * @author Jay Morales
 */

public class spiddb_ex2
{
    private final static String COMICSDB_PROPERTIES = "comicsdb.properties";

    /**
     * This method add some new comics to the table.
     * @param stmt Object used for executing a static SQL statement.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex2 addNewEntries(Statement stmt) throws SQLException
    {
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Amazing SM', 400, '4/1/95', 'A Death In The Family', 5.00, 'Yes')"
        );
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Spectacular SM', 37, '12/1/79', 'Into The Hive', 6.00, 'No')"
        );
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Amazing SM', 194, '7/1/79', 'Never Let The Black Cat Cross Your Path', 10.00, 'No')"
        );
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Web Of SM', 125, '6/1/95', 'Searching', 4.00, 'Yes')"
        );
        return this;
    }

    /**
     * This method update some of the entries in the table.
     * @param stmt Object used for executing a static SQL statement.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex2 updateEntries(Statement stmt) throws SQLException
    {
        stmt.executeUpdate(
                "UPDATE Spiderman " +
                "SET IssueValue = 7.00 " +
                "WHERE ComicName = 'Amazing SM' AND IssueNumber = 89"
        );

        stmt.executeUpdate(
                "UPDATE Spiderman " +
                "SET IssueValue = 5.00, IssueName = 'What Is The Answer?' " +
                "WHERE ComicName = 'Spectacular SM' AND IssueNumber = 92"
        );
        return this;
    }

    /**
     * This method delete an entry in the table.
     * @param stmt Object used for executing a static SQL statement.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex2 deleteEntry(Statement stmt) throws SQLException
    {
        stmt.executeUpdate(
                "DELETE FROM Spiderman " +
                "WHERE ComicName = 'Amazing SM' and IssueNumber = 382"
        );
        return this;
    }

    /**
     * This method add a single entry into the table.
     * @param stmt Object used for executing a static SQL statement.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex2 addEntry(Statement stmt) throws SQLException
    {
        stmt.executeUpdate(
                "INSERT INTO Spiderman VALUES " +
                "('Amazing SM', 0, '3/25/18', 'Jay Morales', 5.00, 'Yes')"
        );
        return this;
    }

    /**
     * This method print the spiderman table to the console window.
     * @param con A connection (session) with a specific database.
     *            SQL statements are executed and results are returned
     *            within the context of a connection.
     * @param str String to label the table.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex2 displayTable(Connection con, String str) throws SQLException
    {
        out.println(str);
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
        return this;
    }

    /**
     * This method return a string centered align according to the width size
     * @param s String need to be centered.
     * @param size The width size
     * @return Center aligned string, padded with ' ' both ends.
     */
    private static String center(String s, int size)
    {
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
            new spiddb_ex2()
                    .addNewEntries(stmt)
                    .displayTable(con, "Added some new comics in the collection")
                    .updateEntries(stmt)
                    .displayTable(con, "Update some comics' issue value and issue name")
                    .deleteEntry(stmt)
                    .displayTable(con, "Delete Amazing SM with issue number 382")
                    .addEntry(stmt)
                    .displayTable(con, "Added a record at the bottom of the table");
        }
        catch (SQLException | IOException e)
        {
            err.print(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
    }
}