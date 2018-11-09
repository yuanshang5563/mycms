package org.ys.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ys.common.domain.Tree;
import org.ys.common.utils.ShiroUtils;
import org.ys.core.model.CoreMenu;
import org.ys.core.service.CoreMenuService;

@Controller
@RequestMapping("/manager/core/CoreManagerController")
public class CoreManagerController {
	@Autowired
	private CoreMenuService coreMenuService;
	
	@RequestMapping("/main")
	public String main(Model model) throws Exception {
		
//		List<Tree<CoreMenu>> menus = coreMenuService.listMenuTreeByUserId(ShiroUtils.getUserId());
//		model.addAttribute("menus", menus);
//		model.addAttribute("name", ShiroUtils.getUser().getRealName());
//		model.addAttribute("picUrl","/img/photo_s.jpg");
//		model.addAttribute("username", ShiroUtils.getUser().getUserName());
		
		List<Tree<CoreMenu>> menus = coreMenuService.listMenuTreeByUserId(1l);
		model.addAttribute("menus", menus);
		model.addAttribute("name", "test");
		model.addAttribute("picUrl","/img/photo_s.jpg");
		model.addAttribute("username", "test111");
		return "/manager/main";
	}
	
	@RequestMapping("/index")
	public String index(Model model) throws Exception {
		return "/manager/index";
	}
}
