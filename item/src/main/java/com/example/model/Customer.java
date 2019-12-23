package com.example.model;

import java.util.Objects;

/**
 * This class represents a pet customer.
 */

public class Customer {

    private Long id;

    private String first_name;
    private String last_name;
    private String email;

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

        public CustomerBuilder withFirst_name(String first_name) {
            customer.setFirst_name(first_name);
            return this;
        }

        public CustomerBuilder withLast_name(String last_name) {
            customer.setLast_name(last_name);
            return this;
        }

        public CustomerBuilder withEmail(String email) {
            customer.setEmail(email);
            return this;
        }

        public Customer build() {
            return customer;
        }
    }
}
