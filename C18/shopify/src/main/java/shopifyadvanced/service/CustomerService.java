package shopifyadvanced.service;

import shopifyadvanced.dao.ConfigureService;
import shopifyadvanced.dao.crudRepository.CustomerRepository;
import shopifyadvanced.dao.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@Primary
public class CustomerService implements ConfigureService {



    @Autowired
    CustomerRepository customerRepository;

    // Acelasi lucru sus - jos
//    CustomerDAO customerDAO = new CustomerDAOImpl();


    public Customer findCustomerById(Integer id) {
        return customerRepository.findCustomerById(id);
    }
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return customerRepository.findCustomerByUsernameAndPassword(username, password);
    }
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findCustomersByUsernameOrCityOrCountry(String username, String city, String country) {
        return customerRepository.findCustomersByUsernameOrCityOrCountry(username, city, country);
    }
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }


}
