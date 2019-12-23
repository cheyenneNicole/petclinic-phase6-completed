package com.example.service;

import com.example.model.Customer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private RestTemplate restTemplate;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Customer saveCustomer(Customer customer) {

        URI uri = URI.create("http://localhost:9191/customerapi/customer/addCustomer");

        Customer response = restTemplate.postForObject(uri, customer, Customer.class);

        log.info(new StringBuilder().append("Saved Customer: ").append(response.toString()).toString());
        return response;

    }

    public List<Customer> getAllCustomers() {

        URI uri = URI.create("http://localhost:9191/customerapi/customer/getAllCustomers");

        List<LinkedHashMap<String, String>> response = restTemplate.getForObject(uri, List.class);

        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customers = mapper.convertValue(response, new TypeReference<List<Customer>>() {
        });

        log.info(new StringBuilder().append("Returning all customers.").toString());
        return customers;

    }

    public List<Customer> getCustomerByName(String name) {

        // string replacement needed to create proper URL
        String modifiedName = name.replaceAll(" ", "%20");
        URI uri = URI.create("http://localhost:9191/customerapi/customer/getCustomerByName/" + modifiedName);

        List<LinkedHashMap<String, String>> response = restTemplate.getForObject(uri, List.class);

        ObjectMapper mapper = new ObjectMapper();
        List<Customer> customers = mapper.convertValue(response, new TypeReference<List<Customer>>() {
        });

        log.info(new StringBuilder().append("Returning customer [").append(name).append("].").toString());

        return customers;

    }


}
