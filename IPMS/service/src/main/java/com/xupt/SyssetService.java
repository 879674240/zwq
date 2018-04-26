package com.xupt;

import com.xupt.dal.mapper.SyssetMapper;
import com.xupt.dal.model.SyssetEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SyssetService {
    @Resource
    SyssetMapper syssetMapper;

    /**
     * 查询
     * @param
     * @return
     */
    public SyssetEntity query(){
        SyssetEntity syssetEntity = syssetMapper.query();
        return syssetEntity;
    }

    /**
     * 若存在，则修改；若不存在，则添加
     * @param syssetEntity
     * @return
     */
    public int update(SyssetEntity syssetEntity){
        int result = 0;
        if(syssetEntity.getId()==0){
            result = syssetMapper.insert(syssetEntity);
        }
        result = syssetMapper.update(syssetEntity);
        return result;
    }
}
