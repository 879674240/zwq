package com.xupt.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.Tool.Base64Util;
import com.xupt.service.Tool.JedisUtil;
import com.xupt.service.Tool.MD5Util;
import com.xupt.service.Tool.TokenUtil;
import com.xupt.service.dto.LoginParam;
import com.xupt.service.dto.Payload;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.xupt.service.Tool.HMACSHA256Util.HMACSHA256;

@Service
public class UserinfoService {
    @Resource
    private UserinfoMapper userinfoMapper;
    @Resource
    JedisPool jedisPool;

    /**
     * 查询用户信息
     * @return
     */
    public UserinfoEntity queryByName(String name){
        UserinfoEntity userinfoEntity = userinfoMapper.queryByName(name);
        return userinfoEntity;
    }

    /**
     * 增加用户信息
     * @return
     */
    public int insert(UserinfoEntity userinfoEntity){
        int result = 0;
        String name = userinfoEntity.getName();
        String password = userinfoEntity.getPassword();
        try {
            List<UserinfoEntity> userinfoEntitys = userinfoMapper.query();
            for (UserinfoEntity userinfoEntityTemp:userinfoEntitys){
                if (name.equals(userinfoEntityTemp.getName())){
                    return -1;
                }
            }
            String temp = MD5Util.EncoderByMd5(userinfoEntity.getPassword());
            userinfoEntity.setPassword(temp);
            userinfoEntity.setType(0);
            result = userinfoMapper.insert(userinfoEntity);
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }

    /**
     * 修改密码
     * @param loginParam
     * @return
     */
    public int update(LoginParam loginParam) {
        Integer result = 0;
        UserinfoEntity userinfoEntity = userinfoMapper.queryByName(loginParam.getName());
        if (userinfoEntity != null) {
            if (loginParam.getPassword().equals(userinfoEntity.getPassword())){
                result = userinfoMapper.updateByName(loginParam.getName(),loginParam.getNewpassword());
                return result;
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }

    /**
     * token登录
     * @param loginParam
     * @return
     */
    public String loginToken(LoginParam loginParam){
        String token = TokenUtil.tokenCreat();
        try {
            UserinfoEntity userinfoEntity = userinfoMapper.queryByName(loginParam.getName());
            if(userinfoEntity==null){
                return "111";
            }
            if(MD5Util.EncoderByMd5(loginParam.getPassword()).equals(userinfoEntity.getPassword())){
                Jedis jedis = jedisPool.getResource();
                jedis.setex(token, 86400, loginParam.getName());
                jedis.close();
                return token;
            }else{
                return "000";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }
}
