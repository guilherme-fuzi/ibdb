package com.ibdb.service;

import java.util.List;

import com.ibdb.documents.Book;

public interface BookService {

	public Book registerBook(Book book);
	public Book getBookById(String id);
	public List<Book> listAllBooks();
	public Book addRating(Book book, Integer rating);
	public Integer deleteBookById(String id);
	public Book updateBook(Book book);
}
