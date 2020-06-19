package com.ibdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibdb.documents.Book;
import com.ibdb.repository.BookRepository;
import com.ibdb.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book registerBook(Book book) {
		return this.bookRepository.save(book);
	}

	@Override
	public Book getBookById(String id) {
		return this.bookRepository.findById(id).get();
	}

	@Override
	public List<Book> listAllBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book addRating(Book book, Integer rating) {
		book.getRating().add(rating);
		return this.bookRepository.save(book);
	}

	@Override
	public Integer deleteBookById(String id) {
		try {
			this.bookRepository.deleteById(id);
			return 1;	
		} catch(Exception e) {
			return 0;
		}
		
	}

	@Override
	public Book updateBook(Book book) {
		return this.bookRepository.save(book);
	}
}
