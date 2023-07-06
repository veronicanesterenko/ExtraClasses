DROP
    DATABASE IF EXISTS `shop`;
CREATE
    DATABASE `shop` DEFAULT CHARACTER SET utf8;

USE
    `shop`;
CREATE TABLE `category`
(
    `id`  INTEGER AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(50)  NOT NULL,
    `discount` TINYINT NOT NULL,
    `alias_name`  VARCHAR(50)      NOT NULL,
       CONSTRAINT name_length CHECK (LENGTH(name) > 2)
)