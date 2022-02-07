DROP SCHEMA IF EXISTS "hb_03_one_to_many" cascade;

CREATE SCHEMA "hb_03_one_to_many";

set search_path to "hb_03_one_to_many", public;

DROP TABLE IF EXISTS "instructor_detail" cascade ;

CREATE TABLE instructor_detail (
  id serial primary key ,
  youtube_channel varchar(128) DEFAULT NULL,
  hobby varchar(45) DEFAULT NULL
);

DROP TABLE IF EXISTS "instructor";

CREATE TABLE instructor (
  id serial primary key,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  instructor_detail_id int references instructor_detail(id)
);

CREATE TABLE course (
    id serial primary key ,
    title varchar(128) DEFAULT NULL UNIQUE,
    instructor_id int references instructor(id)
);


