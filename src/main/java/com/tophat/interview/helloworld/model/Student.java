package com.tophat.interview.helloworld.model;/* a0b02xy created on 2021-03-29 inside the package - com.tophat.interview.helloworld.model */

import java.sql.Timestamp;
import lombok.Data;

@Data
public class Student {

  private int studentId;

  private String firstName;

  private String lastName;

  private String emailAddress;

  private Timestamp lastUpdateTs;

}
