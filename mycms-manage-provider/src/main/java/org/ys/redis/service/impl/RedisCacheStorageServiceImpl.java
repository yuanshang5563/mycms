package org.ys.redis.service.impl;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.crazycake.shiro.RedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ys.common.constant.RedisConstant;
import org.ys.common.utils.ObjectUtil;
import org.ys.redis.service.RedisCacheStorageService;

/**
 * redis 缓存存储器实现
 * @author yclimb
 *
 * @param <V>
 */
@Service("redisCacheStorageService")
public class RedisCacheStorageServiceImpl implements RedisCacheStorageService {
	
    @Autowired  
    private RedisManager redisManager; 
    
    /** 
     * 批量删除对应的value 
     *  
     * @param keys 
     */  
    @Override
    public void remove(final String... keys) {  
        for (String key : keys) {  
        	redisManager.del(key.getBytes());
        }  
    }  

    /** 
     * 批量删除key 
     *  
     * @param pattern 
     */  
    @Override
    public void removePattern(final String pattern) {  
    	if(StringUtils.isNotEmpty(pattern)) {
    		Set<byte[]> keys = redisManager.keys(pattern.getBytes());
            if (null != keys && keys.size() > 0) {
            	for (byte[] key : keys) {
            		redisManager.del(key);
				}
            } 
    	}
    }  

    /** 
     * 删除对应的value 
     * @param key 
     */  
    @Override
    public void remove(final String key) {  
    	if(StringUtils.isNotEmpty(key)) {
            if (exists(key)) {  
            	redisManager.del(key.getBytes());
            }
    	}
    }  

    /** 
     * 缓存是否存在
     * @param key 
     * @return 
     */  
    @Override
    public boolean exists(final String key) {  
    	if(StringUtils.isEmpty(key)) {
    		return false;
    	}
    	byte[] valueArr = redisManager.get(key.getBytes());
    	if(null != valueArr && valueArr.length > 0) {
    		return true;
    	}else {
    		return false;  
    	}
    }  

    /** 
     * 读取缓存 
     * @param key 
     * @return 
     */  
    @Override
    public Object get(final String key) {  
    	if(StringUtils.isEmpty(key)) {
    		return null;
    	}
    	
    	byte[] bytes = redisManager.get(key.getBytes());
    	if(null != bytes && bytes.length > 0) {
    		return ObjectUtil.toObject(bytes);
    	}else {
    		return null;
    	}
    }   

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    @Override
    public boolean set(final String key, Object value) {  
        boolean result = false;  
        try {  
        	if(StringUtils.isNotEmpty(key)) {
                redisManager.set(key.getBytes(), ObjectUtil.toByteArray(value),RedisConstant.REDIS_EXPIRE_TIME);
                result = true;  
        	}
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    } 

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */ 
    @Override
    public boolean set(final String key, Object value, int expireTime) {  
        boolean result = false;  
        try {  
        	 redisManager.set(key.getBytes(), ObjectUtil.toByteArray(value),expireTime);  
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }
    
    @Override
    public Set<byte[]> keys(String pattern) {
    	if(StringUtils.isEmpty(pattern)) {
    		return null;
    	}
    	
    	return redisManager.keys(pattern.getBytes());
    }
}
