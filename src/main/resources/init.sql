DROP DATABASE IF EXISTS `extra`;

CREATE DATABASE `extra` DEFAULT CHARACTER SET utf8;

USE `extra`;

CREATE TABLE `subject` (
    `subject_id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(5000) NOT NULL,
    `hours` INT NOT NULL,
    `free` BOOLEAN NOT NULL,
    CONSTRAINT name_length CHECK (LENGTH(name) > 2)
);

CREATE TABLE `teacher` (
`teacher_id` INTEGER AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR (50),
`middle_name` VARCHAR (50),
`bio` varchar(10000),
`last_name` VARCHAR (50),
`photo` LONGBLOB
);

CREATE TABLE `teacher_subject` (
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `teacher_id` INTEGER NOT NULL,
    `subject_id` INTEGER NOT NULL,
    UNIQUE (`teacher_id` , `subject_id`)
);

create table `user` (
id int auto_increment,
first_name varchar(50) not null,
last_name  varchar(50) not null,
login varchar(50),
role varchar (15),
photo blob,
primary key (id, login)
);

create table if not exists subjects_teacher
(
    id int not null,
    subject_id int not null,
    teacher_id int not null,
    foreign key (subject_id) references subject(subject_id),
    foreign key (teacher_id) references user(id),
    primary key (subject_id,teacher_id)
);