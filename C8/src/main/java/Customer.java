import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {

    private int id;
    private String username;
    private String first_name;
    private String last_name;

    public Customer() { }

    public static Customer getById(int id) throws SQLException {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            Customer customer = new Customer();
            customer.id = resultSet.getInt("id");
            customer.username = resultSet.getString("username");
            customer.first_name = resultSet.getString("first_name");
            customer.last_name = resultSet.getString("last_name");
            return customer;
        }
        return null;
    }

    public static int update(String column, String value, int id) throws SQLException {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        StringBuilder stringBuilder = new StringBuilder("UPDATE customers SET "); // '; DELETE FROM customer;'
        stringBuilder.append(column + "= ");
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString() + " ? WHERE id = ?");
        preparedStatement.setString(1, value);
        preparedStatement.setInt(2, id);
        System.out.println(preparedStatement);
        return preparedStatement.executeUpdate();

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
