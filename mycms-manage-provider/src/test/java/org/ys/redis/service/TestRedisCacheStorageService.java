package org.ys.redis.service;

import org.apache.shiro.session.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ys.core.model.CoreUser;
import org.ys.core.service.CoreUserService;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-manager-provider.xml"})   
public class TestRedisCacheStorageService {
	
	@Autowired
	private CoreUserService coreUserService;
      
    @Autowired  
    private RedisCacheStorageService<String,CoreUser> redisCacheStorageService;  
      
    @Test
    public void redisSet(){  
    	//redisCacheStorageService.set("test", "test",10);
    	try {
    		CoreUser coreUser = coreUserService.queryCoreUserById(1l);
    		redisCacheStorageService.set("core_user_1", coreUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
    
    @Test
    public void redisGet(){
    	//String testVal = redisCacheStorageService.get("test");
    	//System.out.println(testVal);
    	CoreUser coreUser = (CoreUser) redisCacheStorageService.get("core_user_1");
    	System.out.println(coreUser.getUserName());
    }
    
    @Test
    public void redisGetSession(){
    	//String testVal = redisCacheStorageService.get("test");
    	//System.out.println(testVal);
    	Session session = (Session) redisCacheStorageService.get("shiro_redis_session:eb09d37f-bea1-4246-add9-a17276303d09");
    	if(null != session) {
    		String username = (String) session.getAttribute("username");
    		System.out.println(username);
    	}
    }
}
