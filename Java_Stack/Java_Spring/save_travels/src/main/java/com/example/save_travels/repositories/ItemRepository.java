package com.example.save_travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.save_travels.models.Item;


public interface ItemRepository  extends CrudRepository<Item, Long> {
    List<Item> findAll();

}
