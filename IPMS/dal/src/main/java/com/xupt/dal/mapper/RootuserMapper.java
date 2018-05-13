package com.xupt.dal.mapper;

import com.xupt.dal.model.RootuserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-05-09 00:53:16
 * @description: rootuser()
 */
public interface RootuserMapper {
    int insert(RootuserEntity entity);
    int updateById(@Param("id") Integer id);
    RootuserEntity getById(@Param("id") Integer id);
    RootuserEntity queryByName(@Param("root")String root);
    int updateByName(RootuserEntity entity);
}
