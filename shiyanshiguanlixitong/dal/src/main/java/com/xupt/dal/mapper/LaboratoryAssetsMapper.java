package com.xupt.dal.mapper;

import com.xupt.dal.dto.LaboratoryAssetsDTO;
import com.xupt.dal.model.LaboratoryAssetsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-18 11:16:20
 * @description: laboratory_assets()
 */
@Repository
public interface LaboratoryAssetsMapper {
    int insert(LaboratoryAssetsEntity entity);
    int update(LaboratoryAssetsEntity entity);
    int delete(@Param("id")Integer id);
    List<LaboratoryAssetsEntity> query(LaboratoryAssetsDTO laboratoryAssetsDTO);
    LaboratoryAssetsEntity queryById(@Param("id") Integer id);
    LaboratoryAssetsEntity queryBynum(@Param("num") String num);
    int count(LaboratoryAssetsDTO laboratoryAssetsDTO);
}
