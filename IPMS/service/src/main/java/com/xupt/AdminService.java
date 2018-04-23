package com.xupt;

import com.xupt.dal.mapper.AdminMapper;
import com.xupt.dal.model.AdminEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;

    /**
     * 添加
     * @param adminEntity
     * @return
     */
    public int insert(AdminEntity adminEntity){
        int result = 0;
        AdminEntity adminEntity1 = adminMapper.queryByIdno(adminEntity.getIdno());
        if (adminEntity1!=null){
            return result;
        }
        result =  adminMapper.insert(adminEntity);
        return result;
    }

    /**
     * 查询
     * @param
     * @return
     */
    public List<AdminEntity> query(){

        List<AdminEntity> adminEntities = adminMapper.query();
        return adminEntities;
    }

    /**
     * 更新
     * @param adminEntity
     * @return
     */
    public int update(AdminEntity adminEntity){
        int result = 0;
        result = adminMapper.update(adminEntity);
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id){
        int result = 0;
        result = adminMapper.delete(id);
        return result;
    }

    /**
     * 批量删除
     * @param idList
     * @return
     */
    public int deleteList(List<Integer> idList){
        int result = 0;
        int sum = 0;
        for (Integer id:idList){
            result = adminMapper.delete(id);
            sum +=result;
        }
        return sum;
    }

}
