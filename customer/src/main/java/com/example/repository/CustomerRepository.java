package com.example.repository;

import com.example.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findCustomerByFirst_name(String name);
}
