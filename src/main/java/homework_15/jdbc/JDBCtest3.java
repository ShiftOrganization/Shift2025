package homework_15.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest3 {
    public static void main(String[] args) {
        String countQuery = "SELECT MIN(birth_date) FROM authors";
        try (
                Connection connection = JDBCConnection.connect();
                Statement statement = connection.createStatement();
                ResultSet queryResult = statement.executeQuery(countQuery)
        ) {
            if (queryResult.next()) {
                String birthDate = queryResult.getString(1);
                if (!birthDate.equals("1821-11-11")) {
                    throw new RuntimeException("Ошибка: Ожидалась дата 1821-11-11, получено " + birthDate);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Ошибка при работе с БД: " + e.getMessage(), e);
        }
    }
}