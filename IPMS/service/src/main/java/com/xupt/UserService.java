package com.xupt;

import com.xupt.Tool.TokenUtil;
import com.xupt.dal.mapper.AdminMapper;
import com.xupt.dal.mapper.OperatorsMapper;
import com.xupt.dal.mapper.RootuserMapper;
import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.AdminEntity;
import com.xupt.dal.model.OperatorsEntity;
import com.xupt.dal.model.RootuserEntity;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.dto.AuthType;
import com.xupt.dto.LoginParam;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Resource
    RootuserMapper rootuserMapper;
    @Resource
    AdminMapper adminMapper;
    @Resource
    UserinfoMapper userinfoMapper;
    @Resource
    OperatorsMapper operatorsMapper;
    @Resource
    JedisPool jedisPool;

    public String loginToken(LoginParam loginParam) {
        String token = TokenUtil.tokenCreat();
        try {
            RootuserEntity rootuserEntity = rootuserMapper.queryByName(loginParam.getName());
            AdminEntity adminEntity = adminMapper.queryByName(loginParam.getName());
            OperatorsEntity operatorsEntity = operatorsMapper.queryByName(loginParam.getName());
            if (rootuserEntity != null) {
                if (loginParam.getPassword().equals(rootuserEntity.getPassword())) {
                    Jedis jedis = jedisPool.getResource();
                    jedis.setex(token, 1800, loginParam.getName());
                    jedis.close();
                    return token;
                }
            }
            if (adminEntity != null) {
                if (loginParam.getPassword().equals(adminEntity.getPasswd())) {
                    Jedis jedis = jedisPool.getResource();
                    jedis.setex(token, 1800, loginParam.getName());
                    jedis.close();
                    return token;
                }
            }
            if (operatorsEntity != null) {
                if (loginParam.getPassword().equals(operatorsEntity.getPasswd())) {
                    Jedis jedis = jedisPool.getResource();
                    jedis.setex(token, 1800, loginParam.getName());
                    jedis.close();
                    return token;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "000";
    }

    public int update(LoginParam loginParam) {
        Integer result = 0;
        RootuserEntity rootuserEntity = rootuserMapper.queryByName(loginParam.getName());
        AdminEntity adminEntity = adminMapper.queryByName(loginParam.getName());
        OperatorsEntity operatorsEntity = operatorsMapper.queryByName(loginParam.getName());
        if (rootuserEntity != null) {
            if (loginParam.getPassword().equals(rootuserEntity.getPassword())) {
                RootuserEntity rootuserEntity1 = new RootuserEntity();
                rootuserEntity1.setRoot(loginParam.getName());
                rootuserEntity1.setPassword(loginParam.getNewpassword());
                result = rootuserMapper.updateByName(rootuserEntity1);
                return result;
            }else{
                return 0;
            }
        }
        if (adminEntity != null) {
            if (loginParam.getPassword().equals(adminEntity.getPasswd())) {
                AdminEntity adminEntity1 = new AdminEntity();
                adminEntity1.setIdno(loginParam.getName());
                adminEntity1.setPasswd(loginParam.getNewpassword());
                result = adminMapper.updateByName(adminEntity1);
                return result;
            }else{
                return 0;
            }
        }
        if (operatorsEntity != null) {
            if (loginParam.getPassword().equals(operatorsEntity.getPasswd())) {
                OperatorsEntity operatorsEntity1 = new OperatorsEntity();
                operatorsEntity1.setIdno(loginParam.getName());
                operatorsEntity1.setPasswd(loginParam.getNewpassword());
                result = operatorsMapper.updateByName(operatorsEntity1);
                return result;
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }

    public long loginout(String authorization){
        Jedis jedis = jedisPool.getResource();
        long result = jedis.del(authorization);
        jedis.close();
        return result;
    }
    public AuthType authType(String temp){
        RootuserEntity rootuserEntity = rootuserMapper.queryByName(temp);
        AdminEntity adminEntity = adminMapper.queryByName(temp);
        OperatorsEntity operatorsEntity = operatorsMapper.queryByName(temp);
        if (rootuserEntity != null) {
            AuthType authType = new AuthType();
            authType.setName("root");
            List<String> strings = new ArrayList<>();
            strings.add("授权管理");
            authType.setValue(strings);
            return authType;
        }
        if (adminEntity != null) {
            AuthType authType = new AuthType();
            authType.setName("管理员");
            List<String> strings = new ArrayList<>();
            strings.add("操作员管理");
            strings.add("系统设置");
            authType.setValue(strings);
            return authType;
        }
        if (operatorsEntity != null) {
            AuthType authType = new AuthType();
            authType.setName("操作员");
            List<String> strings = new ArrayList<>();
            strings.add("档案管理");
            strings.add("停车管理");
            strings.add("收费管理");
            authType.setValue(strings);
            return authType;
        }
        return null;
    }
}
