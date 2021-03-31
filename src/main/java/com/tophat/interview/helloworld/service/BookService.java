package com.tophat.interview.helloworld.service;/* a0b02xy created on 2021-03-29 inside the package - com.tophat.interview.helloworld.service */

import com.tophat.interview.helloworld.model.Book;
import com.tophat.interview.helloworld.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public boolean saveBook(Book book) {
    boolean isSaved = false;

    try{
      bookRepository.insertBook(book);
      isSaved = true;
      log.info("Book saved successfully for isbn - {}", book.getIsbn());
    } catch (Exception e) {
      log.error("Exception in saving book - {}", e.getMessage());
    }

    return isSaved;
  }

  public Book getBookByIsbn(int isbn) {
    try{
      log.info("Getting book by isbn - {}", isbn);
      return bookRepository.getBookByIsbn(isbn);
    } catch (Exception e) {
      log.error("Error in fetching book - {}", e.getMessage());
    }
    return null;
  }

}
