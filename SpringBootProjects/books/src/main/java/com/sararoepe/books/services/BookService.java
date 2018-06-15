package com.sararoepe.books.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sararoepe.books.models.Book;
import com.sararoepe.books.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepository;
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	List<Book> books = new ArrayList<Book>(Arrays.asList(
//			new Book("Harry Potter and the Sorcerer's Stone", "A boy wizard saving the world", "english", 309, null, null),
//            new Book("The Great Gatsby", "The story primarily concerns the young and mysterious millionaire Jay Gatsby", "english", 180, null, null),
//            new Book("Moby Dick", "The saga of Captain Ahab", "english", 544, null, null),
//            new Book("Don Quixote", "Life of a retired country gentleman", "english", 150, null, null),
//            new Book("The Odyssey", "Ancient Greek epic poem", "english", 475, null, null)
		));
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book findBookById(Long id) {
		return bookRepository.findOne(id);
	}
	
	public void addBook(Book book) {
		bookRepository.save(book);
	}
	
	public void updateBook(Book book) {
		bookRepository.save(book);
	}
	
	public void destroyBook(Long id) {
		bookRepository.delete(id);
	}
}
