package com.xupt.dal.mapper;

import com.xupt.dal.dto.ExperimentalTaskDTO;
import com.xupt.dal.model.ExperimentalTaskEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


/**
 * @author: lenovo
 * @time: 2018-04-13 20:10:41
 * @description: experimental_task()
 */
@Repository
public interface ExperimentalTaskMapper {
    int insert(ExperimentalTaskEntity entity);
    int update(ExperimentalTaskEntity entity);
    ExperimentalTaskEntity queryById(@Param("id") Integer id);
    List<ExperimentalTaskEntity> queryByPage(ExperimentalTaskDTO experimentalTaskDTO);
    int delete(@Param("id") Integer id);
    int count(ExperimentalTaskDTO experimentalTaskDTO);
}
