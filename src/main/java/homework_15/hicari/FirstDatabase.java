package homework_15.hicari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class FirstDatabase {

    private static final HikariDataSource dataSource;

    static {
        DataSourceConfiguration config = Configuration.get().getDataSource("SQLite_Lesson1");

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(config.getUrl());
        hikariConfig.setConnectionTimeout(config.getConnectionTimeout());
        dataSource = new HikariDataSource(hikariConfig);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}