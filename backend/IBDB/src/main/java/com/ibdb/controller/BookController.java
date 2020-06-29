package com.ibdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibdb.documents.Book;
import com.ibdb.service.BookService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping
	public ResponseEntity<Book> registerBook(@RequestBody Book book){
		return new ResponseEntity<Book>(this.bookService.registerBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> listAllBooks(){
		List<Book> books = this.bookService.listAllBooks();
		if(!books.isEmpty()){
			return ResponseEntity.ok(books);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable(name="id")String id){
		Optional<Book> bookO = this.bookService.getBookById(id);
		if(!bookO.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(bookO.get(), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(name="id")String id, @RequestBody Book book){
		Optional<Book> bookO = this.bookService.getBookById(id);
		if(!bookO.isPresent()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		book.setId(bookO.get().getId());
		return new ResponseEntity<Book>(this.bookService.updateBook(book), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable(name="id")String id){
		Optional<Book> book = this.bookService.getBookById(id);
		if(book.isPresent()){
			this.bookService.deleteBookById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/review/{id}")
	public ResponseEntity<Book> commentBook(@PathVariable(name="id")String id, @RequestBody Book book){
		Book b = this.bookService.getBookById(id).get();
		b.getComments().add(book.getComments().get(0));
		b.getRating().add((book.getRating().get(0)));
		
		return ResponseEntity.ok(this.bookService.updateBook(b));
	}
}
