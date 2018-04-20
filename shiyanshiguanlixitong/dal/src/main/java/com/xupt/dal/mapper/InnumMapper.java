package com.xupt.dal.mapper;

import com.xupt.dal.model.InnumEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-16 21:42:06
 * @description: innum()
 */
@Repository
public interface InnumMapper {
    int insert(InnumEntity entity);
    List<InnumEntity> query(@Param("type") Integer type);
    List<InnumEntity> queryByOrder(@Param("type") Integer type,@Param("order")Integer order);
    InnumEntity queryById(@Param("id")Integer id);
    InnumEntity queryByKey(@Param("key")String key);
    int update(InnumEntity entity);
    int delete(@Param("id")Integer id);

}