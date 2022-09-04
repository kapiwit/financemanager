CREATE TABLE `category` ( 
  `id` INT AUTO_INCREMENT NOT NULL,
  `category` VARCHAR(255) NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (`id`)
);
CREATE TABLE `expense` ( 
  `id` INT AUTO_INCREMENT NOT NULL,
  `amount` DECIMAL(38,2) NULL,
  `comment` VARCHAR(255) NULL,
  `expence_add_date` DATE NULL,
  `category_id` BIGINT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (`id`),
  CONSTRAINT `id_UNIQUE` UNIQUE (`id`)
);
CREATE TABLE `income` ( 
  `id` INT AUTO_INCREMENT NOT NULL,
  `amount` DECIMAL(38,2) NULL,
  `comment` VARCHAR(255) NULL,
  `income_add_date` DATE NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (`id`)
);
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO `category` (`category`) VALUES ('Dojazd');
INSERT INTO `category` (`category`) VALUES ('Zakupy');
INSERT INTO `category` (`category`) VALUES ('Raty');
INSERT INTO `category` (`category`) VALUES ('Wakacje');
INSERT INTO `category` (`category`) VALUES ('Jedzenie');
INSERT INTO `category` (`category`) VALUES ('Zajęcia');
INSERT INTO `category` (`category`) VALUES ('Uslugi');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('200.00', 'Paliwo', '2022-09-03', '1');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('700.00', 'Podróż do Wiednia', '2022-09-03', '5');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('500.00', 'Ubezpieczenie', '2022-09-03', '1');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('1000.00', 'Wyjście do klubu', '2022-09-04', '6');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('220.00', 'Paliwo', '2022-09-04', '1');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('600.00', 'COs', '2022-09-04', '2');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('5.00', '20', '2022-09-04', '2');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('60.00', 'Jablko', '2022-09-04', '6');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('40.00', 'Zabka', '2022-09-04', '2');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('500.00', 'kredyt', '2022-09-04', '4');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('200.00', 'SDA', '2022-09-04', '7');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('200.00', 'Paliwo', '2022-09-04', '1');
INSERT INTO `expense` (`amount`, `comment`, `expence_add_date`, `category_id`) VALUES ('2000.00', 'Dentysta', '2022-09-04', '8');
INSERT INTO `income` (`amount`, `comment`, `income_add_date`) VALUES ('1500.00', 'Zabka', '2022-09-03');
INSERT INTO `income` (`amount`, `comment`, `income_add_date`) VALUES ('5000.00', 'Giełda', '2022-09-04');
INSERT INTO `income` (`amount`, `comment`, `income_add_date`) VALUES ('100.00', 'Kieszonkowe', '2022-09-04');
SET FOREIGN_KEY_CHECKS = 1;
