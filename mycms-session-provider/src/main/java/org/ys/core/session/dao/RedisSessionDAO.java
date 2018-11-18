package org.ys.core.session.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.ys.common.constant.ShiroConstant;
import org.ys.redis.service.RedisCacheStorageService;

public class RedisSessionDAO extends AbstractSessionDAO{
	@Autowired
	private RedisCacheStorageService<String,Object> redisCacheStorageService;
	
	/**
	 * The Redis key prefix for the sessions
	 */
	private String keyPrefix = ShiroConstant.SHIRO_PRE_KEY;

	private String getKey(String originalKey) {
		return keyPrefix + originalKey;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		try {
			redisCacheStorageService.set(getKey(session.getId().toString()), session, ShiroConstant.SHIRO_SESSION_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Session session) {
		try {
			String key = getKey(session.getId().toString());
			redisCacheStorageService.remove(key);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection<Session> getActiveSessions() {
		Set keySet = redisCacheStorageService.keys(getKey("*"));
        Set<Session> sessionSet = new HashSet<>();
        if (CollectionUtils.isEmpty(keySet)) {
            return Collections.emptySet();
        }
        for (Object key : keySet) {
            sessionSet.add((Session) redisCacheStorageService.get(key.toString()));
        }
		return sessionSet;
	}

	@Override
	protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
		try {
//			Subject subject = SecurityUtils.getSubject();
//			if(null != subject) {
//				String userName = (String) subject.getPrincipal();
//				session.setAttribute("userName", userName);
//			}
			redisCacheStorageService.set(getKey(session.getId().toString()), session, ShiroConstant.SHIRO_SESSION_TIME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------2----------- " + session);
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		SimpleSession readSession = null;
		try {
			readSession = (SimpleSession) redisCacheStorageService.get(getKey(sessionId.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null != readSession && null == readSession.getId()) {
			readSession.setId(sessionId);
		}
		System.out.println("------------------------ " + readSession);
		return readSession;
	}
}
