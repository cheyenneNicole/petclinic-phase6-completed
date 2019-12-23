package com.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a item customer.
 */
@Entity(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String first_name;
    private String last_name;
    private String email;

    @ElementCollection
    private List<Long> itemIds = new ArrayList<>();

    protected Customer() {

    }

    public Customer(String first_name, String last_name, String email) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", email='").append(email).append('\'');
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

        public CustomerBuilder withFirstName(String first_name) {
            customer.setFirst_name(first_name);
            return this;
        }

        public CustomerBuilder withLastName(String last_name) {
            customer.setLast_name(last_name);
            return this;
        }

        public CustomerBuilder withEmail(String email) {
            customer.setEmail(email);
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
