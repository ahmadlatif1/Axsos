package com.axsosacademy.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.products.models.Product;
import com.axsosacademy.products.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;
	
    public Product findbyid(long product_id) {
        return productRepo.findById(product_id).orElse(null);
    }
    
    public List<Product> allProduct() {
        return productRepo.findAll();
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	
}
