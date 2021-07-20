//import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class MyMain {

    private static void mavenImports() {
        Pair<String, Integer> pair = new ImmutablePair<>("gigel", 14);
        String myStr = pair.getLeft();
        Integer myInt = pair.getRight();
        System.out.println("myStr = " + myStr + (", getRight = " + myInt));

        Random randomDataGenerator = new Random();
        int myRandInt = randomDataGenerator.nextInt(5) + 5;
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
////        MyMain.mavenImports();
////        MyMain.databaseTest();
//        try {
//            Customer customer = Customer.getById(2);
//            System.out.println(customer);
//
////            int noUpdated = Customer.update("first_name", "Ionel2", 1);
//            int noUpdated = Customer.update(new Customer("Costica92", "Costica", "Popescu"), 1);
//            System.out.println("no updated = " + noUpdated);
//        } catch (SQLException exception) {
//            System.err.println("Customer exception: " + exception.getMessage());
//            exception.printStackTrace();
//        }

        Customer c = new Customer();
        List<Customer> customerList = null;
        try {
            customerList = c.getAll();
        } catch (SQLException throwables) {
            System.out.println("Ai gresit query-ul, verifica adnotarile");
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Nu exista constructor fara parametri pentru clasa ta");
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            System.out.println("Numele atributelor din clasa nu corespund cu cele din tabela");
            e.printStackTrace();
        }
        for (Customer x : customerList) {
            System.out.println(x);
        }

//        Product p = new Product();
//        List<Product> productList = p.getAll();
//        for (Product x : productList) {
//            System.out.println(x);
//        }

//        Customer c1 = new Customer("irina", "irina", "toma");
//        try {
//            c1.insert();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        Product p1 = new Product("123", "Tigaie", "tigaie tefal", 10, 123.11f);
        try {
            p1.insert();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
