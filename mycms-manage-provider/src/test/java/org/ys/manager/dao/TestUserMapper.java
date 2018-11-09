package org.ys.manager.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ys.core.dao.CoreUserMapper;
import org.ys.core.model.CoreUser;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-mybatis.xml"})   
public class TestUserMapper {
      
    @Autowired  
    private CoreUserMapper coreUserMapper;  
      
    @Test
    public void getUserTest(){  
        
    } 
    
    @Test
    public void insertUser(){
    	CoreUser user = new CoreUser();
    	user.setBirthday(new Date());
    	user.setSex("男");
    	user.setEmail("test@163.com");
    	user.setMobile("13211112222");
    	user.setPassword("123456");
    	user.setUserName("中文");
    	user.setRealName("realname");
    	user.setStatus("active");
    	user.setCreatedTime(new Date());
    	user.setModifiedTime(new Date());
    	coreUserMapper.insert(user);
    }
}
