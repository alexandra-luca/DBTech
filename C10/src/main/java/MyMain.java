//import org.apache.commons.codec.digest.Crypt;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import spark.Spark;


public class MyMain {


    public static void main(String[] args) {

       /* try {
            Customer customer = Customer.getById(2);
            System.out.println(customer);

//            int noUpdated = Customer.update("first_name", "Ionel2", 1);
            int noUpdated = Customer.update(new Customer("Costica92", "Costica", "Popescu"), 1);
            System.out.println("no updated = " + noUpdated);
        } catch (SQLException exception) {
            System.err.println("Customer exception: " + exception.getMessage());
            exception.printStackTrace();
        }


        Product p1=new Product("123","Pantaloni","Pantaloni stofa",10,100.11f);
        try
        {
            p1.insert();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }








        Customer c=new Customer();
        List<Customer> customerList=null;

        try {
            customerList=c.getAll();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        for (Customer x : customerList) {
            System.out.println(x);
        }


        Customer c1=new Customer();
        Product p=new Product();
        try {
            c=c.getById(2);
            p=p.getById(3);

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Product p3 = new Product();
        Customer c2 = new Customer();
        try {
            c.delete(2);

           // p.delete(123);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }




        Customer p2=new Customer(7,"AlexUpdatee","Alex","Stefan");
        try {
            p2.update();
        } catch (SQLException | IllegalAccessException | NoSuchFieldException exception) {
            exception.printStackTrace();
        }
        Spark.get("/customers", (req,res)->{
            Customer c=new Customer();
            List<Customer> customerList=null;
            customerList=c.getAll();

            return customerList;
        });
*/
        Spark.get("/customer/:id",(req,res)->
        {
            Customer c1=new Customer();
            System.out.println("Params: "+req.params("id"));

            int id=Integer.parseInt (req.params("id"));

            return c1.getById(id);
        });

        Spark.delete("/customer/:id",(req,res)->
        {
            Customer c2 = new Customer();
            int id=Integer.parseInt(req.params("id"));
            if(c2.getById(id)==null)
            {
                res.status(404);
                return "";
            }
            return c2.delete(id);
        });


    }


}
