package homework_17.utils.hikari;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private static final Configuration CONFIGURATION = createDefaultConfiguration();

    private Map<String, DataSourceConfiguration> dataSources = new HashMap<>();

    public Map<String, DataSourceConfiguration> getDataSources() {
        return dataSources;
    }

    public static Configuration get() {
        return CONFIGURATION;
    }

    private static Configuration createDefaultConfiguration() {
        Configuration config = new Configuration();

        DataSourceConfiguration firstDatabase = new DataSourceConfiguration();
        firstDatabase.setUrl("jdbc:sqlite:SQLite_Lesson1.db");
        firstDatabase.setConnectionTimeout(30000);

        DataSourceConfiguration secondDatabase = new DataSourceConfiguration();
        secondDatabase.setUrl("jdbc:sqlite:SQLite_Lesson2.db");
        secondDatabase.setConnectionTimeout(30000);

        config.getDataSources().put("SQLite_Lesson1", firstDatabase);
        config.getDataSources().put("SQLite_Lesson2", secondDatabase);

        return config;
    }

    public DataSourceConfiguration getDataSource(String name) {
        return dataSources.get(name);
    }
}