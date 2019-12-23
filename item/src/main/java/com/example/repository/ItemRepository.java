package com.example.repository;


import com.example.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> getItemsByCustomerId(Long customerId);

    List<Item> getItemByName(String name);

}
