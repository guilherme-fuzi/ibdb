
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { BookComponent } from './book/book.component';
import { BookListComponent } from './book/book-list/book-list.component';


const APP_ROUTES: Routes = [
    {
        path: 'book',
        component: BookComponent
    },
    {
        path: '',
        component: BookListComponent
    }
]

export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);