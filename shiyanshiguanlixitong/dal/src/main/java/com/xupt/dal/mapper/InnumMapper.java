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
    List<InnumEntity> query(@Param("type") String type);
    List<InnumEntity> queryByOrder(@Param("type") String type,@Param("order")Integer order);
    InnumEntity queryById(@Param("id")Integer id);
    InnumEntity queryByKey(@Param("key")String key);
    InnumEntity queryByValue(@Param("value")String value);
    List<InnumEntity> queryAll();
    int update(InnumEntity entity);
    int delete(@Param("id")Integer id);

}