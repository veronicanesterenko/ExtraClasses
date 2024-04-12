DROP
DATABASE IF EXISTS `extra`;
CREATE
DATABASE `extra` DEFAULT CHARACTER SET utf8;

USE
`extra`;
CREATE TABLE `subject`
(
    `subject_id`  INT AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(50)   NOT NULL,
    `description` VARCHAR(5000) NOT NULL,
    `hours`       INT           NOT NULL,
    `free`        BOOLEAN       NOT NULL,
    CONSTRAINT name_length CHECK (LENGTH(name) > 2)
);
CREATE TABLE `teacher`
(
    `teacher_id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50) NOT NULL,
    `name`       VARCHAR(50) NOT NULL,
    `last_name`  VARCHAR(50) NOT NULL,
    `photo`      LONGBLOB
);
CREATE TABLE `teacher_subject`
(
    `id`         INTEGER AUTO_INCREMENT PRIMARY KEY,
    `teacher_id` INTEGER NOT NULL,
    `subject_id` INTEGER NOT NULL,
    UNIQUE (`teacher_id`, `subject_id`)
);
CREATE TABLE `user`
(

    id         INT         NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    login      VARCHAR(50) NOT NULL,
    photo      BLOB,
    PRIMARY KEY (id, login)
);
INSERT INTO `extra`.`subject` (`name`, `description`, `hours`, `free`)
VALUES ('Math', 'Mathematics is an area of knowledge ' ||
                'that includes the topics of numbers, ' ||
                'formulas and related structures, ' ||
                'shapes and the spaces in which they are ' ||
                'contained, and quantities and their changes. These topics are represented in modern mathematics with the major' ||
                ' subdisciplines of number theory, algebra, geometry, and analysis, respectively. ' ||
                'There is no general consensus among mathematicians about a common definition for their academic discipline.',
        '100', '0');
INSERT INTO `extra`.`subject` (`name`, `description`, `hours`, `free`)
VALUES ('Biology', 'Biology is the scientific study of life.' ||
                   ' It is a natural science with a broad scope but ' ||
                   'has several unifying themes that tie it together as a ' ||
                   'single, coherent field. For instance, all organisms are ' ||
                   'made up of cells that process hereditary information ' ||
                   'encoded in genes, which can be transmitted to future ' ||
                   'generations.' ||
                   ' Another major theme is evolution, which explains the unity and diversity of life.', '80', '0');
INSERT INTO `extra`.`subject` (`name`, `description`, `hours`, `free`)
VALUES ('Psychology', 'Psychology is the study of mind and behavior in humans and non-humans. ' ||
                      'Psychology includes the study of conscious and unconscious phenomena, including feelings and thoughts. ' ||
                      'It is an academic discipline of immense scope, crossing the boundaries between the natural and social sciences. ' ||
                      'Psychologists seek an understanding of the emergent properties of brains, linking the discipline to neuroscience. ' ||
                      'As social scientists, psychologists aim to understand the behavior of individuals and groups.',
        '100', '1');
INSERT INTO `extra`.`subject` (`name`, `description`, `hours`, `free`)
VALUES ('English', 'English is a West Germanic language in the Indo-European language family,' ||
                   ' with its earliest forms spoken by the inhabitants of early medieval England. ' ||
                   'It is named after the Angles, one of the ancient Germanic peoples that migrated ' ||
                   'to the island of Great Britain.',
        '120', '1');


create table if not exists subjects_teachers
(
    id int not null unique auto_increment,
    subject_id int not null,
    teacher_id int not null,
    foreign key (subject_id) references subject(subject_id),
    foreign key (teacher_id) references user(id),
    primary key (subject_id,teacher_id)

    );

create table if not exists subjects_students
(
    id int not null unique auto_increment,
    subject_id int not null,
    student_id int not null,
    foreign key (subject_id) references subject(subject_id),
    foreign key (student_id) references user(id),
    primary key (subject_id,student_id)

    );
