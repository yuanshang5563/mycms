package org.ys.redis.service;

import java.util.Set;

/**
 * 缓存存储接口
 * 
 * @author yclimb
 *
 */
public interface RedisCacheStorageService {
	
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
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, Object value);  

    /** 
     * 写入缓存 
     *  
     * @param key 
     * @param value 
     * @return 
     */  
    public boolean set(final String key, Object value, int expireTime) ;
    
    /**
     * 根据pattern查找集合
     * @param pattern
     * @return
     */
    public Set<byte[]> keys(String pattern);
}