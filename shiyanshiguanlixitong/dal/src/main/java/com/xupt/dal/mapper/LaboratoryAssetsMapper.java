package com.xupt.dal.mapper;

import com.xupt.dal.model.LaboratoryAssetsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-18 11:16:20
 * @description: laboratory_assets()
 */
public interface LaboratoryAssetsMapper {
    int insert(LaboratoryAssetsEntity entity);
    int updateById(@Param("id") Integer id);
    LaboratoryAssetsEntity getById(@Param("id") Integer id);

}
