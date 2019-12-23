package com.example.service;


import com.example.model.Item;
import com.example.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements BasicService<Item> {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    @Override
    public Item add(Item item) {

        return itemRepository.save(item);
    }

    @Override
    public Item get(Long id) {

        Optional optional = itemRepository.findById(id);

        Item result = null;
        if (optional.isPresent()) {
            result = (Item) optional.get();
        }
        return result;
    }

    @Override
    public Item modify(Item item) {

        return itemRepository.save(item);
    }

    @Override
    public boolean delete(Item item) {

        itemRepository.delete(item);
        return true;
    }

    @Override
    public List<Item> getAll() {

        return (List<Item>) itemRepository.findAll();
    }

    public List<Item> getAllItemsForCustomer(Long customerId) {

        return this.itemRepository.getItemsByCustomerId(customerId);
    }

    public List<Item> getItemByName(String name) {

        return this.itemRepository.getItemByName(name);
    }
}
