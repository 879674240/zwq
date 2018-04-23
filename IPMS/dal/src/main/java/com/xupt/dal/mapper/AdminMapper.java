package com.xupt.dal.mapper;

import com.xupt.dal.dto.OperatorsDTO;
import com.xupt.dal.model.AdminEntity;
import com.xupt.dal.model.OperatorsEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 16:19:54
 * @description: admin()
 */
public interface AdminMapper {
    int insert(AdminEntity adminEntity);
    List<AdminEntity> query();
    AdminEntity queryByIdno(String idno);
    int update(AdminEntity adminEntity);
    int delete(@Param("id")Integer id);
}
