INSERT INTO `core_menu` VALUES (0, 'fa fa-desktop', 'mycms管理系统', '0', NULL, NULL, 0, NULL);
INSERT INTO `core_menu` VALUES (2, 'fa fa-desktop', '系统管理', '0', '', '', 3, 0);
INSERT INTO `core_menu` VALUES (3, 'fa fa-th-list', '菜单列表', '1', '/manager/core/CoreMenuController/coreMenuList', '123', 1, 2);
INSERT INTO `core_menu` VALUES (19, 'fa fa-users', '部门管理', '1', '/manager/core/CoreDeptController/coreDeptList', '', 2, 2);
INSERT INTO `core_menu` VALUES (20, 'fa fa-user', '用户管理', '1', '/manager/core/CoreUserController/coreUserList', '', 4, 2);
INSERT INTO `core_menu` VALUES (21, 'fa fa-check', '角色管理', '1', '/manager/core/CoreRoleController/coreRoleList', '', 5, 2);
