package com.xupt.service.Tool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

public abstract class JedisUtil {
    @Resource
    private static JedisPool jedisPool;

    //获取Jedis实例
    public synchronized static final Jedis getJedis(){
        if(jedisPool != null){
            Jedis resource = jedisPool.getResource();
            return resource;
        }else{
            return null;
        }
    }

    //释放Jedis资源
    public static final void returnResource(Jedis jedis){
        if(jedis != null){
            jedisPool.returnResource(jedis);
        }
    }

    public void setKeyObj(String key,Object value){
        Jedis jedis = getJedis();
        jedis.set(key.getBytes(),SerializeUtil.serialize(value));
        returnResource(jedis);
    }

    public Object getKeyObj(String key){
        Jedis jedis = getJedis();
        byte[] bytes = jedis.get(key.getBytes());
        Object object = SerializeUtil.unserialize(bytes);
        returnResource(jedis);
        return object;
    }

    public void setKey(String key,String value){
        Jedis jedis = getJedis();
        jedis.set(key,value);
        returnResource(jedis);
    }

    public String getKey(String key){
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        returnResource(jedis);
        return value;
    }
}
