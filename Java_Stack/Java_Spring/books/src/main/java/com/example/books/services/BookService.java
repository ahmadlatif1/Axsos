package com.example.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.books.models.Book;
import com.example.books.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Book tmp=this.findBook(id);
		tmp.setTitle(title);
		tmp.setDescription(desc);
		tmp.setLanguage(lang);
		tmp.setNumberOfPages(numOfPages);
		this.bookRepository.save(tmp);
		return tmp;
		
		
	}
}