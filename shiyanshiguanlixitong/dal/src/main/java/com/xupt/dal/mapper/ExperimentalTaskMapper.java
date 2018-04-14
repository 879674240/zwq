package com.xupt.dal.mapper;

import com.xupt.dal.model.ExperimentalTaskEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: lenovo
 * @time: 2018-04-13 20:10:41
 * @description: experimental_task()
 */
@Repository
public interface ExperimentalTaskMapper {
    int insert(ExperimentalTaskEntity entity);
    int updateById(@Param("id") Integer id);
    ExperimentalTaskEntity getById(@Param("id") Integer id);
}
