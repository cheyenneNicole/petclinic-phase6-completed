package com.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a item customer.
 */

public class Customer {

    private Long id;

    private String name;
    private String address;
    private String city;
    private String phoneNumber;


    private List<Long> itemIds = new ArrayList<>();

    protected Customer() {

    }

    public Customer(String name, String address, String city, String phoneNumber) {

        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // This is needed to update the relationship between Item and Customer when adding a Item
    public void addItem(Long itemId) {
        itemIds.add(itemId);
    }

    // This is needed to update the relationship between Item and Customer when removing a Item
    public void removeItem(Long itemId) {
        itemIds.remove(itemId);
    }

    public List<Long> getItemIds() {
        return this.itemIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Customer {");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');

        return sb.toString();
    }

    // Builder pattern using static builder
    public static CustomerBuilder builder() {
        return new CustomerBuilder();
    }

    public static final class CustomerBuilder {

        private Customer customer;

        private CustomerBuilder() {
            customer = new Customer();
        }

        public CustomerBuilder withId(Long id) {
            customer.setId(id);
            return this;
        }

        public CustomerBuilder withName(String name) {
            customer.setName(name);
            return this;
        }

        public CustomerBuilder withAddress(String address) {
            customer.setAddress(address);
            return this;
        }

        public CustomerBuilder withCity(String city) {
            customer.setCity(city);
            return this;
        }

        public CustomerBuilder withPhoneNumber(String phoneNumber) {
            customer.setPhoneNumber(phoneNumber);
            return this;
        }

        public CustomerBuilder withItem(Long itemId) {
            customer.addItem(itemId);
            return this;
        }

        public Customer build() {
            return customer;
        }
    }
}
