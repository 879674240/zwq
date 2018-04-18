package com.xupt.service;

import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.UserinfoEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserinfoService {
    @Resource
    private UserinfoMapper userinfoMapper;
    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserinfoEntity> query(){
        List<UserinfoEntity> userinfoEntitys = userinfoMapper.query();
        return userinfoEntitys;
    }

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
        try {
             result = userinfoMapper.insert(userinfoEntity);
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }

    public int update(String name,String password){
        int result = 0;
        try {
            result = userinfoMapper.updateByName(name,password);
        }catch (Exception e){
            e.getStackTrace();
        }
        return result;
    }
}
