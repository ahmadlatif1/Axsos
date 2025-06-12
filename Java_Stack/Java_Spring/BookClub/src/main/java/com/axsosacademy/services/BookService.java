package com.axsosacademy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsosacademy.models.Book;
import com.axsosacademy.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
    public Book findbyid(long user_id) {
        return bookRepository.findById(user_id).orElse(null);
    }
    
    public List<Book> allBook() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}

