package com.tophat.interview.helloworld.model;/* a0b02xy created on 2021-03-29 inside the package - com.tophat.interview.helloworld.model */

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class Book {

  private int isbn;

  private String title;

  private String synopsis;

  private String authorName;

  private String publisherName;

  private Date publicationDate;

  private Timestamp lastUpdateTs;

}
