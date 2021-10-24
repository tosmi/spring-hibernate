DROP SCHEMA IF EXISTS "hb-01-one-to-one-uni" cascade;

CREATE SCHEMA "hb-01-one-to-one-uni";

set search_path to "hb-01-one-to-one-uni", public;

DROP TABLE IF EXISTS "instructor_detail" cascade ;

CREATE TABLE instructor_detail (
  id serial,
  youtube_channel varchar(128) DEFAULT NULL,
  hobby varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "instructor";

CREATE TABLE instructor (
  id serial,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  instructor_detail_id int references instructor_detail(id)
);


