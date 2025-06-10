package com.example.burger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.burger.models.Burger;
import com.example.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
	   // adding the book repository as a dependency
    private final BurgerRepository burgerRepository;
    
    
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    // returns all the books
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a book
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }
    // retrieves a book
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	public Burger updateBurger(Long id, String burger_name,String notes,  String restaurant, Integer rating) {
		// TODO Auto-generated method stub
		Burger tmp=this.findBurger(id);
		tmp.setBurger_name(burger_name);
		tmp.setNotes(notes);
		tmp.setRestaurant(restaurant);
		tmp.setRating(rating);
		this.burgerRepository.save(tmp);
		return tmp;
	}
		
}
