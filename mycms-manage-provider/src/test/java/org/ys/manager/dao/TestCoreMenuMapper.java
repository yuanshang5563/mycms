package org.ys.manager.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ys.core.dao.CoreMenuMapper;
import org.ys.core.model.CoreMenu;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-mybatis.xml"})   
public class TestCoreMenuMapper {
	
	@Autowired
	private CoreMenuMapper coreMenuMapper;
	
	@Test
	public void testInsert() {
		CoreMenu coreMenu = new CoreMenu();
		coreMenu.setMenuName("菜单列表");
		coreMenu.setMenuType("1");
		coreMenu.setOrderNum(0);
		coreMenu.setIcon("fa fa-th-list");
		coreMenu.setMenuUrl("/manager/core/CoreMenuController/coreMenuList");
		coreMenu.setPermission("");
		coreMenu.setParentCoreMenuId(2l);
		coreMenuMapper.insert(coreMenu);
	}
}
