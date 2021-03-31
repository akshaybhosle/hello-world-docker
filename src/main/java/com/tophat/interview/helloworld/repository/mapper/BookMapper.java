package com.tophat.interview.helloworld.repository.mapper;/* a0b02xy created on 2021-03-31 inside the package - com.tophat.interview.helloworld.repository */

import com.tophat.interview.helloworld.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements RowMapper<Book> {

  @Override
  public Book mapRow(ResultSet rs, int i) throws SQLException {

    Book book = new Book();
    book.setIsbn(rs.getInt("isbn"));
    book.setTitle(rs.getString("title"));
    book.setAuthorName(rs.getString("authorName"));
    book.setSynopsis(rs.getString("synopsis"));
    book.setPublisherName(rs.getString("publisherName"));
    book.setPublicationDate(rs.getDate("publicationDate"));
    book.setLastUpdateTs(rs.getTimestamp("last_update_ts"));
    return book;
  }
}
