package org.ys.core.session.realm;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.ys.core.model.CoreUser;
import org.ys.core.model.CoreUserExample;
import org.ys.core.model.CoreUserExample.Criteria;
import org.ys.core.service.CoreUserService;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	private CoreUserService coreUserService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//principals.get
		return null;
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
		try {
			CoreUserExample example = new CoreUserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(userName.trim());
			criteria.andPasswordEqualTo(password.trim());
			List<CoreUser> coreUserList = coreUserService.queryCoreUsersByExample(example);
			if(null == coreUserList || coreUserList.size() <= 0) {
				throw new AccountException("用户名或密码错误!");
			}
			coreUser = coreUserList.get(0);
			String status = coreUser.getStatus();
			if(StringUtils.isEmpty(status) || !StringUtils.equals(status, "1")) {
				throw new AccountException("用户被冻结，请联系管理员!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		AuthenticationInfo AuthenticationInfo = new SimpleAuthenticationInfo(coreUser.getUserName(),coreUser.getPassword(),getName());
		return AuthenticationInfo;	
	}
}
