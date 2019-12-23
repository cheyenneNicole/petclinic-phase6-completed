package com.example.business;


import com.example.model.*;
import com.example.service.CustomerService;

import com.example.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class StoreBusinessFlow {

    private static final Logger log = LoggerFactory.getLogger(StoreBusinessFlow.class.getName());

    private CustomerService customerService;
    private ItemService itemService;


    public StoreBusinessFlow(CustomerService customerService, ItemService itemService) {
        this.customerService = customerService;
        this.itemService = itemService;
    }

    public void runBusiness() {

        /*
        Customers
         */

        // Create Customers
        Customer customer1 = Customer.builder().withName("Homer Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Customer customer2 = Customer.builder().withName("Marge Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Customer customer3 = Customer.builder().withName("Bart Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();
        Customer customer4 = Customer.builder().withName("Lisa Simpson").withAddress("742 Evergreen Terrace").withCity("Springfield").withPhoneNumber("9395550113").build();

        // saveCustomer
        customerService.saveCustomer(customer1);
        customerService.saveCustomer(customer2);
        customerService.saveCustomer(customer3);
        customerService.saveCustomer(customer4);

        // getAllCustomers
        List<Customer> customers = customerService.getAllCustomers();
        customers.forEach(customer -> log.info(customer.toString()));

        // getCustomerByName
        final String searchFor = "Homer Simpson";
        List<Customer> homers = customerService.getCustomerByName(searchFor);

        final AtomicInteger counter = new AtomicInteger(1);
        homers.forEach(homer -> {

            StringBuilder sb = new StringBuilder();
            sb.append(searchFor);
            sb.append(" ");
            sb.append(counter.getAndIncrement());
            sb.append(": ");
            sb.append(homer);

            log.info(sb.toString());
        });

        /*
        Items
         */

        Customer homer = null;
        if (!homers.isEmpty()) {
            homer = homers.get(0);
        }

        String target = "Marge Simpson";
        List<Customer> marges = customerService.getCustomerByName(target);
        Customer marge = null;
        if (!marges.isEmpty()) {
            marge = marges.get(0);
        }

        target = "Bart Simpson";
        List<Customer> barts = customerService.getCustomerByName(target);
        Customer bart = null;
        if (!barts.isEmpty()) {
            bart = barts.get(0);
        }

        target = "Lisa Simpson";
        List<Customer> lisas = customerService.getCustomerByName(target);
        Customer lisa = null;
        if (!lisas.isEmpty()) {
            lisa = lisas.get(0);
        }

        // Items for Homer
        Item item1 = Item.builder().withName("Strangles").withBirthDate(new Date()).withCustomerId(homer.getId()).build();
        Item item2 = Item.builder().withName("Mojo").withBirthDate(new Date()).withCustomerId(homer.getId()).build();
        Item item3 = Item.builder().withName("Pinchy").withBirthDate(new Date()).withCustomerId(homer.getId()).build();
        Item item4 = Item.builder().withName("Plopper").withBirthDate(new Date()).withCustomerId(homer.getId()).build();

        // Items for Marge
        Item item5 = Item.builder().withName("Greyhound").withBirthDate(new Date()).withCustomerId(marge.getId()).build();

        // Items for Bart
        Item item6 = Item.builder().withName("Laddie").withBirthDate(new Date()).withCustomerId(bart.getId()).build();
        Item item7 = Item.builder().withName("Santa's Little Helper").withBirthDate(new Date()).withCustomerId(bart.getId()).build();
        Item item8 = Item.builder().withName("Stampy").withBirthDate(new Date()).withCustomerId(bart.getId()).build();
        Item item9 = Item.builder().withName("Duncan").withBirthDate(new Date()).withCustomerId(bart.getId()).build();


        // Items for Lisa
        Item item10 = Item.builder().withName("Nibbles").withBirthDate(new Date()).withCustomerId(lisa.getId()).build();
        Item item11 = Item.builder().withName("Chirpy Boy").withBirthDate(new Date()).withCustomerId(lisa.getId()).build();
        Item item12 = Item.builder().withName("Bart Junior").withBirthDate(new Date()).withCustomerId(lisa.getId()).build();
        Item item13 = Item.builder().withName("Snowball IV").withBirthDate(new Date()).withCustomerId(lisa.getId()).build();
        Item item14 = Item.builder().withName("Princess").withBirthDate(new Date()).withCustomerId(lisa.getId()).build();

        itemService.saveItem(item1);
        itemService.saveItem(item2);
        itemService.saveItem(item3);
        itemService.saveItem(item4);
        itemService.saveItem(item5);
        itemService.saveItem(item6);
        itemService.saveItem(item7);
        itemService.saveItem(item8);
        itemService.saveItem(item9);
        itemService.saveItem(item10);
        itemService.saveItem(item11);
        itemService.saveItem(item12);
        itemService.saveItem(item13);
        itemService.saveItem(item14);

        List<Item> items = itemService.getAllItems();

        items.forEach(item -> log.info(item.getName()));

        List<Item> laddie = itemService.getItemByName("Laddie");

        laddie.forEach(l -> log.info(l.toString()));


    }
}
