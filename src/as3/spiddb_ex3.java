package as3;

import java.io.IOException;
import java.sql.*;
import static database.SimpleDataSource.*;
import static java.lang.System.*;

/**
 * Project: Spiderman Database Exercise 3
 * Date:    3/25/2018
 *
 * Purpose:
 * This program demonstrate two queries to the spiderman table in the comics
 * database file and display result using <code>ResultSet</code>. The first
 * query for all comics whose value is $5.00 or more and the result is sorted
 * in descending order. Second query is to display entries with Amazing SM
 * comic name with issue number before 200.
 *
 * @author Jay Morales
 */

public class spiddb_ex3
{
    private final static String COMICSDB_PROPERTIES = "comicsdb.properties";

    /**
     * This method query and display comics whose issue valus is $5.00 or over.
     * Entries are sorted from highest to lowest.
     * @param stmt Object used for executing a static SQL statement.
     * @return This object.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private spiddb_ex3 queryEntries1(Statement stmt) throws SQLException
    {
        ResultSet result = stmt.executeQuery(
                "SELECT ComicName, IssueDate, IssueNumber, IssueValue " +
                "FROM Spiderman " +
                "WHERE IssueValue >= 5.00 " +
                "ORDER BY IssueValue DESC"
        );

        out.println("Query for comics whose value is $5.00 or over, " +
                "\nsorted from highest to lowest.");
        // Table headings
        out.println(String.format("%62s", " ").replace(' ', '-'));
        out.println("| " + center("Comic Name", 16) + " | Issue Date | Issue Number | Issue Value |");
        out.println(String.format("%62s", " ").replace(' ', '-'));
        while (result.next())
        {
            String comicName = result.getString("ComicName");
            String issueDate = result.getString("IssueDate");
            int issueNumber = result.getInt("IssueNumber");
            String issueValue = String.format("$%.2f", result.getDouble("IssueValue"));

            out.printf("| %-16s | %10s | %12s | %11s |\n", comicName, issueDate,
                    issueNumber, issueValue);
        }
        out.println(String.format("%62s\n", " ").replace(' ', '-'));
        return this;
    }

    /**
     * This method query and display all Amazing SM with issue number before 200.
     * @param stmt Object used for executing a static SQL statement.
     * @throws SQLException An exception that provides information on a
     *          database access error or other errors.
     */
    private void queryEntries2(Statement stmt) throws SQLException
    {
        ResultSet result = stmt.executeQuery(
                "SELECT IssueName, ComicName, IssueNumber, IssueDate " +
                "FROM Spiderman " +
                "WHERE ComicName = 'Amazing SM' AND IssueNumber < 200"
        );

        out.println("Query for all Amazing SM with issue name before 200.");
        // Table headings
        out.println(String.format("%91s", " ").replace(' ', '-'));
        out.println("| " + center("Issue Name", 40) + " | " + center("Comic Name", 16)+
                " | Issue Number | Issue Date |");
        out.println(String.format("%91s", " ").replace(' ', '-'));
        while (result.next())
        {
            String issueName = result.getString("IssueName");
            String comicName = result.getString("ComicName");
            int issueNumber = result.getInt("IssueNumber");
            String issueDate = result.getString("IssueDate");

            out.printf("| %-40s | %-16s | %12s | %10s |\n", issueName, comicName,
                    issueNumber, issueDate);
        }
        out.println(String.format("%91s\n", " ").replace(' ', '-'));
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
            new spiddb_ex3()
                    .queryEntries1(stmt)
                    .queryEntries2(stmt);
        }
        catch (SQLException | IOException e)
        {
            err.print(e.getMessage());
            e.printStackTrace();
            exit(1);
        }
    }
}