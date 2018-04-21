package com.xupt.dal.mapper;

import com.xupt.dal.dto.OperatorsDTO;
import com.xupt.dal.model.OperatorsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-21 20:01:18
 * @description: operators()
 */
@Repository
public interface OperatorsMapper {
    int insert(OperatorsEntity entity);
    List<OperatorsEntity> query(OperatorsDTO operatorsDTO);
    int count(OperatorsDTO operatorsDTO);
    OperatorsEntity queryByIdno(String idno);
    int updateById(@Param("id") Integer id);
    OperatorsEntity getById(@Param("id") Integer id);
}
