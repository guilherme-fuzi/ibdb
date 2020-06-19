package com.ibdb.service;

import java.util.List;
import java.util.Optional;

import com.ibdb.documents.Book;

public interface BookService {

	Book registerBook(Book book);
	Optional<Book> getBookById(String id);
	List<Book> listAllBooks();
	Book addRating(Book book, Integer rating);
	void deleteBookById(String id);
	Book updateBook(Book book);
}
