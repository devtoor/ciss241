package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 A simple data source for getting database connections.
 */
public class SimpleDataSource
{
    private static String url;
    private static String username;
    private static String password;

    /**
     Initializes the data source.
     @param fileName the name of the property file that
     contains the database driver, URL, username, and password
     */
    public static void init(String fileName)
            throws IOException, ClassNotFoundException
    {
        Properties props = new Properties();
        FileInputStream in = new FileInputStream(fileName);
        props.load(in);

        String driver = props.getProperty("jdbc.driver");
        url = props.getProperty("jdbc.url");
        username = props.getProperty("jdbc.username");
        if (username == null) { username = ""; }
        password = props.getProperty("jdbc.password");
        if (password == null) { password = ""; }
        if (driver != null) { Class.forName(driver); }
    }

    /**
     Gets a connection to the database.
     @return the database connection
     */
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Gets a connection to the database
     * @param fileName the name of the property file that
     *                 contains the database driver, URL,
     *                 username, and password
     * @return the database connection
     * @throws IOException f the file does not exist, is a directory rather
     *                  than a regular file, or for some other reason cannot
     *                  be opened for reading.
     * @throws SQLException if a database access error occurs or the url is null
     */
    public static Connection getConnection(String fileName) throws IOException, SQLException
    {
        String url = "C:/Users/devtoor/Documents/IdeaProjects/ciss241/src/database/" + fileName;
        Properties prop = new Properties();
        prop.load(new FileInputStream(url));

        url = prop.getProperty("jdbc.url");
        username = prop.getProperty("jdbc.username");
        if (username == null) { username = ""; }
        password = prop.getProperty("jdbc.password");
        if (password == null) { password = ""; }
        return DriverManager.getConnection(url, username, password);
    }
}