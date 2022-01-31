DROP DATABASE IF EXISTS "web_customer_tracker";
DROP ROLE "springstudent";

CREATE DATABASE "web_customer_tracker";

CREATE USER springstudent WITH PASSWORD 'springstudent';
GRANT CONNECT ON DATABASE web_customer_tracker TO springstudent;
GRANT ALL PRIVILEGES ON DATABASE web_customer_tracker to springstudent;


