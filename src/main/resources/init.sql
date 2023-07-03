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
`photo` BLOB
);

CREATE TABLE teacher_subject (
`id` INTEGER AUTO_INCREMENT,
`teacher_id` INTEGER NOT NULL,
`subject_id` INTEGER NOT NULL,
PRIMARY KEY (`teacher_id`, `subject_id`)
);