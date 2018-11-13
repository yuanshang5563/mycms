package org.ys.core.session.impl;

import java.io.Serializable;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.core.shiro.common.PermissionContext;
import org.ys.core.shiro.session.RemoteSessionService;

import com.google.common.collect.Sets;

@Service
public class RemoteSessionServiceImpl implements RemoteSessionService {

    @Autowired
    private SessionDAO sessionDAO;

    @Override
    public Session getSession(Serializable sessionId) {
        return sessionDAO.readSession(sessionId);
    }

    @Override
    public Serializable createSession(Session session) {
        return sessionDAO.create(session);
    }

    @Override
    public void updateSession(Session session) {
        sessionDAO.update(session);
    }

    @Override
    public void deleteSession(Session session) {
        sessionDAO.delete(session);
    }

    @Override
    public PermissionContext getPermissions(String identify) {
        PermissionContext permissionContext = new PermissionContext();
        permissionContext.setRoles(Sets.newHashSet("po", "sm", "team"));
        permissionContext.setPermissions(Sets.newHashSet("system:delete_department", "system:user:create", "system:user:delete"));
        return permissionContext;
    }
}
