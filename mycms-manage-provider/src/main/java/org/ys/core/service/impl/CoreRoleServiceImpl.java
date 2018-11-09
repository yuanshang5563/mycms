package org.ys.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.core.dao.CoreRoleMapper;
import org.ys.core.model.CoreRole;
import org.ys.core.model.CoreRoleExample;
import org.ys.core.service.CoreRoleService;

@Service("coreRoleService")
public class CoreRoleServiceImpl implements CoreRoleService {
	@Autowired
	private CoreRoleMapper coreRoleMapper;

	@Override
	public CoreRole queryCoreRoleById(Long coreRoleId) throws Exception {
		if(null == coreRoleId) {
			return null;
		}
		return coreRoleMapper.selectByPrimaryKey(coreRoleId);
	}

	@Override
	public void save(CoreRole coreRole) throws Exception {
		if(null != coreRole) {
			coreRoleMapper.insert(coreRole);
		}
	}

	@Override
	public void updateById(CoreRole coreRole) throws Exception {
		if(null != coreRole) {
			coreRoleMapper.updateByPrimaryKey(coreRole);
		}
	}

	@Override
	public void updateByExaple(CoreRole coreRole, CoreRoleExample example) throws Exception {
		if(null != coreRole && null != example) {
			coreRoleMapper.updateByExample(coreRole, example);
		}
	}

	@Override
	public void delCoreRoleById(Long coreRoleId) throws Exception {
		if(null != coreRoleId) {
			coreRoleMapper.deleteByPrimaryKey(coreRoleId);
		}
	}

	@Override
	public List<CoreRole> queryCoreRolesByExample(CoreRoleExample example) throws Exception {
		if(null == example) {
			return null;
		}
		return coreRoleMapper.selectByExample(example);
	}

}
