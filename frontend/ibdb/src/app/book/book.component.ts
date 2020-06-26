import { Component, OnInit } from '@angular/core';

import { BookService } from './book.service';
import { Book } from './book';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { AsyncPipe, NgForOf } from '@angular/common';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'] 
})
export class BookComponent implements OnInit {
  
  bookList$: Observable<Book[]>;
  idAux: String = '';

  book = {
    title: '',
    author: [''],
    gender: [''],
    comments: [''],
    rating: []
  }
  constructor(public bookService: BookService) { }

  isSubmit: boolean = true;

  ngOnInit(): void {
    this.loadData();
  }

  submitForm(data: NgForm){
    if(this.isSubmit){
      this.createBook(data);
    } else {
      this.updateBook(data);
      this.isSubmit = true;
    }
  }

  createBook(data: NgForm){
    let newBook = new Book(data.value.title, [data.value.author], [data.value.gender], null, null);
    this.bookService.save(newBook);
  }

  deleteBook(id: String){
    this.bookService.delete(id);
  }

  updateBook(data: NgForm){
    let updatedBook = { title: data.value.title, 
                        author:[data.value.author],
                        gender:[data.value.gender]
                      };
    this.bookService.update(this.idAux, updatedBook);
    this.idAux = '';
  }

  findBookById(id: string){
    this.bookService.getBookById(id).subscribe(book => {
      this.idAux = id.toString();
      this.book.title = book.title;
      this.book.author = book.author;
      this.book.gender = book.gender;
      console.log(book);
    });
  }

  loadData(){
    this.bookList$ = this.bookService.getBookList();
  }
}
