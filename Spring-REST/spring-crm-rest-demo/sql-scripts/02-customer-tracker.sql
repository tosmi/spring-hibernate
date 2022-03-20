DROP TABLE IF EXISTS "customer";

CREATE TABLE customer (
                          id serial PRIMARY KEY,
                          first_name varchar(45) NOT NULL,
                          last_name varchar(45) NOT NULL,
                          email varchar(45) NOT NULL
);

TRUNCATE TABLE customer;

-- Careful here, do NOT add the id to the insert statement
-- otherwise the pgsql sequence will not get incremented
-- this is not mysql, stupid
INSERT INTO
    customer(first_name, last_name, email)
VALUES
    ('David','Adams','david@luv2code.com'),
    ('John','Doe','john@luv2code.com'),
    ('Ajay','Rao','ajay@luv2code.com'),
    ('Mary','Public','mary@luv2code.com'),
    ('Maxwell','Dixon','max@luv2code.com');

