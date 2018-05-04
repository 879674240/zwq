package com.xupt;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring-context.xml"}) //加载配置文件
public class Test {

    //记得将Bean Autowired进来
    @Resource
    JedisPool jedisPool;

    @org.junit.Test
    public void webTest(){
        Jedis jedis = jedisPool.getResource();
        jedis.set("a","aaa");
        System.out.println(jedis.get("a"));
    }
}
