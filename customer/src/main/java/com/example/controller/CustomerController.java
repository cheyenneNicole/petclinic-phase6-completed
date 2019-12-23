package com.example.controller;

import com.example.models.Customer;
import com.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController implements BasicController<Customer> {

    private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @PostMapping(value = "addCustomer", produces = "application/json")
    public Customer add(@RequestBody Customer customer) {

        return this.customerService.add(customer);
    }

    @Override
    @GetMapping(value = "getById/{id}", produces = "application/json")
    public Customer get(@PathVariable("id") Long id) {

        // Demonstrates exception handling with ResponseStatusException exception
        Customer customer = null;
        try {
            customer = this.customerService.get(id);
        } catch (Exception exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Customer [" + id + "] Not Found", exc);
        }
        return customer;
    }

    @Override
    @PutMapping(value = "updateCustomer", produces = "application/json")
    public Customer modify(@RequestBody Customer customer) {

        return this.customerService.modify(customer);
    }

    @Override
    @RequestMapping(value = "deleteCustomer", method = {RequestMethod.DELETE}, produces = "application/json")
    public boolean delete(@RequestBody Customer customer) {

        return this.customerService.delete(customer);
    }

    @Override
    @GetMapping(value = "getAllCustomers", produces = "application/json")
    public List<Customer> getAll() {

        List<Customer> all = this.customerService.getAll();
        return all;
    }

    @GetMapping(value = "getCustomerByFirst_name/{name}", produces = "application/json")
    public List<Customer> getCustomerByFirst_name(@PathVariable("name") String name) {

        return this.customerService.getCustomerByFirst_name(name);
    }

}
