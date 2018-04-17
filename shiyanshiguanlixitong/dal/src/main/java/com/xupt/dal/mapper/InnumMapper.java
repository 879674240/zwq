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
    InnumEntity queryById(@Param("id")Integer id);
    int update(InnumEntity entity);
    int delete(@Param("id")Integer id);

}
