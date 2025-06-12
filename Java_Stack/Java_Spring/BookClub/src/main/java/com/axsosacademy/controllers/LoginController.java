package com.axsosacademy.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsosacademy.models.Book;
import com.axsosacademy.models.LoginUser;
import com.axsosacademy.models.User;
import com.axsosacademy.repositories.BookRepository;
import com.axsosacademy.services.BookService;
import com.axsosacademy.services.LogRegService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	
	 @Autowired
	 LogRegService logRegService;
	@Autowired
	BookService bookService;
	 
	    @GetMapping("/")
	    public String index(Model model) {
	    
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        User reg = logRegService.register(newUser, result);

	        
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        
	        session.setAttribute("userId", reg.getId());
	    
	        return "redirect:/";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	         User user = logRegService.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        session.setAttribute("userName", user.getUserName());
	        session.setAttribute("userId", user.getId());
	    
	        return "redirect:/success";
	    }
	    
	    @GetMapping("/success")
	    public String success(HttpSession session,Model model) {
	        Long userId = (Long) session.getAttribute("userId");
	        
	        if (userId == null) {
	            return "redirect:/";
	            }
	        List<Book> books = bookService.allBook();
	        List<User> users = logRegService.allUser();
	        User loguser = logRegService.findUserById(userId);
	        model.addAttribute("user", loguser);
	        model.addAttribute("books", books);
	        model.addAttribute("users", users);
	    	return"succes.jsp";
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";  
	    }
	    
	    @PostMapping("/book/new")
	    public String form(@Valid @ModelAttribute("newBook") Book book, BindingResult result, Model model,HttpSession session) {
	        if (result.hasErrors()) {
	              return "createbook.jsp";
	          } else {
	              Long userId = (Long) session.getAttribute("userId");
	              User user = logRegService.findUserById(userId);
	        	  book.setUser(user);
	        	  bookService.createBook(book);
	              return "redirect:/success";
	    }

	    }
	    @GetMapping("/books/new")
	    public String newbook(@ModelAttribute("newBook") Book book, BindingResult result, Model model) {
	    	return"createbook.jsp";
	    }
	    
	    @GetMapping("/books/{id}")
	    public String showBooks(@PathVariable("id") Long id, Model model,HttpSession session) {
	        Book book = bookService.findbyid(id);
	        Long userId = (Long) session.getAttribute("userId");
	        User user = logRegService.findUserById(userId);
	        model.addAttribute("book", book);
	        model.addAttribute("user", user);
	        return "disc.jsp";
	    }
	    
	    @GetMapping("/books/edit/{id}")
	    public String editBooks(@PathVariable("id") Long id, Model model,HttpSession session) {
	        Book book = bookService.findbyid(id);
	        Long userId = (Long) session.getAttribute("userId");
	        if (!book.getUser().getId().equals(userId)) {
	            return "redirect:/success";
	        }

	        model.addAttribute("book", book);
	        
	    	return "editbook.jsp";
	    }
	    @PostMapping("/books/update/{id}")
	    public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session, Model model) {
	        
	        if (result.hasErrors()) {
	            return "editbook.jsp";
	        }
	        Book edit = bookService.findbyid(id);
	        book.setUser(edit.getUser());
	        book.setId(id);
	        bookService.createBook(book);
	        return "redirect:/success";
	    }
	    
	    @DeleteMapping("/books/delete/{id}")
	    public String deletebook(@PathVariable("id") Long id) {
	    	bookService.deleteBook(id);
	    	return "redirect:/success";
	    }
}

