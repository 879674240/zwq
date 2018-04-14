package com.xupt.dal.mapper;

import com.xupt.dal.model.UserinfoEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-13 20:10:41
 * @description: userinfo()
 */
@Repository
public interface UserinfoMapper {
    int insert(UserinfoEntity entity);
    int updateById(@Param("id") Integer id);
    UserinfoEntity getById(@Param("id") Integer id);
    UserinfoEntity query();
}
