package com.tophat.interview.helloworld.controller;/* a0b02xy created on 2021-03-31 inside the package - com.tophat.interview.helloworld.controller */

import com.tophat.interview.helloworld.model.Book;
import com.tophat.interview.helloworld.service.BookService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping(value = "/v1/book")
public class BookController {

  private final BookService bookService;

  @GetMapping("/fetch")
  public ResponseEntity<Book> getBook(@Valid @RequestParam("isbn") int isbn) {
    Book book = bookService.getBookByIsbn(isbn);

    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> saveBook(@Valid @RequestBody Book book)  {

    return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
  }

}
