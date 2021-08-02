package shopifyadvanced.controller;

import shopifyadvanced.dao.ConfigureService;
import shopifyadvanced.dao.UserSession;
import shopifyadvanced.dao.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {


    @Autowired
    ConfigureService customerService;


//    @GetMapping("/customers")
//    @ResponseBody
//    public List<Customer> getAllCustomer() {
//        return customerService.getAllCustomers();
//    }

//    @GetMapping("/customers-html")
//    public ModelAndView getAllCustomersHtml() {
//        ModelAndView view = new ModelAndView("customers.html");
//
//        List<Customer> customers = customerService.getAllCustomers();
//        view.addObject("customerList", customers);
//
//        return view;
//    }
//
//    @GetMapping("/customer/{id}")
//    @ResponseBody
//    public ModelAndView getCustomersById(@PathVariable(name = "id") Integer id) {
//        ModelAndView view = new ModelAndView("customer.html");
//
//        Customer c=new Customer();
//        c.setId(id);
//
//        return view.addObject("customer", customerService.getCustomerById(c));
//
//    }
//
//    @GetMapping("/customerfilter")
//    @ResponseBody
//    public ModelAndView getCustomersFilter(@RequestParam("username") String username, @RequestParam("city") String city, @RequestParam("country") String country) {
//
//        String sqlQuery = "";
//
//        if (!username.equals("")) {
//            sqlQuery += " username=" + "'" + username + "'";
//        }
//        if (!city.equals("")) {
//            if (!sqlQuery.equals("")) {
//                sqlQuery += " AND ";
//            }
//            sqlQuery += "city=" + "'" + city + "'";
//
//        }
//        if (!country.equals("")) {
//            if (!sqlQuery.equals("")) {
//                sqlQuery += " AND ";
//            }
//            sqlQuery += "country=" + "'" + country + "'";
//        }
//        System.out.println(sqlQuery);
//
//        ModelAndView view = new ModelAndView("customerfilter.html");
//        return view.addObject("customerList", customerService.getFilterCustomers(sqlQuery));
//    }
//
//    @GetMapping("/customers/{id}")
//    @ResponseBody
//    public Customer getCustomerById(@PathVariable(name = "id") Integer cid) {
//
//        Customer customer=new Customer();
//        customer.setId(cid);
//
//        return customerService.getCustomerById(customer);
//    }
//
//    @PutMapping("/customers")
//    @ResponseBody
//    public Boolean insertCustomers(@RequestBody Customer customer) {
//        return customerService.insertCustomers(customer);
//    }
//
//    @PutMapping("/customers/{id}")
//    @ResponseBody
//    public Boolean updateCustomerById(@PathVariable(name = "id") Integer cid, @RequestBody Customer customer) {
//
//        customer.setId(cid);
//
//        return customerService.updateCustomer(customer);
//    }
//
//    @DeleteMapping("/customers/{id}")
//    @ResponseBody
//    public Boolean deleteCustomerById(@PathVariable(name = "id") Integer id) {
//        Customer customer=new Customer();
//        customer.setId(id);
//        customer=customerService.getCustomerById(customer);
//        return customerService.deleteCustomer(customer);
//    }


//TODO PARTEA DE CRUDREPOSITORY

    @GetMapping("/customer/{id}")
    @ResponseBody
    public ModelAndView getCustomersById(@PathVariable(name = "id") Integer id) {
        ModelAndView view = new ModelAndView("customer.html");
        return view.addObject("customer", customerService.findCustomerById(id));

    }

    @GetMapping("/customers-html")
    public ModelAndView getAllCustomersHtml() {
        ModelAndView view = new ModelAndView("customers.html");

        List<Customer> customers = customerService.findAll();
        view.addObject("customerList", customers);

        return view;
    }

    @GetMapping("/customerfilter")
    @ResponseBody
    public ModelAndView getCustomersFilter(@RequestParam("username") String username, @RequestParam("city") String city, @RequestParam("country") String country) {

        ModelAndView view = new ModelAndView("customerfilter.html");
        return view.addObject("customerList", customerService.findCustomersByUsernameOrCityOrCountry(username, city, country));
    }

    @PutMapping("/customers")
    @ResponseBody
    public Customer insertCustomers(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @PutMapping("/customers/{id}")
    @ResponseBody
    public Boolean updateCustomerById(@PathVariable(name = "id") Integer cid, @RequestBody Customer customer) {

        Customer customer1 = customerService.findCustomerById(cid);
        if (customer1 != null) {
            customer1 = customer;
            customerService.save(customer1);
        } else {
            insertCustomers(customer);
        }

        return true;
    }

    @DeleteMapping("/customers/{id}")
    @ResponseBody
    public void deleteCustomerById(@PathVariable(name = "id") Integer id) {
        customerService.deleteCustomer(id);
    }


    @PostMapping("/dashboard")
    @Primary
    public ModelAndView getLogin(@RequestParam("username") String username, @RequestParam("password") String password) {

        Customer customer = customerService.findCustomerByUsernameAndPassword(username, password);

        if (customer == null) {
            return new ModelAndView("redirect:/customers-html");
        } else {

            UserSession.userSession_id = customer.getId();
            ModelAndView view = new ModelAndView("login.html");
            return view;
        }
    }
}
