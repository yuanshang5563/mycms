package org.ys.core.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.crazycake.shiro.IRedisManager;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.ys.common.constant.CoreMenuType;
import org.ys.common.constant.ShiroConstant;
import org.ys.common.domain.Tree;
import org.ys.common.shiro.PermissionName;
import org.ys.common.utils.ObjectUtil;
import org.ys.core.model.CoreMenu;
import org.ys.core.model.CoreMenuExample;
import org.ys.core.model.CoreMenuExample.Criteria;
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
	private RedisCacheStorageService redisCacheStorageService;
	
	@Autowired
	private RedisCacheManager redisCacheManager;
	
	@RequestMapping("/main")
	public String main(Model model) throws Exception {
		
		Subject subject = SecurityUtils.getSubject();
		String username = (String)subject.getPrincipal();;
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
	@ResponseBody
	public Map<String,Object> reLoadPermissions() {
		String msg = "";
		boolean success = false;
		try {
			Map<HandlerMethod,String> methodAndUrlMap = new HashMap<HandlerMethod,String>();
			Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = requestMappingHandlerMapping.getHandlerMethods();
			Set<RequestMappingInfo> mappingInfoSet = handlerMethodMap.keySet();
			for (RequestMappingInfo requestMappingInfo : mappingInfoSet) {
				PatternsRequestCondition patternsRequestCondition = requestMappingInfo.getPatternsCondition();
				Set<String> patternsSet = patternsRequestCondition.getPatterns();
				if(null != patternsSet && patternsSet.size() > 0) {
					methodAndUrlMap.put(handlerMethodMap.get(requestMappingInfo), patternsSet.iterator().next());
				}
			}
			Collection<HandlerMethod> handlerMethods = handlerMethodMap.values();
			//一次找出所有菜单权限
			Map<String,CoreMenu> existParentMenu = new HashMap<String,CoreMenu>();
			CoreMenuExample example = new CoreMenuExample();
			example.createCriteria().andMenuTypeEqualTo(CoreMenuType.MENU_TYPE_MENU);
			List<CoreMenu> parentMenuList = coreMenuService.queryCoreMenusByExample(example);
			if(null != parentMenuList && parentMenuList.size() > 0) {
				for (CoreMenu parentMenu : parentMenuList) {
					String menuUrl = parentMenu.getMenuUrl();
					if(StringUtils.isNotEmpty(menuUrl) && menuUrl.contains("List")) {
						int position = StringUtils.lastIndexOf(menuUrl, "/");
						String menuActionUrl = StringUtils.substring(menuUrl, 0, position);
						existParentMenu.put(menuActionUrl, parentMenu);
					}
				}
			}
			
			for (HandlerMethod handlerMethod : handlerMethods) {
				RequiresPermissions requiresPermissionsAnno = handlerMethod.getMethodAnnotation(RequiresPermissions.class);
				if(null == requiresPermissionsAnno) {
					continue;
				}
				String[] permissionsArr = requiresPermissionsAnno.value();
				String permission = null;
				if(null != permissionsArr && permissionsArr.length > 0) {
					permission = permissionsArr[0];
				}
				PermissionName permissionNameAnno = handlerMethod.getMethodAnnotation(PermissionName.class);
				if(null == permissionNameAnno) {
					continue;
				}
				String permissionNameVal = permissionNameAnno.value();
				String permissionNameType = permissionNameAnno.type();
				if(StringUtils.isNotEmpty(permission)&&StringUtils.isNotEmpty(permissionNameVal)
				&&StringUtils.isNotEmpty(permissionNameType)) {
					String menuUrl = methodAndUrlMap.get(handlerMethod);
					int position = StringUtils.lastIndexOf(menuUrl, "/");
					String menuActionUrl = StringUtils.substring(menuUrl, 0, position);
					//先找list
					CoreMenu parentMenu = null;
					if(StringUtils.equals(CoreMenuType.MENU_TYPE_BUTTON, permissionNameType)){
						if(existParentMenu.containsKey(menuActionUrl)) {
							parentMenu = existParentMenu.get(menuActionUrl);
						}
					}
					//再找当前菜单或按钮
					CoreMenu currCoreMenu = null;
					example.clear();
					Criteria criteria = example.createCriteria();
					criteria.andMenuUrlEqualTo(menuUrl);
					List<CoreMenu> menus = coreMenuService.queryCoreMenusByExample(example);
					if(null != menus && menus.size() > 0) {
						currCoreMenu = menus.get(0);
					}
					if(StringUtils.equals(CoreMenuType.MENU_TYPE_BUTTON, permissionNameType)){
						if(null != parentMenu) {
							if(null == currCoreMenu) {
								currCoreMenu = new CoreMenu();
								currCoreMenu.setParentCoreMenuId(parentMenu.getCoreMenuId());
								currCoreMenu.setMenuUrl(menuUrl);
							}
							currCoreMenu.setPermission(permission);
							currCoreMenu.setMenuType(CoreMenuType.MENU_TYPE_BUTTON);
							currCoreMenu.setMenuName(permissionNameVal);
							if(null != currCoreMenu.getCoreMenuId() && currCoreMenu.getCoreMenuId() != 0l) {
								coreMenuService.updateById(currCoreMenu);
							}else {
								coreMenuService.save(currCoreMenu);
							}
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "失败，程序发生异常！";
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	}
}
