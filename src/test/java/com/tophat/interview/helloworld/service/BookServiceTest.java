package com.tophat.interview.helloworld.service;/* a0b02xy created on 2021-03-31 inside the package - com.tophat.interview.helloworld.service */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tophat.interview.helloworld.model.Book;
import com.tophat.interview.helloworld.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

  @InjectMocks
  private BookService bookService;

  @Mock
  private BookRepository bookRepository;

  @Test
  public void testShouldSaveBook()  {
    boolean result = bookService.saveBook(createBook());

    verify(bookRepository, times(1)).insertBook(createBook());

    assertTrue(result);
  }

  @Test
  public void testShouldGetBookByIsbn() {
    when(bookRepository.getBookByIsbn(1)).thenReturn(createBook());

    Book book = bookService.getBookByIsbn(1);

    assertEquals(book.getAuthorName(), "abcd");
  }

  private Book createBook() {
    Book book = new Book();
    book.setIsbn(1);
    book.setAuthorName("abcd");

    return book;
  }

}
