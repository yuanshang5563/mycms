package org.ys.redis.service;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * 缓存存储接口
 * 
 * @author yclimb
 *
 * @param <K> key
 * @param <V> value
 */
public interface RedisCacheStorageService<K, V> {
	
    /** 
     * 批量删除对应的value 
     *  
     * @param keys 
     */  
    public void remove(final String... keys);

    /** 
     * 批量删除key 
     *  
     * @param pattern 
     */  
    public void removePattern(final String pattern);  

    /** 
     * 删除对应的value 
     * @param key 
     */  
    public void remove(final String key);

    /** 
     * 缓存是否存在
     * @param key 
     * @return 
     */  
    public boolean exists(final String key); 

    /** 
     * 读取缓存 
     * @param key 
     * @return 
     */  
    public Object get(final String key);  

    /** 
     *  
     * @Author Ron
     * @param key 
     * @param hashKey 
     * @return 
     */  
    public Object get(final String key, final String hashKey); 

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, Object value);  

    /** 
     *  
     * @Author Ron 
     * @param key 
     * @param hashKey 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, final String hashKey, Object value); 

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, Object value, Long expireTime) ;
    
    /**
     * 根据pattern查找集合
     * @param pattern
     * @return
     */
    public Set<Serializable> keys(String pattern);
}