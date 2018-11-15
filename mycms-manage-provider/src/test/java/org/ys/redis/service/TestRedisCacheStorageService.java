package org.ys.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-manager-provider.xml"})   
public class TestRedisCacheStorageService {
      
    @Autowired  
    private RedisCacheStorageService<String,String> redisCacheStorageService;  
      
    @Test
    public void redisSet(){  
    	redisCacheStorageService.set("test", "test",10);
    } 
    
    @Test
    public void redisGet(){
    	String testVal = redisCacheStorageService.get("test");
    	System.out.println(testVal);
    }
}
