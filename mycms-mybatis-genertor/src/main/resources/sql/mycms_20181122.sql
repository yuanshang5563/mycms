/*
MySQL Backup
Source Server Version: 5.5.56
Source Database: mycms
Date: 2018/11/22 23:01:52
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
--  Table structure for `core_dictionaries`
-- ----------------------------
DROP TABLE IF EXISTS `core_dictionaries`;
CREATE TABLE `core_dictionaries` (
  `core_dict_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_code` varchar(255) DEFAULT NULL,
  `dict_value` varchar(255) DEFAULT NULL,
  `core_dict_group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`core_dict_id`),
  KEY `core_dictionaries_` (`core_dict_group_id`),
  CONSTRAINT `core_dictionaries_` FOREIGN KEY (`core_dict_group_id`) REFERENCES `core_dictionaries_group` (`core_dict_group_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_dictionaries_group`
-- ----------------------------
DROP TABLE IF EXISTS `core_dictionaries_group`;
CREATE TABLE `core_dictionaries_group` (
  `core_dict_group_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dict_group_name` varchar(255) DEFAULT NULL,
  `dict_group_code` varchar(255) DEFAULT NULL,
  `dict_group_desc` varchar(255) DEFAULT NULL,
  `parent_core_dict_group_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`core_dict_group_id`),
  UNIQUE KEY `index_core_dictionaries_group_dict_group_code` (`dict_group_code`) USING BTREE,
  KEY `fk_core_dictionaries_group_parent_core_dict_group_id` (`parent_core_dict_group_id`),
  CONSTRAINT `fk_core_dictionaries_group_parent_core_dict_group_id` FOREIGN KEY (`parent_core_dict_group_id`) REFERENCES `core_dictionaries_group` (`core_dict_group_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `core_parameter`;
CREATE TABLE `core_parameter` (
  `core_param_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_name` varchar(255) DEFAULT NULL,
  `param_type` varchar(10) DEFAULT NULL,
  `param_code` varchar(255) DEFAULT NULL,
  `param_value` varchar(255) DEFAULT NULL,
  `param_desc` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`core_param_id`),
  UNIQUE KEY `index_core_parameter_param_code` (`param_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`core_role_id`),
  UNIQUE KEY `index_core_role_role` (`role`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `core_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `core_role_menu`;
CREATE TABLE `core_role_menu` (
  `core_menu_id` bigint(20) NOT NULL,
  `core_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`core_menu_id`,`core_role_id`),
  KEY `fk_core_role_id_role` (`core_role_id`),
  CONSTRAINT `fk_core_menu_id_menu` FOREIGN KEY (`core_menu_id`) REFERENCES `core_menu` (`core_menu_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_core_role_id_role` FOREIGN KEY (`core_role_id`) REFERENCES `core_role` (`core_role_id`) ON DELETE CASCADE ON UPDATE NO ACTION
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

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
INSERT INTO `core_dept` VALUES ('0',NULL,'全国',NULL,'根节点','0','0'), ('2','0','湖南省','43','根节点','1','0'), ('5','2','长沙市','4301','','0','0'), ('6','5','望城区','430122','','8','0'), ('7','5','长沙县','430121','','0','0');
INSERT INTO `core_dictionaries` VALUES ('1','sex.0','未知','10'), ('2','sex.1','男','10'), ('3','sex.2','女','10');
INSERT INTO `core_dictionaries_group` VALUES ('0','根节点',NULL,'根节点',NULL), ('9','系统字典组','core_dict_group','','0'), ('10','性别字典组','sex','','9'), ('11','test','test','test','9');
INSERT INTO `core_menu` VALUES ('0','mycms管理系统','0','',NULL,'fa fa-desktop','0',NULL), ('2','系统管理','0','','','fa fa-desktop','0','0'), ('3','菜单列表','1','/manager/core/CoreMenuController/coreMenuList','','fa fa-th-list','2','2'), ('19','部门列表','1','/manager/core/CoreDeptController/coreDeptList','','fa fa-book','2','2'), ('20','用户列表','1','/manager/core/CoreUserController/coreUserList','','fa fa-user','3','2'), ('21','角色列表','1','/manager/core/CoreRoleController/coreRoleList','','fa fa-check','4','2'), ('67','新增和修改','2','/manager/core/CoreDeptController/coreDeptForm','core:coreDept:addAndEdit',NULL,'1','19'), ('68','列表','2','/manager/core/CoreDeptController/coreDeptList','core:coreDept:list',NULL,'0','19'), ('69','删除','2','/manager/core/CoreDeptController/deleteCoreDept','core:coreDept:del',NULL,'2','19'), ('70','列表','2','/manager/core/CoreMenuController/coreMenuList','core:coreMenu:list',NULL,'0','3'), ('71','新增和修改','2','/manager/core/CoreMenuController/coreMenuForm','core:coreMenu:addAndEdit',NULL,'1','3'), ('72','删除','2','/manager/core/CoreMenuController/deleteCoreMenu','core:coreMenu:del',NULL,'2','3'), ('73','列表','2','/manager/core/CoreRoleController/coreRoleList','core:coreRole:list',NULL,'0','21'), ('74','新增和修改','2','/manager/core/CoreRoleController/coreRoleForm','core:coreRole:addAndEdit',NULL,'1','21'), ('75','删除','2','/manager/core/CoreRoleController/deleteCoreRole','core:coreRole:del',NULL,'2','21'), ('76','列表','2','/manager/core/CoreUserController/coreUserList','core:coreUser:list',NULL,'0','20'), ('77','新增和修改','2','/manager/core/CoreUserController/coreUserForm','core:coreUser:addAndEdit',NULL,'1','20'), ('78','删除','2','/manager/core/CoreUserController/deleteCoreUser','core:coreUser:del',NULL,'2','20'), ('79','重置密码','2','/manager/core/CoreUserController/resetPwd','core:coreUser:resetPwd',NULL,'3','20'), ('80','参数管理','1','/manager/core/CoreParameterController/coreParameterList','','fa fa-arrows','5','2'), ('81','数据字典组管理','1','/manager/core/CoreDictionariesGroupController/coreDictionariesGroupList','','fa fa-bars','6','2'), ('82','数据字典管理','1','/manager/core/CoreDictionariesController/coreDictionariesList','','fa fa-building','7','2'), ('83','列表','2','/manager/core/CoreDictionariesController/coreDictionariesList','core:coreDictionaries:list',NULL,'0','82'), ('84','新增和修改','2','/manager/core/CoreDictionariesController/coreDictionariesForm','core:coreDictionaries:addAndEdit',NULL,'1','82'), ('85','删除','2','/manager/core/CoreDictionariesController/deleteCoreDictionaries','core:coreDictionaries:del',NULL,'2','82'), ('86','列表','2','/manager/core/CoreDictionariesGroupController/coreDictionariesGroupList','core:coreDictionariesGroup:list',NULL,'0','81'), ('87','新增和修改','2','/manager/core/CoreDictionariesGroupController/coreDictionariesGroupForm','core:coreDictionariesGroup:addAndEdit',NULL,'1','81'), ('88','删除','2','/manager/core/CoreDictionariesGroupController/deleteCoreDictionariesGroup','core:coreDictionariesGroup:del',NULL,'2','81'), ('89','列表','2','/manager/core/CoreParameterController/coreParameterList','core:coreParameter:list',NULL,'0','80'), ('90','新增和修改','2','/manager/core/CoreParameterController/coreParameterForm','core:coreParameter:addAndEdit',NULL,'1','80'), ('91','删除','2','/manager/core/CoreParameterController/deleteCoreParameter','core:coreParameter:del',NULL,'2','80');
INSERT INTO `core_parameter` VALUES ('2','1231','sys','123','123','123','2018-11-22 21:29:15','2018-11-22 21:29:15');
INSERT INTO `core_role` VALUES ('1','超级管理员','super_admin','2018-11-08 22:19:54','2018-11-08 22:19:54'), ('3','管理员','admin','2018-11-19 22:49:19','2018-11-19 22:49:19');
INSERT INTO `core_role_menu` VALUES ('0','1'), ('2','1'), ('3','1'), ('19','1'), ('20','1'), ('21','1'), ('67','1'), ('68','1'), ('69','1'), ('70','1'), ('71','1'), ('72','1'), ('73','1'), ('74','1'), ('75','1'), ('76','1'), ('77','1'), ('78','1'), ('79','1'), ('80','1'), ('81','1'), ('82','1'), ('83','1'), ('84','1'), ('85','1'), ('86','1'), ('87','1'), ('88','1'), ('89','1'), ('90','1'), ('91','1'), ('0','3'), ('2','3'), ('3','3'), ('19','3'), ('20','3'), ('21','3'), ('67','3'), ('68','3'), ('70','3'), ('71','3'), ('73','3'), ('76','3'), ('77','3'), ('78','3'), ('79','3');
INSERT INTO `core_user` VALUES ('1','superadmin','123456','超级管理员','sex.1','2018-10-31','13322221111','11@163.com','最高权限管理员','1','6','2018-11-10 14:27:38','2018-11-22 14:15:59'), ('2','admin','123456','管理员','sex.1','2018-10-31','13211112222','11@qq.com',NULL,'1','7','2018-11-20 19:02:13','2018-11-20 19:07:26'), ('3','test','123456','test','sex.2','2018-10-31','13211112222','11@qq.com',NULL,'1','7','2018-11-20 20:21:14','2018-11-20 20:21:27'), ('9','tt','1','tt','sex.1','2018-11-01','11231','11@qq.com','tt','1','7','2018-11-20 20:56:04','2018-11-22 14:23:55');
INSERT INTO `core_user_role` VALUES ('1','1'), ('2','3'), ('3','3'), ('9','3');
