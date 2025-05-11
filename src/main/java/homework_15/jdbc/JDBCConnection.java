package homework_15.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static final String URL = "jdbc:sqlite:SQLite_Lesson2.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}