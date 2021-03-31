package com.tophat.interview.helloworld.repository.mapper;/* a0b02xy created on 2021-03-31 inside the package - com.tophat.interview.helloworld.repository */

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tophat.interview.helloworld.model.Book;
import com.tophat.interview.helloworld.repository.mapper.BookMapper;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BookMapperTest {

  @InjectMocks
  private BookMapper bookMapper;

  @Test
  public void testShouldGetBookMapper() throws Exception  {
    ResultSet rs = mock(ResultSet.class);

    when(rs.getInt("isbn")).thenReturn(1);
    when(rs.getString("title")).thenReturn("book1");
    when(rs.getString("authorName")).thenReturn("abcd");
    when(rs.getString("synopsis")).thenReturn("synp1");
    when(rs.getString("publisherName")).thenReturn("pub1");
    when(rs.getDate("publicationDate")).thenReturn(Date.valueOf("2020-01-01"));
    when(rs.getTimestamp("last_update_ts")).thenReturn(Timestamp.valueOf("2020-01-01 11:11:11"));

    assertEquals(createBook().getIsbn(), bookMapper.mapRow(rs, 1).getIsbn());

  }

  private Book createBook() {
    Book book = new Book();
    book.setIsbn(1);
    book.setAuthorName("abcd");

    return book;
  }


}
