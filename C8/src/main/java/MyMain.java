import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.knowceans.util.Crypt;

import java.sql.*;
import java.util.Properties;

public class MyMain {

    private static void mavenImports() {
        Pair<String, Integer> pair = new ImmutablePair<>("gigel", 14);
        String myStr = pair.getLeft();
        Integer myInt = pair.getRight();
        System.out.println("myStr = " + myStr + (", getRight = " + myInt));

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        int myRandInt = randomDataGenerator.nextInt(5, 10);
        System.out.println("myRandInt = " + myRandInt);

//        String crypt = Crypt.encrypt("ana are mere");
//        System.out.println("Encrypted = " + crypt);
    }

    private static void databaseTest() {
        String databaseURL = "jdbc:mysql://localhost:3306/db_tech_school";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "D@t@tables");
        try {
            Connection connection = DriverManager.getConnection(databaseURL, properties);
            System.out.println("Successfully connected");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE id > ?");
//            preparedStatement.setString(1, "customers"); HOW to set dynamic table
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println("Name = " + firstName + ' ' + lastName + " (" + id + ')');
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        MyMain.mavenImports();
//        MyMain.databaseTest();
        try {
            Customer customer = Customer.getById(2);
            System.out.println(customer);

            int noUpdated = Customer.update("first_name", "Ionel2", 1);
            System.out.println("no updated = " + noUpdated);
        } catch (SQLException exception) {
            System.err.println("Customer exception: " + exception.getMessage());
            exception.printStackTrace();
        }


    }

}
