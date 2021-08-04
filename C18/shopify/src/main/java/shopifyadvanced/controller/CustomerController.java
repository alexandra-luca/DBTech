package shopifyadvanced.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import shopifyadvanced.dao.ConfigureService;
import shopifyadvanced.dao.UserSession;
import shopifyadvanced.dao.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Api(value="customers")
@Controller
public class CustomerController {


    @Autowired
    ConfigureService customerService;

//TODO PARTEA DE CRUDREPOSITORY

    @ApiOperation(value="Find customers by id",notes = "Provides details about a customer",response = ModelAndView.class)
    @GetMapping("/customer/{id}")
    @ResponseBody
    public ModelAndView getCustomersById(@ApiParam(value = "id that needs to be provided",required = true) @PathVariable(name = "id") Integer id) {
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
