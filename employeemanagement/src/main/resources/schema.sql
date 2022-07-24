DROP TABLE IF EXISTS employee;
  
CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  primary key (id)
);

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  role_id int NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (role_id)
);

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id int NOT NULL AUTO_INCREMENT,
  password varchar(255) DEFAULT NULL,
  username varchar(255) DEFAULT NULL,
  PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  user_id int NOT NULL,
  role_id int NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (user_id),
  FOREIGN KEY (role_id) REFERENCES roles (role_id)
);