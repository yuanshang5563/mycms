package org.ys.manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ys.core.dao.CoreRoleMapper;
import org.ys.core.dao.CoreRoleMenuMapper;
import org.ys.core.model.CoreRole;
import org.ys.core.model.CoreRoleMenu;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-mybatis.xml"})   
public class TestCoreRoleMenuMapper {
	
	@Autowired
	private CoreRoleMenuMapper coreRoleMenuMapper;
	
	@Autowired
	private CoreRoleMapper coreRoleMapper;
	
	@Test
	public void testInsert() {
		CoreRole coreRole = new CoreRole();
		coreRole.setRoleName("11");
		coreRole.setRole("11");
		coreRoleMapper.insert(coreRole);
		CoreRoleMenu coreRoleMenu = new CoreRoleMenu();
		coreRoleMenu.setCoreMenuId(2l);
		coreRoleMenu.setCoreRoleId(coreRole.getCoreRoleId());
		coreRoleMenuMapper.insertCoreRoleMenu(coreRoleMenu);
	}
}
