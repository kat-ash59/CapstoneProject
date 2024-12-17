-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema smoochyzoo
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `smoochyzoo` ;

-- -----------------------------------------------------
-- Schema smoochyzoo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `smoochyzoo` DEFAULT CHARACTER SET utf8 ;
USE `smoochyzoo` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `zipcode` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `about_me` TEXT NULL,
  `privacy_check` TINYINT NULL DEFAULT 1,
  `address_id` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  INDEX `fk_user_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role` ;

CREATE TABLE IF NOT EXISTS `role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `species` ;

CREATE TABLE IF NOT EXISTS `species` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `adopted_information` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `animal` ;

CREATE TABLE IF NOT EXISTS `animal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `birthday` DATETIME NULL,
  `category_id` INT NOT NULL,
  `species_id` INT NOT NULL,
  `mom_id` INT NULL,
  `dad_id` INT NULL,
  `gender` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_animal_category1_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_animal_species1_idx` (`species_id` ASC) VISIBLE,
  INDEX `fk_animal_animal1_idx` (`mom_id` ASC) VISIBLE,
  INDEX `fk_animal_animal2_idx` (`dad_id` ASC) VISIBLE,
  CONSTRAINT `fk_animal_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_species1`
    FOREIGN KEY (`species_id`)
    REFERENCES `species` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_animal1`
    FOREIGN KEY (`mom_id`)
    REFERENCES `animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_animal2`
    FOREIGN KEY (`dad_id`)
    REFERENCES `animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pregnancy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pregnancy` ;

CREATE TABLE IF NOT EXISTS `pregnancy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `expected_arrival` DATE NOT NULL,
  `number_of_offspring_expected` INT NOT NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zoo` ;

CREATE TABLE IF NOT EXISTS `zoo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `about` TEXT NULL,
  `address_id` INT NOT NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_zoo_address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_zoo_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `role_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `role_has_user` ;

CREATE TABLE IF NOT EXISTS `role_has_user` (
  `role_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`),
  INDEX `fk_role_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_role_has_user_role1_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_has_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `animal_pregnancy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `animal_pregnancy` ;

CREATE TABLE IF NOT EXISTS `animal_pregnancy` (
  `pregnancy_id` INT NOT NULL,
  `animal_id` INT NOT NULL,
  PRIMARY KEY (`pregnancy_id`, `animal_id`),
  INDEX `fk_pregnancy_has_animal_animal1_idx` (`animal_id` ASC) VISIBLE,
  INDEX `fk_pregnancy_has_animal_pregnancy1_idx` (`pregnancy_id` ASC) VISIBLE,
  CONSTRAINT `fk_pregnancy_has_animal_pregnancy1`
    FOREIGN KEY (`pregnancy_id`)
    REFERENCES `pregnancy` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pregnancy_has_animal_animal1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suggested_name`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `suggested_name` ;

CREATE TABLE IF NOT EXISTS `suggested_name` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_animal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_animal` ;

CREATE TABLE IF NOT EXISTS `user_has_animal` (
  `user_id` INT NOT NULL,
  `animal_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `animal_id`),
  INDEX `fk_user_has_animal_animal1_idx` (`animal_id` ASC) VISIBLE,
  INDEX `fk_user_has_animal_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_animal_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_animal_animal1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NULL,
  `event_date` DATETIME NOT NULL,
  `animal_id` INT NULL,
  `zoo_id` INT NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_event_animal1_idx` (`animal_id` ASC) VISIBLE,
  INDEX `fk_event_zoo1_idx` (`zoo_id` ASC) VISIBLE,
  CONSTRAINT `fk_event_animal1`
    FOREIGN KEY (`animal_id`)
    REFERENCES `animal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_zoo1`
    FOREIGN KEY (`zoo_id`)
    REFERENCES `zoo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suggested_name_for_species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `suggested_name_for_species` ;

CREATE TABLE IF NOT EXISTS `suggested_name_for_species` (
  `suggested_name_id` INT NOT NULL,
  `species_id` INT NOT NULL,
  PRIMARY KEY (`suggested_name_id`, `species_id`),
  INDEX `fk_suggested_name_has_species_species1_idx` (`species_id` ASC) VISIBLE,
  INDEX `fk_suggested_name_has_species_suggested_name1_idx` (`suggested_name_id` ASC) VISIBLE,
  CONSTRAINT `fk_suggested_name_has_species_suggested_name1`
    FOREIGN KEY (`suggested_name_id`)
    REFERENCES `suggested_name` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suggested_name_has_species_species1`
    FOREIGN KEY (`species_id`)
    REFERENCES `species` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zoo_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zoo_has_user` ;

CREATE TABLE IF NOT EXISTS `zoo_has_user` (
  `zoo_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`zoo_id`, `user_id`),
  INDEX `fk_zoo_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_zoo_has_user_zoo1_idx` (`zoo_id` ASC) VISIBLE,
  CONSTRAINT `fk_zoo_has_user_zoo1`
    FOREIGN KEY (`zoo_id`)
    REFERENCES `zoo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_zoo_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `adoption_duration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `adoption_duration` ;

CREATE TABLE IF NOT EXISTS `adoption_duration` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `duration` VARCHAR(45) NOT NULL,
  `isActive` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `species_has_adoption_duration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `species_has_adoption_duration` ;

CREATE TABLE IF NOT EXISTS `species_has_adoption_duration` (
  `species_id` INT NOT NULL,
  `adoption_duration_id` INT NOT NULL,
  `cost` DOUBLE(6,2) NULL,
  PRIMARY KEY (`species_id`, `adoption_duration_id`),
  INDEX `fk_species_has_adoption_duration_adoption_duration1_idx` (`adoption_duration_id` ASC) VISIBLE,
  INDEX `fk_species_has_adoption_duration_species1_idx` (`species_id` ASC) VISIBLE,
  CONSTRAINT `fk_species_has_adoption_duration_species1`
    FOREIGN KEY (`species_id`)
    REFERENCES `species` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_species_has_adoption_duration_adoption_duration1`
    FOREIGN KEY (`adoption_duration_id`)
    REFERENCES `adoption_duration` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS student@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'student'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zipcode`, `phone_number`, `isActive`) VALUES (1, '121 Main Street', 'Denver', 'Colorado', '80120', '555-334-1212', NULL);
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zipcode`, `phone_number`, `isActive`) VALUES (2, '3807 Broad Street', 'Littleton', 'Colorado', '87903', '444-748-0989', NULL);
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zipcode`, `phone_number`, `isActive`) VALUES (3, '234 Rocky Road', 'Monument', 'Colorado', '86589', '222-987-5642', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `about_me`, `privacy_check`, `address_id`, `email`, `isActive`) VALUES (1, 'keeper', 'password', true, NULL, 0, 2, 'zookeeper@smoochyzoo.com', NULL);
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `about_me`, `privacy_check`, `address_id`, `email`, `isActive`) VALUES (2, 'member', 'password', true, NULL, 0, 3, 'member@smoochyzoo.com', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `role`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `role` (`id`, `name`, `isActive`) VALUES (1, 'member', NULL);
INSERT INTO `role` (`id`, `name`, `isActive`) VALUES (2, 'keeper', NULL);
INSERT INTO `role` (`id`, `name`, `isActive`) VALUES (3, 'supervisor', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `category` (`id`, `name`, `description`, `isActive`) VALUES (1, 'carnivore', NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `species`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `species` (`id`, `name`, `description`, `adopted_information`, `isActive`) VALUES (1, 'Lion', NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `animal`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `animal` (`id`, `name`, `birthday`, `category_id`, `species_id`, `mom_id`, `dad_id`, `gender`, `isActive`) VALUES (1, 'Fred', '2014-05-24', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `animal` (`id`, `name`, `birthday`, `category_id`, `species_id`, `mom_id`, `dad_id`, `gender`, `isActive`) VALUES (2, 'Wilma', '2012-12-23', 1, 1, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `pregnancy`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `pregnancy` (`id`, `expected_arrival`, `number_of_offspring_expected`, `isActive`) VALUES (1, '2025-02-01', 3, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zoo`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `zoo` (`id`, `name`, `about`, `address_id`, `isActive`) VALUES (1, 'Smoochy Zoo', 'The happy zoo of smoochy land', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `role_has_user`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `role_has_user` (`role_id`, `user_id`) VALUES (1, 1);
INSERT INTO `role_has_user` (`role_id`, `user_id`) VALUES (2, 1);
INSERT INTO `role_has_user` (`role_id`, `user_id`) VALUES (3, 1);
INSERT INTO `role_has_user` (`role_id`, `user_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `animal_pregnancy`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `animal_pregnancy` (`pregnancy_id`, `animal_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `suggested_name`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `suggested_name` (`id`, `name`, `isActive`) VALUES (1, 'Bob', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_has_animal`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `user_has_animal` (`user_id`, `animal_id`) VALUES (1, 1);
INSERT INTO `user_has_animal` (`user_id`, `animal_id`) VALUES (2, 1);
INSERT INTO `user_has_animal` (`user_id`, `animal_id`) VALUES (2, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `event` (`id`, `name`, `description`, `event_date`, `animal_id`, `zoo_id`, `isActive`) VALUES (1, 'Fred\'s Birthday Celebration', NULL, '2024-12-25', 1, 1, NULL);
INSERT INTO `event` (`id`, `name`, `description`, `event_date`, `animal_id`, `zoo_id`, `isActive`) VALUES (2, 'Smoochy\'s Zoo Anniversary ', NULL, '2025-01-01', NULL, 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `suggested_name_for_species`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `suggested_name_for_species` (`suggested_name_id`, `species_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zoo_has_user`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `zoo_has_user` (`zoo_id`, `user_id`) VALUES (1, 1);
INSERT INTO `zoo_has_user` (`zoo_id`, `user_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `adoption_duration`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `adoption_duration` (`id`, `duration`, `isActive`) VALUES (1, 'Month', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `species_has_adoption_duration`
-- -----------------------------------------------------
START TRANSACTION;
USE `smoochyzoo`;
INSERT INTO `species_has_adoption_duration` (`species_id`, `adoption_duration_id`, `cost`) VALUES (1, 1, 100);

COMMIT;

