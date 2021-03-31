package com.tophat.interview.helloworld.repository;/* a0b02xy created on 2021-03-31 inside the package - com.tophat.interview.helloworld */

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.tophat.interview.helloworld.model.Book;
import com.tophat.interview.helloworld.repository.impl.BookRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.eq;

@RunWith(MockitoJUnitRunner.class)
public class BookRepositoryTest extends JdbcDaoSupport {

  @InjectMocks
  private BookRepositoryImpl bookRepository;

  @Mock
  private JdbcTemplate jdbcTemplate;

  @Test
  public void testShouldGetBookByIsbn() {
    int isbn = 1;

    ReflectionTestUtils.setField(bookRepository, "jdbcTemplate", jdbcTemplate);

    Mockito.when(jdbcTemplate.queryForObject(anyString(), any(RowMapper.class), eq(isbn))).thenReturn(createBook());

    Book book = bookRepository.getBookByIsbn(1);

    assertEquals(book.getAuthorName(), "abcd");
  }

  private Book createBook() {
    Book book = new Book();
    book.setIsbn(1);
    book.setAuthorName("abcd");

    return book;
  }
}
