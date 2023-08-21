package by.itclass.model.data_base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String DB_FILE_PROPS = "data_base.properties";
    private static Connection connection;
    private static Properties properties;

    public static void init() {
        loadProperties();
        loadDriver();
    }

    private static void loadProperties() {
        properties = PropertiesManager.getProperties(DB_FILE_PROPS);//возвращает объект типа properties
    }

    private static void loadDriver() {
        try {
            Class.forName(properties.getProperty("driver"));//передаем ключ в проперти, по которому достанем строчку
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return connection == null || connection.isClosed()
                ? DriverManager.getConnection(properties.getProperty(URL), properties) : connection;
    }
}
