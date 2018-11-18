package org.ys.redis.service.impl;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.ys.redis.service.RedisCacheStorageService;

/**
 * redis 缓存存储器实现
 * @author yclimb
 *
 * @param <V>
 */
@Service("redisCacheStorageService")
public class RedisCacheStorageServiceImpl<V> implements RedisCacheStorageService<String, V> {
	
    @Autowired  
    private RedisTemplate<Serializable, Object> redisTemplate; 
    
    /** 
     * 批量删除对应的value 
     *  
     * @param keys 
     */  
    @Override
    public void remove(final String... keys) {  
        for (String key : keys) {  
            remove(key);  
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
            Set<Serializable> keys = redisTemplate.keys(pattern);  
            if (null != keys && keys.size() > 0) {
            	redisTemplate.delete(keys);
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
                redisTemplate.delete(key);  
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
        return redisTemplate.hasKey(key);  
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
        Object result = null;  
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
        result = operations.get(key);  
        return result;  
    }  

    /** 
     *  
     * @Author Ron
     * @param key 
     * @param hashKey 
     * @return 
     */  
    @Override
    public Object get(final String key, final String hashKey){  
        Object result = null;  
        HashOperations<Serializable,Object,Object> operations = redisTemplate.opsForHash();  
        result = operations.get(key, hashKey);  
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
    public boolean set(final String key, Object value) {  
        boolean result = false;  
        try {  
        	if(StringUtils.isNotEmpty(key)) {
                ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
                operations.set(key, value);  
                result = true;  
        	}
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  

    /** 
     *  
     * @Author Ron 
     * @param key 
     * @param hashKey 
     * @param value 
     * @return 
     */  
    @Override
    public boolean set(final String key, final String hashKey, Object value) {  
        boolean result = false;  
        try {  
            HashOperations<Serializable,Object,Object> operations = redisTemplate.opsForHash();  
            operations.put(key, hashKey, value);  
            result = true;  
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
    public boolean set(final String key, Object value, Long expireTime) {  
        boolean result = false;  
        try {  
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();  
            operations.set(key, value);  
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);  
            result = true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
    }
    
    @Override
    public Set<Serializable> keys(String pattern) {
    	if(StringUtils.isEmpty(pattern)) {
    		return null;
    	}
    	return redisTemplate.keys(pattern);
    }
}
