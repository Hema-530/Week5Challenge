DROP TABLE IF EXISTS EMPLOYEE;
  
CREATE TABLE EMPLOYEE(
  id INT AUTO_INCREMENT  ,
  forename VARCHAR(250) NOT NULL,
  surname VARCHAR(250) NOT NULL,
  age INT NOT NULL,
  company VARCHAR(250) NOT NULL,
  postcode INT NOT NULL,
  PRIMARY KEY (id)
);