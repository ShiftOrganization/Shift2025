package homework_15.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest2 {
    public static void main(String[] args) {
        String countQuery = "SELECT MAX(price) FROM books";
        try (
                Connection connection = JDBCConnection.connect();
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(countQuery)
        ) {
            if (queryResult.next()) {
                int booksPrice = queryResult.getInt(1);
                if (booksPrice != 1200) {
                    throw new RuntimeException("Ошибка: Ожидалась цена 1200, получено " + booksPrice);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при работе с БД: " + e.getMessage(), e);
        }
    }
}