package org.ys.core.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ys.core.service.CoreUserService;

@Controller
@RequestMapping("/LoginController")
public class LoginController {
	
	@Autowired
	private CoreUserService coreUserService;
	
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> login(String username,String password){
		String msg = "";
		boolean success = false;
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username,password);
			subject.login(token);
			msg = "登陆成功！ ";
			success = true;
		} catch (AuthenticationException e) {
			//e.printStackTrace();
			msg = "用户名或密码错误";
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public Map<String,Object> logout(String username,String password){
		String msg = "";
		boolean success = false;
		try {
			SecurityUtils.getSubject().logout();
			msg = "注销成功！ ";
			success = true;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			msg = "注销失败";
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	}
}
