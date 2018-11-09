package org.ys.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.ys.core.service.CoreMenuService;
import org.ys.core.service.CoreUserService;

import com.google.gson.Gson;

@Controller
@RequestMapping("/LoginController")
public class LoginController {
	@Autowired
	private CoreMenuService coreMenuService;
	
	@Autowired
	private CoreUserService coreUserService;
	
	@RequestMapping("/login")
	public ModelAndView login(String username,String password) throws Exception {
		ModelAndView model = new ModelAndView("/login.jsp");
		return model;
	}
}
