package org.ys.core.service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.ys.common.page.PageBean;
import org.ys.core.model.CoreMenu;
import org.ys.core.model.CoreMenuExample;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class) 
//由于本测试类位于src/test/java下，而app-context.xml处于src/main/java下，所以需要使用file来获取，
//否则使用@ContextConfiguration(locations={"classpath:WEB-INF/app-context.xml"})来获取
@ContextConfiguration(locations={"file:src/main/resources/spring/spring-mybatis.xml"})   
public class TestCoreMenuService {
	
	@Autowired
	private CoreMenuService coreMenuService;
	
	@Test
	public void testPage() throws Exception {
		CoreMenuExample example = new CoreMenuExample();
		PageBean<CoreMenu> pagebean = coreMenuService.pageCoreMenusByExample(example, 1, 2);
		System.out.println("--------------- " + pagebean);
		if(null != pagebean) {
			System.out.println("----------- " + pagebean.getTotal());
			List<CoreMenu> menuList = pagebean.getList();
			if(null != menuList && menuList.size() > 0) {
				Iterator<CoreMenu> coreMenuIter = menuList.iterator();
				while(coreMenuIter.hasNext()) {
					CoreMenu coreMenu = coreMenuIter.next();
					System.out.println("------------------- " + coreMenu.getMenuName());
				}
			}
		}
	}
	
	@Test
	public void testSelectByExample() throws Exception {
		CoreMenuExample example = new CoreMenuExample();
		PageHelper.startPage(1, 10, true);
		List<CoreMenu> menuList = coreMenuService.queryCoreMenusByExample(example);
		if(null != menuList && menuList.size() > 0) {
			for (CoreMenu coreMenu : menuList) {
				System.out.println("-------1------- " + coreMenu.getMenuName());
			}
		}
		PageInfo<CoreMenu> page = new PageInfo<CoreMenu>(menuList);
		List<CoreMenu> menuList2 = page.getList();
		if(null != menuList2 && menuList2.size() > 0) {
			for (CoreMenu coreMenu : menuList2) {
				System.out.println("-------2------- " + coreMenu.getMenuName());
			}
		}
	}
	
	@Test
	public void testdelMenu() {
		try {
			coreMenuService.delCoreMenuById(11l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryAllSubCoreMenusByMenuId() {
		try {
			Set<CoreMenu> menus = coreMenuService.queryAllSubCoreMenusByMenuId(2l);
			if(null != menus) {
				for (CoreMenu menu : menus) {
					System.out.println(menu.getMenuName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
