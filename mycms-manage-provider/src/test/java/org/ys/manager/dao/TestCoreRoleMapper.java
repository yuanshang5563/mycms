package org.ys.manager.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ys.core.dao.CoreRoleMapper;
import org.ys.core.model.CoreRole;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-mybatis.xml"})   
public class TestCoreRoleMapper {
	
	@Autowired
	private CoreRoleMapper coreRoleMapper;
	
	@Test
	public void testInsert() {
		CoreRole coreRole = new CoreRole();
		coreRole.setRole("super_admin");
		coreRole.setRoleName("超级管理员");
		coreRole.setCreatedTime(new Date());
		coreRole.setModifiedTime(new Date());
		coreRoleMapper.insert(coreRole);
	}
}
