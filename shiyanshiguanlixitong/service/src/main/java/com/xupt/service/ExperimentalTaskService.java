package com.xupt.service;

import java.util.List;
import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.dal.dto.ExperimentalTaskDTO;
import com.xupt.dal.mapper.ExperimentalTaskMapper;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.service.dto.ExperimentalTaskParam;
import com.xupt.service.dto.ListParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExperimentalTaskService {

    @Resource
    ExperimentalTaskMapper experimentalTaskMapper;
    /**
     * 增加实验任务
     * @param entity
     * @return
     */
    public int insert(ExperimentalTaskEntity entity) throws BizException {
        int result = 0;
        try {
            ExperimentalTaskEntity experimentalTaskEntity = new ExperimentalTaskEntity();
            experimentalTaskEntity = experimentalTaskMapper.queryByNum(entity.getNumberr());
            if(experimentalTaskEntity != null){
                return result;
            }
            result = experimentalTaskMapper.insert(entity);
        }catch (Exception e){
            throw new BizException("实验任务录入异常!");
        }
        return result;
    }

    /**
     * 修改实验任务
     * @param entity
     * @return
     * @throws BizException
     */
    public int update(ExperimentalTaskEntity entity) throws BizException {
        int result = 0;
        try{
            result = experimentalTaskMapper.update(entity);
        }catch (Exception e){
            throw new BizException("实验任务更新异常!");
        }
        return result;
    }

    /**
     * 按id查询实验任务
     * @param id
     * @return
     * @throws BizException
     */
    public ExperimentalTaskEntity queryById(@Param("id") Integer id) throws BizException {
        ExperimentalTaskEntity experimentalTaskEntity;
        try {
            experimentalTaskEntity = experimentalTaskMapper.queryById(id);
        }catch (Exception e){
            throw new BizException("查询实验任务异常!");
        }
        return experimentalTaskEntity;
    }

    /**
     * 分页查询实验任务录入
     * @param experimentalTaskParam
     * @return
     * @throws BizException
     */
    public PageResult<List<ExperimentalTaskEntity>> queryByPage(ExperimentalTaskParam experimentalTaskParam) throws BizException {
        PageResult<List<ExperimentalTaskEntity>> listPageResult = new PageResult<List<ExperimentalTaskEntity>>();
        List<ExperimentalTaskEntity> experimentalTaskEntities;
        int count;
        ExperimentalTaskDTO experimentalTaskDTO = new ExperimentalTaskDTO();
        BeanUtils.copyProperties(experimentalTaskParam,experimentalTaskDTO);
        experimentalTaskDTO.setOffSet((experimentalTaskParam.getCurrentPage()-1)*experimentalTaskParam.getPageSize());
        try {
            experimentalTaskEntities = experimentalTaskMapper.queryByPage(experimentalTaskDTO);
            count = experimentalTaskMapper.count(experimentalTaskDTO);
        }catch (Exception e){
            throw new BizException("查询实验任务失败！");
        }

        listPageResult.setData(experimentalTaskEntities);
        listPageResult.setCount(count);
        listPageResult.setCurrentPage(experimentalTaskParam.getCurrentPage());
        listPageResult.setPageSize(experimentalTaskParam.getPageSize());
        return listPageResult;
    }

    /**
     * 删除实验任务
     * @param idList
     * @return
     * @throws BizException
     */
    public int delete(List<Integer> idList) throws BizException {
        int result = 0;
        try {
            for(Integer id:idList){
                result = experimentalTaskMapper.delete(id);
            }
        }catch (Exception e){
            throw new BizException("删除实验任务失败！");
        }
        return result;
    }
}
