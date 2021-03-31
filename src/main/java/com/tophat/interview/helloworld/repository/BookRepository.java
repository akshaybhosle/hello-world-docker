package com.tophat.interview.helloworld.repository;

import com.tophat.interview.helloworld.model.Book;

public interface BookRepository {

  void insertBook(Book book);

  Book getBookByIsbn(int isbn);

}
