package shopifyadvanced.dao.impl;

import shopifyadvanced.dao.model.Customer;
import shopifyadvanced.dao.CustomerDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {



    @PersistenceContext
    EntityManager em;

    @Override
    public List<Customer> getAllCustomers() {
        Query query=em.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerById(Integer idu) {
        Query query=em.createQuery("SELECT c FROM Customer c WHERE c.id="+idu);
        List<Customer> customer=query.getResultList();
        return customer.get(0);
    }


    public Customer getCustomerById(Customer customer) {
        Customer customer1=em.find(Customer.class, customer.getId());
        return customer1;
    }

    @Override
    public List<Customer> getFilterCustomers(String sqlQuery) {

        Query query=em.createQuery("SELECT c FROM Customer c "+sqlQuery);
        List<Customer> customers=query.getResultList();
        return customers;
    }

    @Override
    public Customer getCustomerByUsernameAndPassword(String usernameu, String passwordu) {
        Query query=em.createQuery("SELECT c FROM Customer c WHERE c.username="+usernameu+" AND c.password="+passwordu);
        List<Customer> customers=query.getResultList();
        return customers.get(0);
    }

    @Override
    public Boolean insertCustomers(Customer customer) {

        em.persist(customer);
        return true;
    }

    @Transactional
    public Boolean updateCustomer(Customer customer) {
        Customer c=em.find(Customer.class,customer.getId());
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setAddress(customer.getAddress());
        c.setCity(customer.getCity());
        em.persist(c);
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteCustomerById(Customer customer) {

        Customer c=em.find(Customer.class,customer.getId());

        em.remove(c);
        return true;
    }
}
