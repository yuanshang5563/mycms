package org.ys.core.session.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.ys.common.constant.ShiroConstant;
import org.ys.redis.service.RedisCacheStorageService;

public class RedisSessionDAO extends AbstractSessionDAO{

	private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);
	@Autowired
	private RedisCacheStorageService<String,Object> redisCacheStorageService;
	
	private int expire;
	
	/**
	 * The Redis key prefix for the sessions
	 */
	private String keyPrefix = ShiroConstant.SHIRO_PRE_KEY;

	private String getKey(String originalKey) {
		return keyPrefix + originalKey;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		logger.debug("更新seesion,id=[{}]", session.getId().toString());
		try {
			redisCacheStorageService.set(getKey(session.getId().toString()), session, expire);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public void delete(Session session) {
		logger.debug("删除seesion,id=[{}]", session.getId().toString());
		try {
			String key = getKey(session.getId().toString());
			redisCacheStorageService.remove(key);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Override
	public Collection<Session> getActiveSessions() {
		logger.info("获取存活的session");
		return Collections.emptySet();
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		logger.debug("创建seesion,id=[{}]", session.getId().toString());
		try {
			redisCacheStorageService.set(getKey(session.getId().toString()), session, expire);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {

		logger.debug("获取seesion,id=[{}]", sessionId.toString());
		Session readSession = null;
		try {
			readSession = (Session) redisCacheStorageService.get(getKey(sessionId.toString()));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return readSession;
	}

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}
}
