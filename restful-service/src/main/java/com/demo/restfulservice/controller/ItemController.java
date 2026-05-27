package com.demo.restfulservice.controller;

import com.demo.restfulservice.model.Item;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private List<Item> itemList = new ArrayList<>();

    @PostConstruct
    public void init() {
        for (long i = 1; i<= 10; i++) {
            itemList.add(new Item(i, "Item " + i, "Description " + i));
        }
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemList;
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    @PostMapping
    public Item createItem(@Valid @RequestBody Item item) {
        item.setId((long) (itemList.size() + 1));
        itemList.add(item);
        return item;
    }

    @PutMapping("/{id}")
    public Optional<Item> updateItem(@PathVariable Long id, @Valid @RequestBody Item itemDetails) {
        return itemList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .map(item -> {
                    item.setName(itemDetails.getName());
                    item.setDescription(itemDetails.getDescription());
                    return item;
                });

    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemList.removeIf(item -> item.getId().equals(id));
    }
}
