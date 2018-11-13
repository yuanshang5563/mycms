package org.ys.core.shiro.session;

import org.apache.shiro.session.Session;
import org.ys.core.shiro.common.PermissionContext;

import java.io.Serializable;

public interface RemoteSessionService {

	/**
	 * 获取session
	 * 
	 * @param sessionId
	 * @return
	 */
	Session getSession(Serializable sessionId);

	/**
	 * 创建session
	 * 
	 * @param session
	 * @return
	 */
	Serializable createSession(Session session);

	/**
	 * 更新session
	 * 
	 * @param session
	 */
	void updateSession(Session session);

	/**
	 * 删除session
	 * 
	 * @param session
	 */
	void deleteSession(Session session);

	/**
	 * 查询用户的角色和权限信息
	 * 
	 * @param identify
	 * @return
	 */
	PermissionContext getPermissions(String identify);
}
