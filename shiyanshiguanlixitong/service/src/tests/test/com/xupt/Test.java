package com.xupt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xupt.service.dto.TableDTO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.*;
import java.util.List;

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
    @org.junit.Test
    public void jsonTest(){
        String laststr="";
        String path = "D:\\data.txt";
        File file=new File(path);// 打开文件
        BufferedReader reader=null;
        try{
            FileInputStream in = new FileInputStream(file);
            reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));// 读取文件
            String tempString=null;
            while((tempString=reader.readLine())!=null){
                laststr=laststr+tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException el){
                }
            }
        }
        JSONArray jsonArray = JSONArray.parseArray(laststr);
        List<TableDTO> tableDTOS = jsonArray.toJavaList(TableDTO.class);
        if(jsonArray.size()>0){
            for(int i=0;i<jsonArray.size();i++){
                JSONObject job = jsonArray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                System.out.println(job.get("name")+"=") ;  // 得到 每个对象中的属性值
            }
        }

        System.out.println(laststr);
    }
}
