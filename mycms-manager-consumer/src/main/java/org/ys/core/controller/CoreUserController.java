package org.ys.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ys.common.page.PageBean;
import org.ys.common.utils.DateTimeConverter;
import org.ys.common.utils.RequsetUtils;
import org.ys.core.model.CoreUser;
import org.ys.core.model.CoreUserExample;
import org.ys.core.model.CoreUserExample.Criteria;
import org.ys.core.service.CoreUserService;

@Controller
@RequestMapping("/manager/core/CoreUserController")
public class CoreUserController {
	@Autowired
	private CoreUserService coreUserService;
	
	@RequestMapping("/addUser")
	public ModelAndView addUser()throws Exception {
		ModelAndView modelAndView = new ModelAndView("/manager/core_user/core_user_form");
		return modelAndView;
	}
	
	@RequestMapping("/editUser")
	public ModelAndView editUser(String coreUserId,boolean viewFlag)throws Exception {
		ModelAndView modelAndView = new ModelAndView("/manager/core_user/core_user_form");
		modelAndView.addObject("coreUserId", coreUserId);
		modelAndView.addObject("viewFlag", viewFlag);
		return modelAndView;
	}
	
	@RequestMapping("/userList")
	public ModelAndView getUserList()throws Exception {
		ModelAndView modelAndView = new ModelAndView("/manager/core_user/core_user_list");
		return modelAndView;
	}

	@RequestMapping("/addUserSave")
	@ResponseBody
	public Map<String,Object> addUserSave(HttpServletRequest request)throws Exception {
		String msg = "增加用户成功！";
		boolean success = true;
		try {
			Map<String,Object> paramMap = RequsetUtils.getParamsMap(request);
			CoreUser coreUser = new CoreUser();
			BeanUtilsBean.getInstance().getConvertUtils().register(new DateTimeConverter(), Date.class);
			BeanUtils.populate(coreUser, paramMap);
			coreUser.setCreatedTime(new Date());
			coreUser.setModifiedTime(new Date());
			coreUserService.save(coreUser);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "程序发生异常,增加用户失败！ " + e.getMessage();
			success = false;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	} 
	
	@RequestMapping("/editUserSave")
	@ResponseBody
	public Map<String,Object> editUserSave(HttpServletRequest request)throws Exception {
		String msg = "修改用户成功！";
		boolean success = true;
		try {
			Map<String,Object> paramMap = RequsetUtils.getParamsMap(request);
			CoreUser coreUser = new CoreUser();
			BeanUtilsBean.getInstance().getConvertUtils().register(new DateTimeConverter(), Date.class);
			BeanUtils.populate(coreUser, paramMap);
			coreUserService.updateById(coreUser);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "程序发生异常,修改用户失败！ " + e.getMessage();
			success = false;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	} 
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public Map<String,Object> deleteUser(Long coreUserId)throws Exception {
		String msg = "删除用户成功！";
		boolean success = true;
		try {
			coreUserService.delCoreUserById(coreUserId);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "程序发生异常,删除用户失败！ " + e.getMessage();
			success = false;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		map.put("success", success);
		return map;
	} 
	
	@RequestMapping("/ajaxFindUserById")
	@ResponseBody
	public Map<String,Object> ajaxFindUserById(Long coreUserId)throws Exception {
		String msg = "查找用户成功！";
		boolean success = true;
		CoreUser user = null;
		try {
			user = coreUserService.queryCoreUserById(coreUserId);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = "程序发生异常,查找用户失败！ " + e.getMessage();
			success = false;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if(success){
			map.put("data", user);
		}else{
			map.put("errorMessage", msg);
		}
		map.put("success", success);
		//Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		//gson.toJson(map)
		return map;
	} 
	
	@RequestMapping("/userListJsonData")
	@ResponseBody
	public Map<String,Object> getUserListJsonData(HttpServletRequest request)throws Exception {
		String start = request.getParameter("start");
		String limit = request.getParameter("limit");
		String userName = request.getParameter("userName");
		CoreUserExample example = new CoreUserExample();
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotEmpty(userName)){
			criteria.andUserNameLike(userName+"%");
		}
		if(StringUtils.isEmpty(start) || StringUtils.equals(start, "0")) {
			start = "1";
		}
		if(StringUtils.isEmpty(limit)) {
			limit = "10";
		}
		List<CoreUser> users = null;
		long count = 0;
		PageBean<CoreUser> pageBean = coreUserService.pageCoreUsersByExample(example,Integer.parseInt(start),Integer.parseInt(limit));
		if(null != pageBean) {
			users = pageBean.getList();
			count = pageBean.getTotal();
		}else {
			users = new ArrayList<CoreUser>();
		}
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("count", count);
		maps.put("root", users);
		//Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		//System.out.println(gson.toJson(maps));
		return maps;
	}
}
