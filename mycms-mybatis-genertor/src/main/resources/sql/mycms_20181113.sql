/*
MySQL Backup
Source Server Version: 5.5.56
Source Database: mycms
Date: 2018/11/13 20:01:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `core_dept`
-- ----------------------------
DROP TABLE IF EXISTS `core_dept`;
CREATE TABLE `core_dept` (
  `core_dept_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_core_dept_id` bigint(20) DEFAULT NULL,
  `dept_name` varchar(100) DEFAULT NULL,
  `dept_code` varchar(100) DEFAULT NULL,
  `dept_desc` varchar(500) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`core_dept_id`),
  KEY `fk_parent_core_dept_id` (`parent_core_dept_id`),
  CONSTRAINT `fk_parent_core_dept_id` FOREIGN KEY (`parent_core_dept_id`) REFERENCES `core_dept` (`core_dept_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_menu`
-- ----------------------------
DROP TABLE IF EXISTS `core_menu`;
CREATE TABLE `core_menu` (
  `core_menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_type` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_core_menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`core_menu_id`),
  KEY `fk_parent_core_menu_id` (`parent_core_menu_id`),
  CONSTRAINT `fk_parent_core_menu_id` FOREIGN KEY (`parent_core_menu_id`) REFERENCES `core_menu` (`core_menu_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_role`
-- ----------------------------
DROP TABLE IF EXISTS `core_role`;
CREATE TABLE `core_role` (
  `core_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`core_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `core_role_menu`;
CREATE TABLE `core_role_menu` (
  `core_menu_id` bigint(20) NOT NULL,
  `core_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`core_menu_id`,`core_role_id`),
  KEY `fk_core_role_id_role` (`core_role_id`),
  CONSTRAINT `fk_core_role_id_role` FOREIGN KEY (`core_role_id`) REFERENCES `core_role` (`core_role_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_core_menu_id_menu` FOREIGN KEY (`core_menu_id`) REFERENCES `core_menu` (`core_menu_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_user`
-- ----------------------------
DROP TABLE IF EXISTS `core_user`;
CREATE TABLE `core_user` (
  `core_user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `core_dept_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`core_user_id`),
  KEY `fk_user_core_dept_id` (`core_dept_id`),
  CONSTRAINT `fk_user_core_dept_id` FOREIGN KEY (`core_dept_id`) REFERENCES `core_dept` (`core_dept_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `core_user_role`;
CREATE TABLE `core_user_role` (
  `core_user_id` bigint(20) NOT NULL,
  `core_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`core_user_id`,`core_role_id`),
  KEY `fk_core_role_id_role_2` (`core_role_id`),
  CONSTRAINT `fk_core_role_id_role_2` FOREIGN KEY (`core_role_id`) REFERENCES `core_role` (`core_role_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_core_user_id_user_2` FOREIGN KEY (`core_user_id`) REFERENCES `core_user` (`core_user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `core_dept` VALUES ('0',NULL,'全国',NULL,'根节点','0','0'), ('2','0','湖南省','43','','1','0'), ('5','2','长沙市','4301','','0','0'), ('6','5','望城区','430122','','8','0'), ('7','5','长沙县','430121','','0','0');
INSERT INTO `core_menu` VALUES ('0','mycms管理系统','0','',NULL,'fa fa-desktop','0',NULL), ('2','系统管理','0',NULL,NULL,'fa fa-desktop','0','0'), ('3','菜单列表','1','/manager/core/CoreMenuController/coreMenuList',NULL,'fa fa-th-list','1','2'), ('19','部门管理','1','/manager/core/CoreDeptController/coreDeptList',NULL,'fa fa-users','2','2'), ('20','用户管理','1','/manager/core/CoreUserController/coreUserList',NULL,'fa fa-user','3','2'), ('21','角色管理','1','/manager/core/CoreRoleController/coreRoleList',NULL,'fa fa-check','4','2');
INSERT INTO `core_role` VALUES ('1','超级管理员','super_admin','2018-11-08 22:19:54','2018-11-08 22:19:54');
INSERT INTO `core_role_menu` VALUES ('2','1'), ('3','1'), ('19','1'), ('20','1'), ('21','1');
INSERT INTO `core_user` VALUES ('1','superadmin','123456','超级管理员','sex.1','2018-10-31','13322221111','11@163.com',NULL,'1','6','2018-11-10 14:27:38','2018-11-10 14:27:38');
INSERT INTO `core_user_role` VALUES ('1','1');
