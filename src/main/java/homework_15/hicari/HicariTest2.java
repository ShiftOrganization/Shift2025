package homework_15.hicari;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HicariTest2 {
    public static void main(String[] args) {
        HikariDataSource secondSource = SecondDatabase.getDataSource();

        try (Connection connection = secondSource.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet queryResult = statement.executeQuery("SELECT MAX(birth_date) FROM authors")) {
                if (queryResult.next()) {
                    String birthDate = queryResult.getString(1);
                    if (!birthDate.equals("1965-07-31")) {
                        throw new RuntimeException("Ошибка: Ожидалась дата 1965-07-31, получено " + birthDate);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}