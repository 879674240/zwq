package com.xupt.dal.mapper;

import com.xupt.dal.model.SyssetEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 16:37:02
 * @description: sysset()
 */
public interface SyssetMapper {
    int insert(SyssetEntity entity);
    SyssetEntity query();
    SyssetEntity queryBydId(@Param("id")Integer id);
    int update(SyssetEntity syssetEntity);
}
