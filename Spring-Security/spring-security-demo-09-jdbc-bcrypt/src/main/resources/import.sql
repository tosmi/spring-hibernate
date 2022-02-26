DROP SCHEMA IF EXISTS spring_security_demo_bcrypt CASCADE;

CREATE SCHEMA IF NOT EXISTS spring_security_demo_bcrypt;

SET search_path TO "spring_security_demo_bcrypt", PUBLIC;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    username varchar(50) NOT NULL PRIMARY KEY,
    password char(68) NOT NULL,
    enabled boolean
);

--
-- Inserting data for table `users`
--

INSERT INTO users
VALUES
    ('john','{bcrypt}$2a$12$h6YvQpphEOmYa9KLaDFy9OBCORho1RJjOwAt4QHe0KzlzuOmpC5Y2 ',true),
    ('mary','{bcrypt}$2a$12$nrkHgFiXNog7hoRwLOPPpu.gaq4/ohdeaEnEEEK0G92jwr2Xgb9/y ',true),
    ('susan','{bcrypt}$2a$12$xxf/R3CWHWSGx0YZHZsU.uKiwcnBIvfHLPVhje3pDOB7UX7Ut19/2',true);

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
    username varchar(50) NOT NULL REFERENCES users(username),
    authority varchar(50) NOT NULL,
    UNIQUE (username, authority)
    );

--
-- Inserting data for table `authorities`
--

INSERT INTO authorities
VALUES
    ('john','ROLE_EMPLOYEE'),
    ('mary','ROLE_EMPLOYEE'),
    ('mary','ROLE_MANAGER'),
    ('susan','ROLE_EMPLOYEE'),
    ('susan','ROLE_ADMIN');
