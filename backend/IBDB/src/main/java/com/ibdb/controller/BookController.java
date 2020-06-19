package com.ibdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibdb.documents.Book;
import com.ibdb.service.BookService;

@RestController
@RequestMapping(path="/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/create")
	public ResponseEntity<Book> registerBook(@RequestBody Book book){
		return ResponseEntity.ok(this.bookService.registerBook(book));
	}
	
	@GetMapping("/retrieve")
	public ResponseEntity<List<Book>> listAllBooks(){
		return ResponseEntity.ok(this.bookService.listAllBooks());
	}
	
	@GetMapping("/retrieve/{id}")
	public ResponseEntity<Book> getBook(@PathVariable(name="id")String id){
		return ResponseEntity.ok(this.bookService.getBookById(id));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(name="id")String id, @RequestBody Book book){
		book.setId(id);
		
		return ResponseEntity.ok(this.bookService.updateBook(book));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteBookById(@PathVariable(name="id")String id){
		return ResponseEntity.ok(this.bookService.deleteBookById(id));
	}
	
	@PostMapping("/review/{id}")
	public ResponseEntity<Book> commentBook(@PathVariable(name="id")String id, @RequestBody Book book){
		Book b = this.bookService.getBookById(id);
		b.getComments().add(book.getComments().get(0));
		b.getRating().add((book.getRating().get(0)));
		
		return ResponseEntity.ok(this.bookService.updateBook(b));
	}
}
