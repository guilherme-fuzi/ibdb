package com.ibdb.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Optional<Book> getBookById(String id) {
		Optional<Book> book = this.bookRepository.findById(id);
		return book;
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
	public void deleteBookById(String id) {
		this.bookRepository.deleteById(id);
	}

	@Override
	public Book updateBook(Book book) {

		return this.bookRepository.save(book);
	}
}
