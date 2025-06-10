package com.example.save_travels.controllers;

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

import com.example.save_travels.models.Item;
import com.example.save_travels.services.ItemService;

import jakarta.validation.Valid;

@Controller
public class travelController {


	@Autowired
	ItemService itemservice;
	
	@RequestMapping("")
	public String index(Model model) {
		
		model.addAttribute("items",itemservice.allItems());
		
		return "index.jsp";
	}
	

	@GetMapping("/")
	public String view(Model model) {
	    model.addAttribute("item", new Item());
		model.addAttribute("items",itemservice.allItems());

	    
		return "index.jsp";
	}
	
	@PostMapping("/add")
    public String create(@Valid @ModelAttribute("item") Item item, BindingResult result,Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("items",itemservice.allItems());
            return "index.jsp";
        } else {
            itemservice.createItem(item);
            return "redirect:/";
        }
	}
	
	@RequestMapping(value="items/edit/{id}", method=RequestMethod.GET)
    public String viewEditItem(@ModelAttribute("item") Item item, Model model, @PathVariable int id) {
        Item itemToEdit = itemservice.findItem((long) id);
        model.addAttribute("item", itemToEdit);
        return "edit.jsp";
    }

    @PostMapping("/items/edit/{id}/add")
    public String updateItem(@Valid @ModelAttribute("item") Item item, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            itemservice.updateItem((Long)id,item);
            return "redirect:/";
        }
    }
    
	@RequestMapping(value="items/expenses/{id}", method=RequestMethod.GET)
	public String showItem(Model model,@PathVariable Long id) {
		model.addAttribute("item",itemservice.findItem(id));
		return "details.jsp";
	}
	
	@RequestMapping("items/delete/{id}")
	public String deleteItem(Model model,@PathVariable Long id) {
		itemservice.deleteItem(id);
		return "redirect:/";
	}

    
}
