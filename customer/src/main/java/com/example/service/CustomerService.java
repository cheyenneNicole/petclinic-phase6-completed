package com.example.service;

import com.example.models.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements BasicService<Customer> {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {

        this.customerRepository = customerRepository;
    }

    @Override
    public Customer add(Customer customer) {

        return this.customerRepository.save(customer);
    }

    @Override
    public Customer get(Long id) {

        Optional optional = this.customerRepository.findById(id);

        Customer result = null;
        if (optional.isPresent()) {
            result = (Customer) optional.get();
        }
        return result;
    }

    @Override
    public Customer modify(Customer customer) {

        return this.customerRepository.save(customer);
    }

    @Override
    public boolean delete(Customer customer) {

        this.customerRepository.delete(customer);
        return true;
    }

    @Override
    public List<Customer> getAll() {

        return (List<Customer>) customerRepository.findAll();
    }


    public List<Customer> getCustomerByFirst_name(String name) {

        return this.customerRepository.findCustomerByFirst_name(name);
    }
}
