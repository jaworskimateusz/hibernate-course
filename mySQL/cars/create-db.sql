DROP SCHEMA IF EXISTS `hb-cars-many-to-many`;

CREATE SCHEMA `hb-cars-many-to-many`;

use `hb-cars-many-to-many`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `car_performance`;

CREATE TABLE `car_performance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horsepower` int(11) DEFAULT NULL,
  `acceleration` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `body` varchar(45) DEFAULT NULL,
  `car_performance_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PERFORMANCE_idx` (`car_performance_id`),
  CONSTRAINT `FK_PERFORMANCE` FOREIGN KEY (`car_performance_id`) 
  REFERENCES `car_performance` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `rims`;

CREATE TABLE `rims` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inches` int(11) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  UNIQUE KEY `INCHES_UNIQUE` (`inches`),
  
  KEY `FK_CARS_idx` (`car_id`),
  
  CONSTRAINT `FK_CARS` 
  FOREIGN KEY (`car_id`) 
  REFERENCES `cars` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `tires`;

CREATE TABLE `tires` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(256) DEFAULT NULL,
  `rim_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_RIM_ID_idx` (`rim_id`),

  CONSTRAINT `FK_RIM` 
  FOREIGN KEY (`rim_id`) 
  REFERENCES `rims` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `car_services`;

CREATE TABLE `car_services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `service_car`;

CREATE TABLE `service_car` (
  `car_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  
  PRIMARY KEY (`car_id`,`service_id`),
  
  KEY `FK_CAR_idx` (`car_id`),
  
  CONSTRAINT `FK_SERVICE` FOREIGN KEY (`service_id`) 
  REFERENCES `car_services` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_CAR` FOREIGN KEY (`car_id`) 
  REFERENCES `cars` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
