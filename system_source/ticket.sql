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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `car` */

insert  into `car`(`id`,`carName`,`carCard`,`buyTime`,`seatNum`,`carTypeId`,`status`) values (5,'金龙客车','皖H33333','2017-02-19 16:34:05',35,2,1),(6,'五菱宏光','皖H99999','2017-02-12 14:38:25',9,4,1),(7,'上海通用','皖H88888','2017-02-12 14:57:56',35,6,1),(8,'宇通客车','皖H11111','2017-02-19 16:07:08',45,6,1),(9,'金龙大巴','皖H33333','2017-02-19 16:29:23',43,6,1),(10,'五菱至上','皖H09090','2017-02-19 16:59:25',13,4,1),(11,'测试2','皖H09090','2017-02-12 21:34:29',22,2,1),(12,'测试1','皖H09090','2017-02-19 16:28:48',33,2,1),(13,'测试2','皖H09090','2017-02-12 21:35:32',45,4,1),(14,'测试4','皖H09090','2017-02-12 21:35:07',33,2,1),(15,'测试5','皖H09090','2017-02-19 20:38:33',23,2,1),(16,'测试2','皖H33333','2017-02-19 16:31:42',34,4,1);

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

insert  into `driver`(`id`,`drivername`,`age`,`identitycard`,`phone`,`sex`,`status`) values (2,'唐火松',24,'340826199309103451','18949344290','男',1),(4,'夏磊',33,'888888889999999999','18949344290','男',1),(5,'段少强',33,'888888888888888888','13455556666','男',1),(6,'吴晗',24,'888888888888888888','18949344290','男',1),(7,'张宇',23,'340813199409091111','13455556666','男',1),(8,'张宇',34,'340813199409091111','13455556666','男',1),(9,'测试一',32,'340813199409091111','18949344290','男',1),(10,'测试2',22,'123456789009876543','13288889999','男',1),(11,'测试3',33,'123456789009876543','13455556666','男',1),(12,'测试4',23,'123456789009876543','18949344290','男',1),(13,'测试4',32,'123456789009876543','18949344290','男',1),(14,'测试2',32,'123456789009876543','13455556666','男',1);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(16) NOT NULL,
  `permission` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`id`,`email`,`password`,`permission`) values (1,'ths930910@163.com','123456',1);

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `order` */

insert  into `order`(`id`,`userid`,`routeid`,`status`,`createtime`,`updatetime`,`ticketnum`) values (1,1,34,0,'2017-02-19 13:28:54','2017-02-19 13:28:54',1),(2,1,23,2,'2017-02-19 13:35:22','2017-02-19 15:50:05',1),(4,1,22,0,'2017-02-19 15:51:33','2017-02-19 15:51:33',1),(5,1,34,0,'2017-02-19 15:52:04','2017-02-19 15:52:04',1),(6,1,34,0,'2017-02-19 15:57:07','2017-02-19 15:57:07',1),(7,1,21,0,'2017-02-19 16:07:08','2017-02-19 16:07:08',1),(8,1,34,0,'2017-02-19 16:28:46','2017-02-19 16:28:46',1),(9,1,30,0,'2017-02-19 16:28:48','2017-02-19 16:28:48',1),(14,1,22,0,'2017-02-19 16:28:54','2017-02-19 16:28:54',1),(17,1,22,0,'2017-02-19 16:29:15','2017-02-19 16:29:15',1),(18,1,34,0,'2017-02-19 16:29:17','2017-02-19 16:29:17',1),(19,1,34,0,'2017-02-19 16:29:19','2017-02-19 16:29:19',1),(20,1,20,0,'2017-02-19 16:29:23','2017-02-19 16:29:23',1),(21,1,1,0,'2017-02-19 16:29:25','2017-02-19 16:29:25',1),(25,1,34,0,'2017-02-19 16:31:42','2017-02-19 16:31:42',1),(26,1,22,0,'2017-02-19 16:33:20','2017-02-19 16:33:20',1),(27,1,1,0,'2017-02-19 16:34:03','2017-02-19 16:34:03',1),(28,1,1,0,'2017-02-19 16:34:05','2017-02-19 16:34:05',1),(30,1,22,0,'2017-02-19 16:59:25','2017-02-19 16:59:25',1),(31,1,32,0,'2017-02-19 20:38:33','2017-02-19 20:38:33',1);

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

insert  into `route`(`id`,`addressid`,`starttime`,`carid`,`driverid`,`price`,`sold`) values (1,2,'02:00:00',5,6,134,0),(20,4,'02:00:00',9,4,220,0),(21,3,'08:00:00',8,5,111,0),(22,2,'08:00:00',10,2,166,9),(23,2,'08:00:00',6,7,4566,9),(28,2,'08:00:00',7,8,45,35),(29,2,'08:00:00',11,10,45,22),(30,4,'08:00:00',12,11,43,32),(31,2,'08:00:00',14,12,45,33),(32,2,'08:00:00',15,13,45,22),(33,2,'08:00:00',13,14,44,45),(34,2,'08:00:00',16,9,67,29);

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

insert  into `user`(`id`,`name`,`sex`,`password`,`idcard`,`email`,`phone`,`status`) values (1,'唐火松','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(2,'张宇','女','123456','340822222222222222','ffdfdfdfd@qq.com','18949344290',1),(3,'唐火松','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(18,'唐火松3','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(19,'唐火松33','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(20,'唐火松333','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(21,'唐火松4','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(22,'唐火松ds','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(23,'唐火松ss','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(24,'唐火松dsd','男','123456','340826199309103451','ths930910@163.com','18949344290',1),(25,'唐火松ew','男','123456','340826199309103451','ths930910@163.com','18949344290',1);

/* Trigger structure for table `order` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `sub_route_seatNum` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `sub_route_seatNum` AFTER INSERT ON `order` FOR EACH ROW BEGIN
	UPDATE route SET route.`sold`=route.`sold`-1 WHERE route.`id`= new.routeid;
    END */$$


DELIMITER ;

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
