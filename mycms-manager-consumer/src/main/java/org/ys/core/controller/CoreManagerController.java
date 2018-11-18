package org.ys.core.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.ys.common.constant.ShiroConstant;
import org.ys.common.domain.Tree;
import org.ys.core.model.CoreMenu;
import org.ys.core.model.CoreMenuExample;
import org.ys.core.model.CoreUser;
import org.ys.core.model.CoreUserExample;
import org.ys.core.service.CoreMenuService;
import org.ys.core.service.CoreUserService;
import org.ys.redis.service.RedisCacheStorageService;

@Controller
@RequestMapping("/manager/core/CoreManagerController")
public class CoreManagerController {
	@Autowired
	private CoreMenuService coreMenuService;
	
	@Autowired
	private CoreUserService coreUserService;	
	
	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@Autowired
	private RedisCacheStorageService<String, Object> redisCacheStorageService;
	
	@RequestMapping("/main")
	public String main(Model model) throws Exception {
		
		Subject subject = SecurityUtils.getSubject();
		Session localSession = subject.getSession();
		String username = null;
		if(null != localSession) {
			Session session = (Session) redisCacheStorageService.get(ShiroConstant.SHIRO_PRE_KEY+localSession.getId());
			if(null != session) {
				username = (String) session.getAttribute("username");
			}
		}
		if(StringUtils.isNotEmpty(username)) {
			CoreUserExample example = new CoreUserExample();
			example.createCriteria().andUserNameEqualTo(username.trim());
			List<CoreUser> users = coreUserService.queryCoreUsersByExample(example);
			CoreUser coreUser = null;
			if(null != users && users.size() > 0) {
				coreUser = users.get(0);
			}
			List<Tree<CoreMenu>> menus = coreMenuService.listMenuTreeByUserId(coreUser.getCoreUserId());
			model.addAttribute("menus", menus);
			model.addAttribute("name", coreUser.getRealName());
			model.addAttribute("picUrl","/img/photo_s.jpg");
			model.addAttribute("username", coreUser.getUserName());
		}
		
//		List<Tree<CoreMenu>> menus = coreMenuService.listMenuTreeByUserId(1l);
//		model.addAttribute("menus", menus);
//		model.addAttribute("name", "test");
//		model.addAttribute("picUrl","/img/photo_s.jpg");
//		model.addAttribute("username", "test111");
		return "/manager/main";
	}
	
	@RequestMapping("/index")
	public String index(Model model) throws Exception {
		return "/manager/index";
	}
	
	@RequestMapping("/reLoadPermissions")
	public void reLoadPermissions() {
		try {
			Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
			Collection<HandlerMethod> handlerMethods = handlerMethodMap.values();
			//一次找出所有权限
			CoreMenuExample example = new CoreMenuExample();
			List<CoreMenu> allMenus = coreMenuService.queryCoreMenusByExample(example);
			for (HandlerMethod handlerMethod : handlerMethods) {
				RequiresPermissions requiresPermissions = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
				String[] permissionsVal = requiresPermissions.value();
				if(null != permissionsVal && permissionsVal.length > 0) {
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
