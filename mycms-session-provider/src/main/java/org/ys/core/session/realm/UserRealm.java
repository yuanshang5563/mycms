package org.ys.core.session.realm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.ys.core.model.CoreMenu;
import org.ys.core.model.CoreRole;
import org.ys.core.model.CoreUser;
import org.ys.core.model.CoreUserExample;
import org.ys.core.model.CoreUserExample.Criteria;
import org.ys.core.service.CoreMenuService;
import org.ys.core.service.CoreRoleService;
import org.ys.core.service.CoreUserService;

public class UserRealm extends AuthorizingRealm implements Serializable{
	private static final long serialVersionUID = -6687721711713331365L;

	@Autowired
	private CoreUserService coreUserService;
	
	@Autowired
	private CoreRoleService coreRoleService;
	
	@Autowired
	private CoreMenuService coreMenuService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String) principals.getPrimaryPrincipal();
		CoreUser coreUser = null;
		try {
			if(StringUtils.isNotEmpty(userName)) {
				CoreUserExample example = new CoreUserExample();
				example.createCriteria().andUserNameEqualTo(userName);
				List<CoreUser> coreUsers = coreUserService.queryCoreUsersByExample(example);
				if(null != coreUsers && coreUsers.size() > 0) {
					coreUser = coreUsers.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> roles = null;
		List<String> permissions = null;
		if(null == coreUser) {
			return null;
		}
		//如果用户不为空，从数据库中获取相关权限和角色
		boolean superFlag = false;
		List<CoreRole> coreRoles = coreRoleService.listCoreRolesByUserId(coreUser.getCoreUserId());
		if(null != coreRoles && coreRoles.size() > 0) {
			roles = new ArrayList<String>();
			for (CoreRole coreRole : coreRoles) {
				roles.add(coreRole.getRole());
				if(StringUtils.equals("super_admin", coreRole.getRole())) {
					superFlag = true;
				}
			}
		}
		List<CoreMenu> coreMenus = coreMenuService.listCoreMenusByUserId(coreUser.getCoreUserId());
		if(null != coreMenus && coreMenus.size() > 0) {
			permissions = new ArrayList<String>();
			for (CoreMenu coreMenu : coreMenus) {
				if(StringUtils.isNotEmpty(coreMenu.getPermission())) {
					permissions.add(coreMenu.getPermission());
				}
			}
			if(superFlag) {
				permissions.add("*:*");
			}
		}
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		auth.addRoles(roles);
		auth.addStringPermissions(permissions);
		return auth;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		if(StringUtils.isEmpty(userName)) {
			throw new UnknownAccountException("用户名为空!");
		}
		String password = new String((char[])token.getCredentials());
		if(StringUtils.isEmpty(password)) {
			throw new CredentialsException("密码为空!");
		}
		CoreUser coreUser = null;
		CoreUserExample example = new CoreUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName.trim());
		criteria.andPasswordEqualTo(password.trim());
		List<CoreUser> coreUserList = null;
		try {
			coreUserList = coreUserService.queryCoreUsersByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null == coreUserList || coreUserList.size() <= 0) {
			throw new AccountException("用户名或密码错误!");
		}
		coreUser = coreUserList.get(0);
		String status = coreUser.getStatus();
		if(StringUtils.isEmpty(status) || !StringUtils.equals(status, "1")) {
			throw new AccountException("用户被冻结，请联系管理员!");
		}
		AuthenticationInfo AuthenticationInfo = new SimpleAuthenticationInfo(coreUser.getUserName(),coreUser.getPassword(),getName());
		return AuthenticationInfo;	
	}
}
