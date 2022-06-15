DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL
);

--
-- Data for table `employee`
--
INSERT INTO employee VALUES
                         (DEFAULT,'Leslie','Andrews','leslie@luv2code.com'),
                         (DEFAULT,'Emma','Baumgarten','emma@luv2code.com'),
                         (DEFAULT,'Avani','Gupta','avani@luv2code.com'),
                         (DEFAULT,'Yuri','Petrov','yuri@luv2code.com'),
                         (DEFAULT,'Juan','Vega','juan@luv2code.com');

delete from employee where id=7;