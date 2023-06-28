DROP DATABASE IF EXISTS `extra`;

CREATE DATABASE `extra` DEFAULT CHARACTER SET utf8;

USE `extra`;

CREATE TABLE `subjectName` (
    `subject_id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(500) NOT NULL,
    `hours` TINYINT NOT NULL,
    `free` BOOLEAN NOT NULL,
    CONSTRAINT name_length CHECK (LENGTH(name) > 2)
)