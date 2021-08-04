package shopifyadvanced.dao.crudRepository;


import shopifyadvanced.dao.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Customer findCustomerById(Integer id);
    List<Customer> findAll();
    List<Customer> findCustomersByUsernameOrCityOrCountry(String username,String city,String country );
    void deleteById(Integer id);
    Customer findCustomerByUsernameAndPassword(String username,String password);


}
