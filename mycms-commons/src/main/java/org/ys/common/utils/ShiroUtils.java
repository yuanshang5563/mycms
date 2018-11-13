package org.ys.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.ys.core.model.CoreUser;

public class ShiroUtils {
	private ShiroUtils() {}

	public static Subject getSubjct() {
		return SecurityUtils.getSubject();
	}

	public static CoreUser getUser() {
		Object object = getSubjct().getPrincipal();
		return (CoreUser) object;
	}

	public static Long getUserId() {
		return getUser().getCoreUserId();
	}

	public static void logout() {
		getSubjct().logout();
	}
}
