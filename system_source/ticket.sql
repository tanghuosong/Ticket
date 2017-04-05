/*
SQLyog Ultimate v11.26 (32 bit)
MySQL - 5.5.28 : Database - ticket
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ticket` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ticket`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `province` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `county` varchar(20) NOT NULL,
  `station` varchar(20) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

/*Table structure for table `car` */

DROP TABLE IF EXISTS `car`;

CREATE TABLE `car` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `carName` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `carCard` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `buyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `seatNum` int(2) unsigned NOT NULL,
  `carTypeId` int(10) unsigned NOT NULL,
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `car_ibfk_1` (`carTypeId`),
  CONSTRAINT `car_ibfk_1` FOREIGN KEY (`carTypeId`) REFERENCES `cartype` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car` */

/*Table structure for table `cartype` */

DROP TABLE IF EXISTS `cartype`;

CREATE TABLE `cartype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `typeName` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `cartype` */

insert  into `cartype`(`id`,`typeName`) values (2,'中型客车'),(4,'小型客车'),(6,'大型客车'),(7,'豪华客车');

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `drivername` varchar(20) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `identitycard` varchar(18) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `status` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `driver` */

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(16) NOT NULL,
  `permission` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`id`,`email`,`password`,`permission`) values (1,'ths930910@163.com','123456',1),(2,'admin','123456',1);

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `routeid` int(10) unsigned NOT NULL,
  `status` int(10) unsigned NOT NULL,
  `createtime` varchar(32) NOT NULL,
  `updatetime` varchar(32) NOT NULL,
  `ticketnum` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `routeid` (`routeid`),
  CONSTRAINT `routeid` FOREIGN KEY (`routeid`) REFERENCES `route` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

/*Table structure for table `route` */

DROP TABLE IF EXISTS `route`;

CREATE TABLE `route` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `addressid` int(10) unsigned NOT NULL,
  `starttime` varchar(10) NOT NULL,
  `carid` int(10) unsigned NOT NULL,
  `driverid` int(10) unsigned NOT NULL,
  `price` double NOT NULL,
  `sold` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `addressid` (`addressid`),
  KEY `carid` (`carid`),
  KEY `driverid` (`driverid`),
  CONSTRAINT `addressid` FOREIGN KEY (`addressid`) REFERENCES `address` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `carid` FOREIGN KEY (`carid`) REFERENCES `car` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `driverid` FOREIGN KEY (`driverid`) REFERENCES `driver` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `route` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(16) NOT NULL,
  `sex` varchar(4) NOT NULL,
  `password` varchar(16) NOT NULL,
  `idcard` varchar(18) NOT NULL,
  `email` varchar(32) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/* Trigger structure for table `route` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_status_insert` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_status_insert` AFTER INSERT ON `route` FOR EACH ROW BEGIN 
	UPDATE DRIVER SET driver.`status`=1 WHERE driver.`id`= new.driverid;
	UPDATE CAR SET car.`status`=1 WHERE car.`id`= new.carid;
	
    END */$$


DELIMITER ;

/* Trigger structure for table `route` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_status_update` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_status_update` AFTER UPDATE ON `route` FOR EACH ROW BEGIN
	UPDATE DRIVER SET driver.`status`=0 WHERE driver.`id`= old.driverid;
	UPDATE DRIVER SET driver.`status`=1 WHERE driver.`id`= new.driverid;
	UPDATE CAR SET car.`status`=0 WHERE car.`id`= old.carid;
	UPDATE CAR SET car.`status`=1 WHERE car.`id`= new.carid;
    END */$$


DELIMITER ;

/* Trigger structure for table `route` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `update_status_delete` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `update_status_delete` AFTER DELETE ON `route` FOR EACH ROW BEGIN 
	UPDATE DRIVER SET driver.`status`=0 WHERE driver.`id`= old.driverid;
	UPDATE CAR SET car.`status`=0 WHERE car.`id`= old.carid;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
