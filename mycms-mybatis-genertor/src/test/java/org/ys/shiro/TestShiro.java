package org.ys.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class TestShiro {
	
	@Test
	public void testFirstShiro() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:myini.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","666");
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			e.printStackTrace();
			System.out.println("--------------- 用户名错误！");
		} catch (CredentialsException  e) {
			e.printStackTrace();
			System.out.println("--------------- 密码错误！");
		}
		System.out.println("--------------- " + subject.isAuthenticated());
	}
}
