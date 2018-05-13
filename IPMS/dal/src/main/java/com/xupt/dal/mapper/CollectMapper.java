package com.xupt.dal.mapper;

import com.xupt.dal.model.CollectEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Date;

/**
 * @author: lenovo
 * @time: 2018-05-03 15:32:42
 * @description: collect()
 */
public interface CollectMapper {
    int insert(CollectEntity entity);
    int updateByCarnum(CollectEntity collectEntity);
    int deleteByCarnum(@Param("carnum")String carnum);
    CollectEntity getById(@Param("id") Integer id);
    CollectEntity queryByCarnum(@Param("carnum")String carnum);
}
