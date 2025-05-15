package homework_17;

import homework_17.utils.jdbc.JdbcConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JdbcTest {
    @Test
    void firstJdbcTest() throws SQLException {
        String query = "SELECT COUNT(*) FROM authors";

        Connection connection = JdbcConnection.connect();
        Statement statement = connection.createStatement();
        ResultSet countResult = statement.executeQuery(query);
        int count = countResult.getInt(1);

        assertEquals(7, count);
    }

    @Test
    void secondJdbcTest() throws SQLException {
        String query = "SELECT MAX(price) FROM books";

        Connection connection = JdbcConnection.connect();
        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(query);
        int booksPrice = queryResult.getInt(1);

        assertEquals(1200, booksPrice);
    }

    @Test
    void thirdJdbcTest() throws SQLException {
        String query = "SELECT MIN(birth_date) FROM authors";

        Connection connection = JdbcConnection.connect();
        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery(query);
        String birthDate = queryResult.getString(1);

        assertEquals("1821-11-11", birthDate);
    }
}