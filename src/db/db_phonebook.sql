CREATE DATABASE IF NOT EXISTS db_phonebook;
USE db_phonebook;

CREATE TABLE IF NOT EXISTS users(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
lastname VARCHAR(20) NOT NULL,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
birthday DATE NOT NULL,
phone BIGINT NOT NULL,
gender CHAR NOT NULL);

INSERT INTO users
(lastname, name, surname, birthday, phone, gender)
VALUES
('Петров', 'Степан', 'Игоривич', '20.03.2021', 89139437823, 'm');

