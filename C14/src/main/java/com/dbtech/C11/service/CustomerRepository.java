package com.dbtech.C11.service;

import com.dbtech.C11.dao.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByPhone (String phone);

    @Query("select c from Customer c where c.address like %?1%")
    public List<Customer> searchByStreetType (String search);

    @Query( value ="select * from customers c where length(c.last_name) > ?1 ", nativeQuery = true)
    public List<Customer> searchByLastNameLength (int minLastNameLength);

}