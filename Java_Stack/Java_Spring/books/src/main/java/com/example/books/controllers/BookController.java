package com.example.books.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.books.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	 BookService bookService;
	
	@RequestMapping("/")
	 String showAllBooks( Model model) {
		model.addAttribute("books",bookService.allBooks());
		return "showAll.jsp";
	}
	
	@RequestMapping("/{id}")
	 String showBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookService.findBook(id));
		return "show.jsp";
	}
}



