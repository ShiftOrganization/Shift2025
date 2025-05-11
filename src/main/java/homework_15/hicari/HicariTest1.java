package homework_15.hicari;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HicariTest1 {
    public static void main(String[] args) {
        HikariDataSource firstSource = FirstDatabase.getDataSource();

        try (Connection connection = firstSource.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet queryResult = statement.executeQuery("SELECT MAX(rating) FROM customer")) {
                if (queryResult.next()) {
                    int maxRating = queryResult.getInt(1);
                    if (maxRating != 300) {
                        throw new RuntimeException("Ошибка: Ожидался рейтинг 300, получено " + maxRating);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}