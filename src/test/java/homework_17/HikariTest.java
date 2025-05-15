package homework_17;

import com.zaxxer.hikari.HikariDataSource;
import homework_17.utils.hikari.SecondDatabase;
import homework_17.utils.hikari.FirstDatabase;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HikariTest {
    @Test
    void firstHikariTest() throws SQLException {
        HikariDataSource firstSource = FirstDatabase.getDataSource();
        Connection connection = firstSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery("SELECT MAX(rating) FROM customer");
        int maxRating = queryResult.getInt(1);

        assertEquals(300, maxRating);
    }

    @Test
    void secondHikariTest() throws SQLException {
        HikariDataSource secondSource = SecondDatabase.getDataSource();
        Connection connection = secondSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet queryResult = statement.executeQuery("SELECT MAX(birth_date) FROM authors");
        String birthDate = queryResult.getString(1);

        assertEquals("1965-07-31", birthDate);
    }
}