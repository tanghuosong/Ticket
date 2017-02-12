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

insert  into `address`(`id`,`province`,`city`,`county`,`station`,`fullname`) values (2,'安徽省','蚌埠市','龙子湖区','长途汽车站','安徽省蚌埠市龙子湖区长途汽车站'),(3,'山东省','泰安市','泰山县','长途汽车站','山东省泰安市泰山县长途汽车站'),(4,'湖南省','长沙市','长沙县','客运综合站','湖南省长沙市长沙县客运综合站');

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car` */

insert  into `car`(`id`,`carName`,`carCard`,`buyTime`,`seatNum`,`carTypeId`,`status`) values (5,'金龙客车','皖H33333','2017-02-05 13:47:57',35,2,1),(6,'五菱宏光','皖H99999','2017-02-12 14:38:25',9,4,1),(7,'上海通用','皖H88888','2017-02-12 14:57:56',35,6,1),(8,'宇通客车','皖H11111','2017-02-05 00:33:57',45,6,1),(9,'金龙大巴','皖H33333','2017-02-12 14:22:30',43,6,1),(10,'五菱至上','皖H09090','2017-02-05 14:43:31',13,4,1);

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `driver` */

insert  into `driver`(`id`,`drivername`,`age`,`identitycard`,`phone`,`sex`,`status`) values (2,'唐火松',24,'340826199309103451','18949344290','男',1),(4,'夏磊',33,'888888889999999999','18949344290','男',1),(5,'段少强',33,'888888888888888888','13455556666','男',1),(6,'吴晗',24,'888888888888888888','18949344290','男',1),(7,'张宇',23,'340813199409091111','13455556666','男',1),(8,'张宇',34,'340813199409091111','13455556666','男',1);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(16) NOT NULL,
  `permission` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `routeid` int(10) unsigned NOT NULL,
  `status` int(10) unsigned NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `routeid` (`routeid`),
  CONSTRAINT `routeid` FOREIGN KEY (`routeid`) REFERENCES `route` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `route` */

insert  into `route`(`id`,`addressid`,`starttime`,`carid`,`driverid`,`price`,`sold`) values (1,2,'02:00:00',5,6,134,3),(20,4,'02:00:00',9,4,220,1),(21,3,'08:00:00',8,5,111,1),(22,2,'08:00:00',10,2,166,13),(23,2,'08:00:00',6,7,4566,9),(28,2,'08:00:00',7,8,45,35);

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`sex`,`password`,`idcard`,`email`,`phone`,`status`) values (1,'唐火松','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(2,'张宇','女','123456','340822222222222222','ffdfdfdfd@qq.com','18949344290',1);

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
