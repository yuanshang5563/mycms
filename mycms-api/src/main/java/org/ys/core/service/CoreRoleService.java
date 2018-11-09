package org.ys.core.service;

import java.util.List;

import org.ys.core.model.CoreRole;
import org.ys.core.model.CoreRoleExample;

public interface CoreRoleService {
	public CoreRole queryCoreRoleById(Long coreRoleId) throws Exception;
	
	public void save(CoreRole coreRole) throws Exception;
	
	public void updateById(CoreRole coreRole) throws Exception;
	
	public void updateByExaple(CoreRole coreRole,CoreRoleExample example) throws Exception;
	
	public void delCoreRoleById(Long coreRoleId) throws Exception;
	
	public List<CoreRole>queryCoreRolesByExample(CoreRoleExample example) throws Exception;	
}