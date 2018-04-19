package com.xupt.service;

import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.dal.dto.LaboratoryAssetsDTO;
import com.xupt.dal.mapper.LaboratoryAssetsMapper;
import com.xupt.dal.model.LaboratoryAssetsEntity;
import com.xupt.service.dto.LaboratoryAssetsParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LaboratoryAssetsService {
    @Resource
    LaboratoryAssetsMapper laboratoryAssetsMapper;

    /**
     * 增加资产
     * @param entity
     * @return
     * @throws BizException
     */
    public int insert(LaboratoryAssetsEntity entity) throws  BizException{
        int result = 0;
        try {
            result = laboratoryAssetsMapper.insert(entity);
        }catch (Exception e){
            throw new BizException("资产录入时数据库异常!");
        }
        return result;
    }

    /**
     * 更新资产
     * @param entity
     * @return
     * @throws BizException
     */
    public int update(LaboratoryAssetsEntity entity) throws  BizException{
        int result = 0;
        try {
            result = laboratoryAssetsMapper.update(entity);
        }catch (Exception e){
            throw new BizException("资产更新时数据库异常!");
        }
        return result;
    }

    /**
     * 删除资产记录
     * @param id
     * @return
     * @throws BizException
     */
    public int delete(@Param("id")Integer id) throws BizException{
        int result = 0;
        try {
            result = laboratoryAssetsMapper.delete(id);
        }catch (Exception e){
            throw new BizException("删除资产时数据库异常!");
        }
        return result;
    }

    /**
     * 查询资产列表
     * @param laboratoryAssetsParam
     * @return
     */
    public PageResult<List<LaboratoryAssetsEntity>> query(LaboratoryAssetsParam laboratoryAssetsParam) throws BizException{
        PageResult<List<LaboratoryAssetsEntity>> pageResult = new PageResult<>();
        List<LaboratoryAssetsEntity> laboratoryAssetsEntities = null;
        int count = 0;
        LaboratoryAssetsDTO laboratoryAssetsDTO = new LaboratoryAssetsDTO();
        BeanUtils.copyProperties(laboratoryAssetsParam,laboratoryAssetsDTO);
        laboratoryAssetsDTO.setOffSet((laboratoryAssetsParam.getCurrentPage()-1)*laboratoryAssetsParam.getPageSize());
        try {
            laboratoryAssetsEntities = laboratoryAssetsMapper.query(laboratoryAssetsDTO);
            count = laboratoryAssetsMapper.count(laboratoryAssetsDTO);
        }catch (Exception e){
            throw new BizException("查询资产列表时数据库异常!");
        }
        pageResult.setCurrentPage(laboratoryAssetsParam.getCurrentPage());
        pageResult.setPageSize(laboratoryAssetsParam.getPageSize());
        pageResult.setCount(count);
        pageResult.setData(laboratoryAssetsEntities);
        return pageResult;
    }

    /**
     * 查询实验资产信息
     * @param id
     * @return
     * @throws BizException
     */
    public LaboratoryAssetsEntity queryById(@Param("id") Integer id) throws BizException{
        LaboratoryAssetsEntity laboratoryAssetsEntitie = null;
        try {
            laboratoryAssetsEntitie = laboratoryAssetsMapper.queryById(id);
        }catch (Exception e){
            throw new BizException("查询资产信息时数据库异常!");
        }
        return laboratoryAssetsEntitie;
    }
}
