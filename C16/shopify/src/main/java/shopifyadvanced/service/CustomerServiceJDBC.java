package shopifyadvanced.service;

import shopifyadvanced.dao.ConfigureService;
import shopifyadvanced.dao.CustomerDAO;
import shopifyadvanced.dao.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerServiceJDBC implements ConfigureService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return customerDAO.getAllCustomers();
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
         customerDAO.deleteCustomerById(findCustomerById(id));
    }

    @Override
    public Customer save(Customer customer) {
        customerDAO.insertCustomers(customer);
        return null;
    }

    @Override
    public List<Customer> findCustomersByUsernameOrCityOrCountry(String username, String city, String country) {
        return null;
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return customerDAO.getCustomerByUsernameAndPassword(username,password);
    }
}
