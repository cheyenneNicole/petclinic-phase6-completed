package com.example.controller;

import com.example.model.Customer;
import com.example.model.Item;
import com.example.model.ItemWithCustomer;
import com.example.service.CustomerServiceProxy;
import com.example.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController implements BasicController<Item> {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class.getName());

    private ItemService itemService;
    @Autowired
    private final CustomerServiceProxy customerServiceProxy;

    public ItemController(ItemService itemService, CustomerServiceProxy customerServiceProxy) {

        this.itemService = itemService;
        this.customerServiceProxy = customerServiceProxy;
    }

    @Override
    @PostMapping(value = "addItem", produces = "application/json")
    public Item add(@RequestBody Item item) {

        String itemName = item.getName();
        logger.info(new StringBuilder().append("Adding item [").append(itemName).append("].").toString());

        return this.itemService.add(item);
    }

    @Override
    @GetMapping(value = "getItemById/{id}", produces = "application/json")
    public ItemWithCustomer get(@PathVariable("id") Long id) {
        ItemWithCustomer itemWithCustomer = new ItemWithCustomer();
        itemWithCustomer.setItem(this.itemService.get(id));

        Customer customer = customerServiceProxy.getCustomerById(itemWithCustomer.getCustomerId());

        itemWithCustomer.setCustomer(customer);

        return itemWithCustomer;
    }

    @Override
    @PutMapping(value = "updateItem", produces = "application/json")
    public Item modify(@RequestBody Item item) {

        String itemName = item.getName();
        logger.info(new StringBuilder().append("Updating item [").append(itemName).append("].").toString());

        return this.itemService.modify(item);
    }

    @Override
    @DeleteMapping(value = "deleteItem", produces = "application/json")
    public boolean delete(@RequestBody Item item) {

        return this.itemService.delete(item);
    }

    @Override
    @GetMapping(value = "getAllItems", produces = "application/json")
    public List<Item> getAll() {

        return this.itemService.getAll();

    }

    @GetMapping(value = "getAllItemsByCustomer/{customerId}", produces = "application/json")
    public List<Item> getAllItemsForCustomer(@PathVariable("customerId") Long customerId) {

        return this.itemService.getAllItemsForCustomer(customerId);
    }

    @GetMapping(value = "getItemByName/{name}", produces = "application/json")
    public List<Item> getItemByName(@PathVariable("name") String name) {

        return this.itemService.getItemByName(name);
    }
}
