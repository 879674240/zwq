package com.xupt.dal.mapper;

import com.xupt.dal.model.InnumEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-16 21:42:06
 * @description: innum()
 */
public interface InnumMapper {
    int insert(InnumEntity entity);
    int updateById(@Param("id") Integer id);
    InnumEntity getById(@Param("id") Integer id);
    InnumEntity query(@Param("type") Integer type);
}
