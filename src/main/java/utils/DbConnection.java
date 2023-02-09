package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static Connection con = null;

    static
    {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String password = "mypass";
        String username = "myuser";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}