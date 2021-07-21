public class CustomersService {

    public static Customer[] customers;

    public static void initCustomers() {
        customers = new Customer[100];
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("Firstname " + i, "Lastname " + i);
            customers[i] = customer;
        }
    }

    public static void deleteCustomer(int pos) {
        for (int i = pos; i < customers.length - 1; i++) {
            customers[i] = customers[i+1];
        }
    }

    public static String customersToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(customers[i] + "\n");
        }
        return stringBuilder.toString();
    }
}
