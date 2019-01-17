/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : jmzxsystem

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-01-16 02:35:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for funs
-- ----------------------------
DROP TABLE IF EXISTS `funs`;
CREATE TABLE `funs` (
  `funId` int(11) NOT NULL,
  `menuId` int(11) DEFAULT NULL,
  `funName` varchar(50) NOT NULL,
  `funUrl` varchar(50) NOT NULL,
  PRIMARY KEY (`funId`),
  UNIQUE KEY `funs_PK` (`funId`),
  KEY `menus_funs_fk_FK` (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of funs
-- ----------------------------
INSERT INTO `funs` VALUES ('1', '1', '首页', 'main.jsp');
INSERT INTO `funs` VALUES ('2', '1', '头页面', 'top.jsp');
INSERT INTO `funs` VALUES ('3', '1', '菜单页面', 'menu.jsp');
INSERT INTO `funs` VALUES ('4', '1', '操作页面', 'body.jsp');
INSERT INTO `funs` VALUES ('5', '1', '底页面', 'foot.jsp');
INSERT INTO `funs` VALUES ('6', '1', '成功页面', 'ok.jsp');
INSERT INTO `funs` VALUES ('7', '1', '错误页面', 'error.jsp');
INSERT INTO `funs` VALUES ('100', '3', '添加用户页面', 'addUser.jsp');
INSERT INTO `funs` VALUES ('101', '3', '添加用户动作', 'addUser.do');
INSERT INTO `funs` VALUES ('102', '4', '查询用户页面', 'listUser.jsp');
INSERT INTO `funs` VALUES ('103', '4', '查询用户动作', 'listUser.do');

-- ----------------------------
-- Table structure for menus
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `menuId` int(11) NOT NULL,
  `fatherId` int(11) NOT NULL,
  `menuName` varchar(40) NOT NULL,
  `menuUrl` varchar(40) DEFAULT NULL,
  `iconCls` varchar(40) DEFAULT NULL,
  `isParent` int(11) NOT NULL,
  PRIMARY KEY (`menuId`),
  UNIQUE KEY `menus_PK` (`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '-1', '聚美装修', '', null, '1');
INSERT INTO `menus` VALUES ('2', '1', '用户管理', null, null, '1');
INSERT INTO `menus` VALUES ('3', '2', '添加用户', null, null, '0');
INSERT INTO `menus` VALUES ('4', '2', '查询用户', null, null, '0');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(20) NOT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roles_PK` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '管理员', '1000');
INSERT INTO `roles` VALUES ('2', '普通用户', '500');

-- ----------------------------
-- Table structure for roles_menus_fk
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus_fk`;
CREATE TABLE `roles_menus_fk` (
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`,`menuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_menus_fk
-- ----------------------------
INSERT INTO `roles_menus_fk` VALUES ('1', '1');
INSERT INTO `roles_menus_fk` VALUES ('1', '2');
INSERT INTO `roles_menus_fk` VALUES ('1', '3');
INSERT INTO `roles_menus_fk` VALUES ('1', '4');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `roleId` int(11) DEFAULT NULL,
  `username` varchar(40) NOT NULL,
  `userpwd` varchar(30) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `realname` varchar(40) NOT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `userDescribe` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Users_PK` (`id`),
  KEY `users_roles_fk_FK` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1', 'admin', 'admin', '1111', '郭瑞军', '1', '1', null);
