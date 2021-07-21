import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ActiveRecordEntity(tableName = "customers", keyColumnName = "id")
public class Customer extends ActiveRecord {

    public int id;
    public String username;
    public String first_name;
    public String last_name;
    public String phone;
    public String address;
    public String city;
    public String postal_code;
    public String country;


    public Customer() {
    }

    public Customer(String username, String first_name, String last_name) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Customer(int id, String username, String first_name, String last_name) {
        this.id=id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /*
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

    public static int update(Customer customer, int id) throws SQLException {
        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();
        String querySQL = "UPDATE customers SET (username, first_name, last_name) VALUES (?,?,?) WHERE id = ?;";
//        StringBuilder stringBuilder = new StringBuilder("UPDATE customers SET "); // '; DELETE FROM customer;'
//        stringBuilder.append(column + "= ");
//        PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString() + " ? WHERE id = ?");
        PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
        preparedStatement.setString(1, customer.username);
        preparedStatement.setString(2, customer.first_name);
        preparedStatement.setString(3, customer.last_name);
        preparedStatement.setInt(4, id);
        System.out.println(preparedStatement);
        return preparedStatement.executeUpdate();

    }
*/
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
