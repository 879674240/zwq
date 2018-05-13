package com.xupt.dal.mapper;

import com.xupt.dal.model.FeessetEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-05-03 14:03:33
 * @description: feesset()
 */
public interface FeessetMapper {
    int insert(FeessetEntity entity);
    List<FeessetEntity> queryByCardtype(@Param("cardtype")String cardtype);
    int updateById(@Param("id") Integer id);
    FeessetEntity getById(@Param("id") Integer id);
}
