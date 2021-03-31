CREATE TABLE IF NOT EXISTS student (
  studentId INT NOT NULL AUTO_INCREMENT,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  emailAddress VARCHAR(50) NOT NULL,
  last_update_ts TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (studentId)
);

CREATE TABLE IF NOT EXISTS book (
  isbn INT NOT NULL,
  title VARCHAR(100) NOT NULL,
  synopsis VARCHAR(500),
  authorName VARCHAR(100) NOT NULL,
  publisherName VARCHAR(100) NOT NULL,
  publicationDate DATE NOT NULL,
  last_update_ts TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (isbn)
);
