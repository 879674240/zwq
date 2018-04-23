package com.xupt.dal.mapper;

import com.xupt.dal.dto.UserinfoDTO;
import com.xupt.dal.model.UserinfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lenovo
 * @time: 2018-04-23 14:33:38
 * @description: userinfo()
 */
public interface UserinfoMapper {
    int insert(UserinfoEntity userinfoEntity);
    List<UserinfoEntity> query(UserinfoDTO userinfoDTO);
    int count(UserinfoDTO userinfoDTO);
    UserinfoEntity queryByIdno(String idno);
    int update(UserinfoEntity entity);
    int delete(@Param("id")Integer id);
}
