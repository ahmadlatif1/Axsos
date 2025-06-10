package com.example.burger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.burger.models.Burger;
import com.example.burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class burgerController {
	
	@Autowired
	BurgerService burgerservice;
	
	@RequestMapping("")
	public String index(Model model) {
		
		model.addAttribute("burgers",burgerservice.allBurgers());
		
		return "index.jsp";
	}
	

	@GetMapping("/")
	public String view(Model model) {
	    model.addAttribute("burger", new Burger());
		model.addAttribute("burgers",burgerservice.allBurgers());

	    
		return "index.jsp";
	}
	
	@PostMapping("/add")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("burgers",burgerservice.allBurgers());
            return "index.jsp";
        } else {
            burgerservice.createBurger(burger);
            return "redirect:/";
        }
	}
	
	@RequestMapping(value="burgers/edit/{id}", method=RequestMethod.GET)
    public String viewEditBurger(@ModelAttribute("burger") Burger burger, Model model, @PathVariable int id) {
        Burger burgerToEdit = burgerservice.findBurger((long) id);
        model.addAttribute("burger", burgerToEdit);
        return "edit.jsp";
    }

    @PostMapping("/burgers/edit/{id}/add")
    public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable int id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            burgerservice.updateBurger(burger.getId(),burger.getBurger_name(),burger.getNotes(),burger.getRestaurant(),burger.getRating());
            return "redirect:/";
        }
    }
 
	
	
	
}
