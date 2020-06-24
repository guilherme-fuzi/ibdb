import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookComponent } from './book.component';
import { BookListComponent } from './book-list/book-list.component';

@NgModule({
  declarations: [
      BookListComponent,
      BookComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    BookListComponent,
    BookComponent
  ]  
})
export class BookModule { }
