package org.ys.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.common.domain.Tree;
import org.ys.common.page.PageBean;
import org.ys.common.utils.BuildTree;
import org.ys.core.dao.CoreMenuMapper;
import org.ys.core.model.CoreMenu;
import org.ys.core.model.CoreMenuExample;
import org.ys.core.model.CoreMenuExample.Criteria;
import org.ys.core.service.CoreMenuService;

import com.github.pagehelper.PageHelper;

@Service("coreMenuService")
public class CoreMenuServiceImpl implements CoreMenuService{
	@Autowired
	private CoreMenuMapper coreMenuMapper;

	@Override
	public CoreMenu queryCoreMenuById(Long coreMenuId) throws Exception {
		if(null == coreMenuId){
			return null;
		}
		return coreMenuMapper.selectByPrimaryKey(coreMenuId);
	}

	@Override
	public void save(CoreMenu coreMenu) throws Exception {
		if(null != coreMenu) {
			coreMenuMapper.insert(coreMenu);
		}
	}

	@Override
	public void updateById(CoreMenu coreMenu) throws Exception {
		if(null != coreMenu) {
			coreMenuMapper.updateByPrimaryKey(coreMenu);
		}
	}

	@Override
	public void updateByExaple(CoreMenu corePermission, CoreMenuExample example) throws Exception {
		if(null != corePermission && null != example) {
			coreMenuMapper.updateByExample(corePermission, example);
		}
		
	}

	@Override
	public void delCoreMenuById(Long coreMenuId) throws Exception {
		if(null != coreMenuId) {
			coreMenuMapper.deleteByPrimaryKey(coreMenuId);
		}
	}

	@Override
	public List<CoreMenu> queryCoreMenusByExample(CoreMenuExample example) throws Exception {
		if(null == example) {
			return null;
		}
		return coreMenuMapper.selectByExample(example);
	}

	@Override
	public List<CoreMenu> queryCoreMenusByParentId(Long parentId) throws Exception {
		if(null == parentId) {
			return null;
		}
		CoreMenuExample example = new CoreMenuExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentCoreMenuIdEqualTo(parentId);
		return coreMenuMapper.selectByExample(example);
	}
	
	private Set<CoreMenu> queryAllSubMensByParentId(Long parentId,Set<CoreMenu> allSubMenus) throws Exception  {
		if(null == parentId) {
			return null;
		}
		List<CoreMenu> menus = queryCoreMenusByParentId(parentId);
		if(null != menus && menus.size() > 0){
			if(null != allSubMenus){
				allSubMenus.addAll(menus);
			}
			for (CoreMenu menu : menus) {
				if("menu-node".equals(menu.getMenuType())){
					queryAllSubMensByParentId(menu.getCoreMenuId(),allSubMenus);
				}
			}
		}
		return allSubMenus;
	}

	@Override
	public Set<CoreMenu> queryAllSubCoreMensByParentId(Long parentId) throws Exception {
		if(null == parentId) {
			return null;
		}
		Set<CoreMenu> allSubMenus = new HashSet<>();
		return queryAllSubMensByParentId(parentId,allSubMenus);
	}

	@Override
	public PageBean<CoreMenu> pageCoreMenusByExample(CoreMenuExample example, int pageNum, int pageSize) throws Exception {
		if(null == example) {
			return null;
		}
		PageHelper.startPage(pageNum, pageSize, true);
		List<CoreMenu> menuList = coreMenuMapper.selectByExample(example);
		return new PageBean<CoreMenu>(menuList);
	}

	@Override
	public List<Tree<CoreMenu>> listMenuTreeByUserId(Long coreUserId) {
		if(null == coreUserId) {
			return null;
		}
		List<Tree<CoreMenu>> trees = new ArrayList<Tree<CoreMenu>>();
		List<CoreMenu> menus = coreMenuMapper.listCoreMenusByUserId(coreUserId);
		for (CoreMenu menu : menus) {
			Tree<CoreMenu> tree = new Tree<CoreMenu>();
			tree.setId(menu.getCoreMenuId().toString());
			if(null != menu.getParentCoreMenuId()) {
				tree.setParentId(menu.getParentCoreMenuId().toString());
			}else {
				tree.setParentId("0");
			}
			tree.setText(menu.getMenuName());
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("url", menu.getMenuUrl());
			attributes.put("icon", menu.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		// 默认顶级菜单为０，根据数据库实际情况调整
		List<Tree<CoreMenu>> list = BuildTree.buildList(trees, "0");
		return list;
	}

}
