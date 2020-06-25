import { Component, OnInit } from '@angular/core';

import { BookService } from './book.service';
import { Book } from './book';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'] 
})
export class BookComponent implements OnInit {
  
  bookList: Observable<Book[]>;

  book = {
    title: '',
    author: '',
    gender: ''
  }

  constructor(public bookService: BookService) { }

  ngOnInit(): void {
    this.loadData();
  }

  createBook(){
    let data = new Book(this.book.title, [this.book.author], [this.book.gender], null, null);
    this.bookService.saveBook(data);
  }

  deleteBook(id: String){
    this.bookService.delete(id);
  }

  updateBook(){
    
  }

  loadData(){
    this.bookList = this.bookService.getBookList();
  }
}
