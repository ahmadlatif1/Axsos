package com.axsosacademy.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsosacademy.products.models.Category;
import com.axsosacademy.products.models.Product;
import com.axsosacademy.products.services.CategoryService;
import com.axsosacademy.products.services.ProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProCatControler {
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("")
	 public String index() {
		return"index.jsp";
	}
	@GetMapping("/product")
	public String pro(@ModelAttribute("newProduct") Product product, BindingResult result, Model model) {
		return"createproduct.jsp";
	}
	@PostMapping("/product/new")
    public String form(@Valid @ModelAttribute("newProduct") Product product, BindingResult result, Model model,HttpSession session) {
        if (result.hasErrors()) {
              return "createproduct.jsp";
          } else {
        	  productService.createProduct(product);
        	  return"redirect:/";
          }
	}
	@GetMapping("/category")
	public String showCat(@ModelAttribute("newCategory") Category category, BindingResult result, Model model) {
		return"createCat.jsp";
	}
	
	@PostMapping("/category/new")
    public String newcat(@Valid @ModelAttribute("newCategory") Category category, BindingResult result, Model model,HttpSession session) {
        if (result.hasErrors()) {
              return "createCat.jsp";
          } else {
        	  categoryService.createCategory(category);
        	  return"redirect:/";
          }
	}
	@GetMapping("/category/{id}")
	public String showCatDetails(@ModelAttribute("product") Category category, BindingResult result, Model model,
			@PathVariable("id") Long id) {
		Category categoryfromid = categoryService.findbyid(id);
        model.addAttribute("category", categoryfromid);
        List<Product> products = productService.allProduct(); 
        List<Product> catproducts=categoryfromid.getProducts();
        model.addAttribute("catproducts", catproducts);
        model.addAttribute("products", products);
        return"categorydetail.jsp";
	}
	
	@PostMapping("/category/{id}/add/")
	public String addcatproo( Model model,@PathVariable("id") Long id,@RequestParam Long product_id) {
        
		if(!categoryService.findbyid(id).getProducts().contains(productService.findbyid(product_id)))

      	  categoryService.addProduct(id,productService.findbyid(product_id));
      	  return"redirect:/";
	}
	
	@GetMapping("/product/{id}")
	public String showCatDetailsss(@ModelAttribute("category") Product product, BindingResult result, Model model,
			@PathVariable("id") Long id) {
		Product Productfromid = productService.findbyid(id);
        model.addAttribute("product", Productfromid);
        List<Category> categories = categoryService.allCategory(); 
        List<Category> prodcats=Productfromid.getCategories();
        model.addAttribute("prodcats", prodcats);
        model.addAttribute("categories", categories);
        return"productDetails.jsp";
	}
	@PostMapping("/product/{id}/add/")
	public String addprodtocat( Model model,@PathVariable("id") Long id,@RequestParam Long cat) {
        
			if(!categoryService.findbyid(cat).getProducts().contains(productService.findbyid(id)))
      	  categoryService.addProduct(cat,productService.findbyid(id));
      	  return"redirect:/";
	}

	
}
