import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Book } from './book';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private baseUrl = 'http://localhost:8080/book';

  constructor(private http: HttpClient) { }

  getBookList(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  saveBook(book: Book) {
    console.log(book)
    return this.http.post(this.baseUrl, JSON.stringify(book), httpOptions);
  }

  delete(id: String) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}
