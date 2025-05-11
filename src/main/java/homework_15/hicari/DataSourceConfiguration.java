package homework_15.hicari;

import lombok.Data;

@Data
public class DataSourceConfiguration {
    private String url;
    private int connectionTimeout;
}