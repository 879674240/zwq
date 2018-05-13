package com.xupt.dal.mapper;

import com.xupt.dal.model.OperationLogEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.sql.Timestamp;

/**
 * @author: lenovo
 * @time: 2018-05-13 16:53:53
 * @description: operation_log()
 */
public interface OperationLogMapper {
    int insert(OperationLogEntity entity);
    int updateById(@Param("id") Integer id);
    OperationLogEntity getById(@Param("id") Integer id);
}
