package com.xupt.service.Tool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

public class JedisUtil {
    @Resource
    private static JedisPool jedisPool;

    //获取Jedis实例
    public synchronized static Jedis getJedis(){
        if(jedisPool != null){
            Jedis resource = jedisPool.getResource();
            return resource;
        }else{
            return null;
        }
    }

    //释放Jedis资源
    public static void returnResource(final Jedis jedis){
        if(jedis != null){
            jedisPool.returnResource(jedis);
        }
    }
    public void setKey(String key,Object value){
        Jedis jedis = getJedis();
        jedis.set(key.getBytes(),SerializeUtil.serialize(value));
    }
}
