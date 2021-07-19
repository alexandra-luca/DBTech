import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

    private static DatabaseConnection databaseConnection = null;
    private static Connection connection;

    private DatabaseConnection() {
        this.init();
    }

    private void init() {
        String databaseURL = "jdbc:mysql://localhost:3306/db_tech_school";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "D@t@tables");
        try {
            this.connection = DriverManager.getConnection(databaseURL, properties);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public static Connection getConnection() {
        return connection;
    }
}
