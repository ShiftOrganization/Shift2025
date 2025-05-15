package homework_17.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String URL = "jdbc:sqlite:SQLite_Lesson2.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}