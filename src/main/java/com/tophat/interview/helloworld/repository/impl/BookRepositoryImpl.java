package com.tophat.interview.helloworld.repository.impl;/* a0b02xy created on 2021-03-29 inside the package - com.tophat.interview.helloworld.repository */

import com.tophat.interview.helloworld.model.Book;
import com.tophat.interview.helloworld.repository.mapper.BookMapper;
import com.tophat.interview.helloworld.repository.BookRepository;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class BookRepositoryImpl extends JdbcDaoSupport implements BookRepository {

  private static final String INSERT_BOOK = "INSERT INTO book (isbn, title, synopsis, authorName, publisherName, publicationDate) VALUES (?, ?, ?, ?, ?, ?)";

  private static final String BOOK_BY_ISBN = "SELECT * FROM book where isbn = ?";

  private final DataSource dataSource;

  @PostConstruct
  private void initialize() {
    setDataSource(dataSource);
  }

  @Override
  public void insertBook(Book book) {
    getJdbcTemplate().update(INSERT_BOOK, book.getIsbn(), book.getTitle(), book.getSynopsis(), book.getAuthorName(),
                        book.getPublisherName(), book.getPublicationDate());
  }

  @Override
  public Book getBookByIsbn(int isbn)  {
    return getJdbcTemplate().queryForObject(BOOK_BY_ISBN, new BookMapper(), isbn);
  }

}
