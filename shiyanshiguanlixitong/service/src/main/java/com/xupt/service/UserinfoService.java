package com.xupt.service;

import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.UserinfoEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserinfoService {
    @Resource
    private UserinfoMapper userinfoMapper;
    public UserinfoEntity query(){
        UserinfoEntity userinfoEntity = userinfoMapper.query();
        return userinfoEntity;
    }
}
