DROP SCHEMA IF EXISTS spring_security_demo_plaintext CASCADE;

CREATE SCHEMA IF NOT EXISTS spring_security_demo_plaintext;

SET search_path TO "spring_security_demo_plaintext", PUBLIC;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    username varchar(50) NOT NULL PRIMARY KEY,
    password varchar(50) NOT NULL,
    enabled boolean
);

--
-- Inserting data for table `users`
--

INSERT INTO users
VALUES
    ('john','{noop}test123',true),
    ('mary','{noop}test123',true),
    ('susan','{noop}test123',true);

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
