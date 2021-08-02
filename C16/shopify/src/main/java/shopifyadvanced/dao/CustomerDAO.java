package shopifyadvanced.dao;


import shopifyadvanced.dao.model.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Integer id);

    public Boolean insertCustomers(Customer customer);

  //  public Boolean updateCustomerById(Integer id, Customer customer);

    public Boolean updateCustomer(Customer c);

    public Boolean deleteCustomerById(Customer c);

    public List<Customer> getFilterCustomers(String sqlQuery);

    public Customer getCustomerByUsernameAndPassword(String username,String password);
}
