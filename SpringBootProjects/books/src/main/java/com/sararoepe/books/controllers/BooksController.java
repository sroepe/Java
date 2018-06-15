package com.sararoepe.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sararoepe.books.models.Book;
import com.sararoepe.books.services.BookService;
@Controller
public class BooksController {
	
	
	private final BookService bookService;
	public BooksController(BookService bookService) {
		this.bookService=bookService;
	}
	
	@RequestMapping("/books")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books";	
	}
	
	@RequestMapping("/books/{index}")
	public String findBookByIndex(Model model, @PathVariable("index") Long index) {
		model.addAttribute("book", bookService.findBookById(index));
		return "showBook";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook";
	}
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "newBook";
		}else {
			bookService.addBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBookById(id);
		if(book !=null) {
			model.addAttribute("book", book);
			return "editBook";
		}else {
			return "redirect:/books";
		}
	}
	
	@PostMapping("/books/edit/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editBook";
		}else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}
	
	@RequestMapping("/books/delete/{id}")
	public String destroyBook(@PathVariable("id") Long id) {
		bookService.destroyBook(id);
		return "redirect:/books";
	}
}
