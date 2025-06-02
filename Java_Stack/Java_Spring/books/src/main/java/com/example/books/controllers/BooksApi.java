package com.example.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.models.Book;
import com.example.books.services.BookService;
@RestController
@RequestMapping("/api")
public class BooksApi {
	@Autowired
     BookService bookService;
    
    
	 @RequestMapping(value="")
	    public String test() {
	        return "hello world";
	   }
	 
	 @GetMapping("/books/{id}")
	 public Book get(@PathVariable("id") Long id) {
		 return bookService.findBook(id);
	 }
    
    
    @PutMapping("/new")
    public Book create(
            @RequestParam(value="title") String title, 
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.createBook( new Book(title, desc, lang, numOfPages));
        return book;
    }
    
    
    
    // other methods removed for brevity
    @PutMapping("/books/{id}")
    public Book update(
            @PathVariable("id") Long id, 
            @RequestParam(value="title") String title, 
            @RequestParam(value="description") String desc, 
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
        return book;
    }
    
    @DeleteMapping("/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}