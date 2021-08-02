package shopifyadvanced.dao;

import shopifyadvanced.dao.model.Customer;

import java.util.List;

public interface ConfigureService {

    public List<Customer> findAll();
    public Customer findCustomerById(Integer id);
    public void deleteCustomer(Integer id);
    public Customer save(Customer customer);
    public List<Customer> findCustomersByUsernameOrCityOrCountry(String username, String city, String country);
    public Customer findCustomerByUsernameAndPassword(String username, String password);
}
