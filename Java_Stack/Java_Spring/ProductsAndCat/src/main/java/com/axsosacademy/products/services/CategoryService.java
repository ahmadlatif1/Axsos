package com.axsosacademy.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.products.models.Category;
import com.axsosacademy.products.models.Product;
import com.axsosacademy.products.repositories.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	CategoryRepo categoryRepo;
	
    public Category findbyid(long category_id) {
        return categoryRepo.findById(category_id).orElse(null);
    }
    
    public List<Category> allCategory() {
        return categoryRepo.findAll();
    }

    public Category addProduct(Long category_id, Product product) {
        Category category = findbyid(category_id);

    category.getProducts().add(product);
	return categoryRepo.save(category);
    }

    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }
	public void deleteBook(Long id) {
		categoryRepo.deleteById(id);
	}
	

}
