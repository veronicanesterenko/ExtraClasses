DROP
DATABASE IF EXISTS `extra`;
CREATE
DATABASE `extra` DEFAULT CHARACTER SET utf8;

USE `extra`;
CREATE TABLE `subject`
(
    `subject_id`  INT AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(50)  NOT NULL,
    `description` VARCHAR(5000) NOT NULL,
    `hours`       INT      NOT NULL,
    `free`        BOOLEAN      NOT NULL,
    CONSTRAINT name_length CHECK (LENGTH(name) > 2)
);
CREATE TABLE `teacher`
(
    `teacher_id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR (50) NOT NULL,
    `name` VARCHAR (50) NOT NULL,
    `last_name` VARCHAR (50) NOT NULL,
    `photo` BLOB
);
CREATE TABLE `teacher_subject`
(
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `teacher_id` INTEGER NOT NULL ,
    `subject_id` INTEGER NOT NULL,
    UNIQUE(`teacher_id`,`subject_id`)
    );


