package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Date birthDate;
    private Long customerId;


    protected Item() {

    }

    public Item(String name, Date birthDate, Long customerId) {

        this.name = name;
        this.birthDate = birthDate;
        this.customerId = customerId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    // only include id field when generating equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item {");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", customerId=").append(customerId);
        sb.append('}');
        return sb.toString();
    }

    public static ItemBuilder builder() {
        return new ItemBuilder();
    }

    public static final class ItemBuilder {
        private Item item;

        private ItemBuilder() {
            item = new Item();
        }

        public ItemBuilder withId(Long id) {
            item.setId(id);
            return this;
        }

        public ItemBuilder withName(String name) {
            item.setName(name);
            return this;
        }

        public ItemBuilder withBirthDate(Date birthDate) {
            item.setBirthDate(birthDate);
            return this;
        }


        public ItemBuilder withCustomerId(Long customerId) {
            item.setCustomerId(customerId);
            return this;
        }

        public Item build() {
            return item;
        }
    }
}
