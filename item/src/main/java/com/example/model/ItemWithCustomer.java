package com.example.model;

public class ItemWithCustomer extends Item {

    Customer customer;

    public ItemWithCustomer() {
    }

    public ItemWithCustomer(Customer customer) {

        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setItem(Item item) {
        this.setId(item.getId());
        this.setBirthDate(item.getBirthDate());
        this.setName(item.getName());
        this.setCustomerId(item.getCustomerId());
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
