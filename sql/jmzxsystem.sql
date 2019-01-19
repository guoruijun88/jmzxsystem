/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.18 : Database - jmzxsystem
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jmzxsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jmzxsystem`;

/*Table structure for table `clients` */

DROP TABLE IF EXISTS `clients`;

CREATE TABLE `clients` (
  `clientid` varchar(40) NOT NULL,
  `clientname` varchar(40) NOT NULL,
  `csex` varchar(2) NOT NULL,
  `caddress` varchar(100) NOT NULL,
  `profession` varchar(100) NOT NULL,
  `clientphone` varchar(20) NOT NULL,
  `clientpwd` varchar(20) NOT NULL,
  PRIMARY KEY (`clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `clients` */

insert  into `clients`(`clientid`,`clientname`,`csex`,`caddress`,`profession`,`clientphone`,`clientpwd`) values ('140322198805217534','郭瑞军','M','中国山西阳泉','自由人','13720975543','123'),('140322198805217566','李开复','M','北京','CEO','18888888888','123'),('140322198805217569','张朝阳','M','北京','售后CEO','1232344567774','123'),('140322198805217599','李彦宏','M','北京','百度CEO','19999999999','123');

/*Table structure for table `funs` */

DROP TABLE IF EXISTS `funs`;

CREATE TABLE `funs` (
  `funid` int(11) NOT NULL,
  `menuid` int(11) DEFAULT NULL,
  `funname` varchar(50) NOT NULL,
  `funurl` varchar(50) NOT NULL,
  PRIMARY KEY (`funid`),
  KEY `FK_menus_funs_fk` (`menuid`),
  CONSTRAINT `FK_menus_funs_fk` FOREIGN KEY (`menuid`) REFERENCES `menus` (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `funs` */

insert  into `funs`(`funid`,`menuid`,`funname`,`funurl`) values (1,1,'首页面','index.jsp'),(2,1,'头页面','head.jsp'),(3,1,'菜单页面','menu.jsp'),(4,1,'操作页面','body.jsp'),(5,1,'底页面','footer.jsp'),(6,1,'成功页面','ok.jsp'),(7,1,'错误页面','error.jsp'),(100,3,'添加用户页面','addUser.jsp'),(101,3,'添加用户动作','addUser.do'),(102,3,'查询所有角色动作','findAllRoles.do'),(200,4,'查询所有用户页面','findAllUsers.jsp'),(201,4,'查询所有用户动作','findAllUsers.do'),(202,4,'显示用户页面','showUsers.jsp'),(203,4,'预更新新用户动作','preUpdateUser.do'),(204,4,'更新用户页面','updateUser.jsp'),(205,4,'更新用户动作','updateUser.do'),(206,4,'删除用户动作','deleteUser.do'),(207,4,'查询所有角色','findRolesAll.do'),(208,4,'查询用户动作','findUsersByProperty.do'),(301,6,'添加客户页面','addClient.jsp'),(302,6,'添加客户动作','addClient.do'),(401,7,'查询客户页面','findClients.jsp'),(402,7,'查询客户动作页面','findClients.do'),(403,7,'显示客户页面','showClients.jsp'),(404,7,'根据属性查询客户动作','findClientByProperty.do'),(405,7,'预更新客户动作','preUpdateClient.do'),(406,7,'预更新用户页面','updateClients.jsp'),(501,9,'添加汽车页面','addCar.jsp'),(502,9,'添加汽车动作','addCar.do'),(601,10,'预查询汽车页面','findCar.jsp'),(602,10,'查询汽车动作','findCarByProperty.do'),(603,10,'显示汽车页面','showCar.jsp'),(604,10,'预更新汽车动作','preUpdateCar.do'),(605,10,'预更新汽车页面','updateCar.jsp'),(606,10,'预更新图片动作','changeCarPicture.do'),(607,10,'删除汽车动作','deleteCar.do'),(608,10,'更新汽车动作','updateCar.do'),(701,12,'预查询客户页面','findRentClient.jsp'),(702,12,'查询可出租车辆动作','findRentCar.do'),(703,12,'显示可出租车辆页面','showRentCars.jsp'),(704,12,'查询客户动作','findRentClient.do'),(705,12,'查询可出租车辆动作','findNoRentCar.do'),(706,12,'显示订单页面','showOrder.jsp'),(707,12,'获取出租车辆动作','findTheRentCar.do'),(708,12,'添加订单','saveOrder.do'),(801,13,'汽车入库查询订单页面','findTheOrder.jsp'),(802,13,'查询订单是否存在动作','findTheOrder.do'),(803,13,'显示检查单页面','showCheckTheCar.jsp'),(804,13,'根据订单查询相关信息动作','checkCarByOrder.do'),(805,13,'保存检查单，更新相应的信息','saveCheckTable.do');

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `menuid` int(11) NOT NULL,
  `menuname` varchar(40) NOT NULL,
  `menuurl` varchar(40) DEFAULT NULL,
  `fatherid` int(11) NOT NULL,
  `icon` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menus` */

insert  into `menus`(`menuid`,`menuname`,`menuurl`,`fatherid`,`icon`) values (1,'首页','',-1,''),(2,'用户管理',NULL,0,'fa fa-home'),(3,'添加用户','user/addUser',2,NULL),(4,'查询用户','findRolesAll.do',2,NULL),(5,'客户管理',NULL,0,'fa fa-edit'),(6,'添加客户','/clients/addClient.jsp',5,NULL),(7,'查询客户','/clients/findClients.jsp',5,NULL),(8,'汽车管理',NULL,0,'fa fa-desktop'),(9,'添加汽车信息','/cars/addCar.jsp',8,NULL),(10,'查询汽车信息','/cars/findCar.jsp',8,NULL),(11,'业务管理',NULL,0,'fa fa-home'),(12,'汽车出租','/orders/findRentClient.jsp',11,NULL),(13,'汽车入库','/orders/findTheOrder.jsp',11,NULL),(14,'出租单管理',NULL,11,NULL),(15,'检查单管理',NULL,11,NULL),(16,'业务统计',NULL,0,'fa fa-table'),(17,'单月应还汽车',NULL,16,NULL),(18,'系统管理',NULL,0,'fa fa-table'),(19,'角色管理',NULL,18,NULL),(20,'日志管理',NULL,18,NULL),(21,'登录信息管理',NULL,18,NULL);

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(20) NOT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles` */

insert  into `roles`(`roleid`,`rolename`) values (1,' 管理员'),(2,'普通用户');

/*Table structure for table `roles_menus_fk` */

DROP TABLE IF EXISTS `roles_menus_fk`;

CREATE TABLE `roles_menus_fk` (
  `roleid` int(11) NOT NULL,
  `menuid` int(11) NOT NULL,
  PRIMARY KEY (`roleid`,`menuid`),
  KEY `FK_roles_menus_fk2` (`menuid`),
  CONSTRAINT `FK_roles_menus_fk` FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`),
  CONSTRAINT `FK_roles_menus_fk2` FOREIGN KEY (`menuid`) REFERENCES `menus` (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `roles_menus_fk` */

insert  into `roles_menus_fk`(`roleid`,`menuid`) values (1,1),(1,2),(1,3),(1,4),(1,5),(2,5),(1,6),(2,6),(1,7),(2,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(40) NOT NULL,
  `roleid` int(11) DEFAULT NULL,
  `uid` varchar(20) NOT NULL,
  `realname` varchar(40) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `position` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `userpwd` varchar(20) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `FK_users_roles_fk` (`roleid`),
  CONSTRAINT `FK_users_roles_fk` FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`username`,`roleid`,`uid`,`realname`,`sex`,`position`,`address`,`phone`,`userpwd`) values ('admin',1,'140322198805217533','郭瑞军','M','经理','山西阳泉','13720975543','admin'),('sky',1,'140322198805234533','梁朝伟','M','总经理','山西太原','18735422456','123'),('snow',2,'140322199003021226','雪儿','F','职员','山西阳泉','15678384933','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
