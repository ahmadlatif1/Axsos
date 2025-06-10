package com.example.save_travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.save_travels.models.Item;
import com.example.save_travels.repositories.ItemRepository;

@Service
public class ItemService {
	private final ItemRepository itemrepository;


    public ItemService(ItemRepository ItemRepository) {
        this.itemrepository = ItemRepository;
    }
    // returns all the books
    public List<Item> allItems() {
        return itemrepository.findAll();
    }
    // creates a book
    public Item createItem(Item b) {
        return itemrepository.save(b);
    }
    // retrieves a book
    public Item findItem(Long id) {
        Optional<Item> optionalItem = itemrepository.findById(id);
        if(optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            return null;
        }
    }
	public void deleteItem(Long id) {
		itemrepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	public Item updateItem(Long id,Item item) {
		// TODO Auto-generated method stub
		System.out.println("t\nest");
		Item tmp=this.findItem(id);
		tmp.setItem_name(item.getItem_name());
		tmp.setDescription(item.getDescription());
		tmp.setPrice(item.getPrice());
		tmp.setVendor(item.getVendor());
		this.itemrepository.save(tmp);
		return tmp;
	}
}
