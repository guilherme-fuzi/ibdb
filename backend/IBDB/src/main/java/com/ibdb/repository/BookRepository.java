package com.ibdb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibdb.documents.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}
