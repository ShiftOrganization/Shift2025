package homework_15.jdbc;

import java.sql.*;

public class JDBCtest1 {
    public static void main(String[] args) {
        String countQuery = "SELECT COUNT(*) FROM authors";
        try (
                Connection connection = JDBCConnection.connect();
                Statement statement = connection.createStatement();
                ResultSet countResult = statement.executeQuery(countQuery)
        ) {
            if (countResult.next()) {
                int count = countResult.getInt(1);
                if (count != 7) {
                    throw new RuntimeException("Ошибка: Ожидалось 7 строк, получено " + count);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при работе с БД: " + e.getMessage(), e);
        }
    }
}