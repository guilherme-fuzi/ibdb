import { Component, OnInit } from '@angular/core';

import { BookService } from '../book.service';
import { Book } from '../book';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  bookList: Observable<Book[]>;

  constructor(public bookService: BookService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(): void{
    this.bookList = this.bookService.getBookList();
  }
  
}
