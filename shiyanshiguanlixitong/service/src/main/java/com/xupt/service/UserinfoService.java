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
    public List<UserinfoEntity> query(){
        List<UserinfoEntity> userinfoEntitys = userinfoMapper.query();
        return userinfoEntitys;
    }
}
