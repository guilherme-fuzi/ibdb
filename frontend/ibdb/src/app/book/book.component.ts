import { Component, OnInit } from '@angular/core';

import { BookService } from './book.service';
import { Book } from './book';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'] 
})
export class BookComponent implements OnInit {
  
  book = {
    title: '',
    author: '',
    gender: ''
  }

  constructor(public bookService: BookService) { }

  ngOnInit(): void {
  }

  createBook(){
    // const data = {
    //   title: this.book.title,
    //   author: [this.book.author],
    //   gender: [this.book.gender]
    // } 
    let data = new Book(this.book.title, [this.book.author], [this.book.gender], null, null);
    this.bookService.saveBook(data);
  }

}
