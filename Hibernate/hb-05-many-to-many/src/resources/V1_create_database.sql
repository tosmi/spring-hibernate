DROP SCHEMA IF EXISTS "hb_05_many_to_many" cascade;

CREATE SCHEMA "hb_05_many_to_many";

set search_path to "hb_05_many_to_many", public;

DROP TABLE IF EXISTS "student" cascade;

CREATE TABLE student (
  id serial primary key,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL
);

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

DROP TABLE IF EXISTS "course";

CREATE TABLE course (
    id serial primary key ,
    title varchar(128) DEFAULT NULL UNIQUE,
    instructor_id int references instructor(id)
);

DROP TABLE IF EXISTS "review";

CREATE TABLE review (
    id serial primary key,
    comment varchar(256) default null,
    course_id int references course(id)
);

DROP TABLE IF EXISTS "course_studen";

CREATE TABLE course_student (
    course_id int NOT NULL REFERENCES course(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    student_id int NOT NULL REFERENCES student(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    PRIMARY KEY (course_id, student_id)
);