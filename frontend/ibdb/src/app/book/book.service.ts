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

  save(book: Book){
    return this.http.post(this.baseUrl, JSON.stringify(book), httpOptions).subscribe();
  }

  delete(id: String) {
    return this.http.delete(`${this.baseUrl}/${id}`).subscribe();
  }

  update(id: String, book: any){
    return this.http.put(`${this.baseUrl}/${id}`, JSON.stringify(book), httpOptions).subscribe();
  }
 
  getBookList(): Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  getBookById(id: String): Observable<Book>{
    return this.http.get<Book>(`${this.baseUrl}/${id}`);
  }
}
