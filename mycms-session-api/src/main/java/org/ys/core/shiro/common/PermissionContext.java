package org.ys.core.shiro.common;

import java.io.Serializable;
import java.util.Set;

public class PermissionContext implements Serializable{
	private static final long serialVersionUID = -2066503520060113325L;
	
	private Set<String> roles;
	private Set<String> permissions;
	
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}
}
