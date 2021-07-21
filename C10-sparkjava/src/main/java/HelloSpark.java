import com.google.gson.Gson;
import spark.Spark;

public class HelloSpark {

    public static void main(String[] args) {

        CustomersService.initCustomers();

//        Spark.get("/customer", (req, res) -> "Hello Customer");

        Spark.get("/customer", (req, res) -> { // Not RESTful
            System.out.println("(Query param) Here's customer with id: " + req.queryParams("id"));
            return "";
        });

        Spark.get("/customers", (req, res) -> {
            String customersToString = CustomersService.customersToString();
            return customersToString;
        });

        Spark.get("/customer/:id", (req, res) -> {
            System.out.println("(Endpoint param) Here's customer with id = " + req.params("id"));
            return CustomersService.customers[Integer.parseInt(req.params("id"))];
        });

        Spark.delete("/customer/:id", (req, res) -> {
            System.out.println("Got into delete customer endpoint");
            int idCustomer = Integer.parseInt(req.params("id"));
            System.out.println("Trying to delete user with id " + idCustomer);
            CustomersService.deleteCustomer(idCustomer);
            return "";
        });

        Spark.put("/customer/:id", (req, res) -> {
            System.out.println("Got into put customer endpoint");
            int idCustomer = Integer.parseInt(req.params("id"));
            System.out.println("Trying to update user with id " + idCustomer);
            String body = req.body();
            System.out.println("body = " + body);
            Gson gson = new Gson();
            Object myCustomer = gson.fromJson(body, Customer.class);
            System.out.println("myCustomer = " + myCustomer);
            CustomersService.customers[Integer.parseInt(req.params("id"))].setFirstName(((Customer)myCustomer).getFirstName());
            CustomersService.customers[Integer.parseInt(req.params("id"))].setLastName(((Customer)myCustomer).getLastName());
            return CustomersService.customers[Integer.parseInt(req.params("id"))];
        });


    }

}
