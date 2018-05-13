package com.xupt.Tool;

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

    public static void setKeyObj(String key,Object value){
        Jedis jedis = jedisPool.getResource();
        jedis.set(key.getBytes(),SerializeUtil.serialize(value));
        returnResource(jedis);
    }

    public static Object getKeyObj(String key){
        Jedis jedis = jedisPool.getResource();
        byte[] bytes = jedis.get(key.getBytes());
        Object object = SerializeUtil.unserialize(bytes);
        returnResource(jedis);
        return object;
    }

    public static void setKey(String key,int seconds,String value){
        Jedis jedis = jedisPool.getResource();
        jedis .setex(key,seconds, value);
        returnResource(jedis);
    }

    public static String getKey(String key){
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        returnResource(jedis);
        return value;
    }
    public static long delKey(String key){
        Jedis jedis = jedisPool.getResource();
        long result = jedis.del(key);
        returnResource(jedis);
        return result;
    }
}
