import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BookModule } from './book/book.module';
import { BookService } from './book/book.service';
import { routing } from './app.routing';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BookModule,
    HttpClientModule,
    routing
  ],
  providers: [BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
