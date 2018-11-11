package org.ys.core.session.impl;

import java.io.Serializable;

import org.apache.shiro.session.Session;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Sets;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.core.shiro.session.RemoteSessionService;

import java.io.Serializable;


@Service
public class RemoteSessionServiceImpl implements RemoteSessionService {

    @Autowired
    private SessionDAO sessionDAO;

//    @Reference(version = "1.0.0")
//    private IdService idService;
//
//    @Reference(version = "1.0.0")
//    private SecurityService securityService;

    private static final Logger logger = LoggerFactory.getLogger(RemoteSessionServiceImpl.class);


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

//    @Override
//    public PermissionContext getPermissions(String identify) {
//        PermissionContext permissionContext = new PermissionContext();
//        permissionContext.setRoles(Sets.newHashSet("po", "sm", "team"));
//        permissionContext.setPermissions(Sets.newHashSet("system:delete_department", "system:user:create", "system:user:delete"));
//        return permissionContext;
//    }
}
