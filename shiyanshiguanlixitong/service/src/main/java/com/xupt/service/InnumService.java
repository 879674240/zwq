package com.xupt.service;

import com.xupt.component.BizException;
import com.xupt.dal.mapper.InnumMapper;
import com.xupt.dal.model.InnumEntity;
import com.xupt.service.dto.KeyValueDTO;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InnumService {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(InnumService.class);
    @Resource
    InnumMapper innumMapper;
    /**
     * 增加枚举类型
     * @param innumEntity
     * @return
     */
    public Integer insert(InnumEntity innumEntity) throws BizException {
        int result;
        try {

            result = innumMapper.insert(innumEntity);
        }catch (Exception e){
            logger.debug("插入枚举类异常!");
            throw new BizException("插入枚举类异常!");
        }
        return result;
    }

    /**
     * 修改枚举类型
     * @param innumEntity
     * @return
     */
    public Integer update(InnumEntity innumEntity) throws BizException{
        int result;
        try {
            result = innumMapper.update(innumEntity);
        }catch (Exception e){
            logger.debug("修改枚举类异常!");
            throw new BizException("修改枚举类异常!");
        }
        return result;
    }

    /**
     * 删除枚举类型
     * @param id
     * @return
     */
    public Integer delete(Integer id) throws BizException{
        int result;
        try {
            result = innumMapper.delete(id);
        }catch (Exception e){
            logger.debug("删除枚举类异常!");
            throw new BizException("删除枚举类异常!");
        }
        return result;
    }

    /**
     * 查询该类型中所有枚举类
     * @param type
     * @return
     */
    public List<KeyValueDTO> query(Integer type) throws BizException{
        List<InnumEntity> innumEntities;
        List<KeyValueDTO> keyValueDTOS = new ArrayList<>();
        try {
            innumEntities = innumMapper.query(type);
        }catch (Exception e){
            logger.debug("查找枚举类异常!");
            throw new BizException("查找枚举类异常!");
        }
        for (InnumEntity innumEntity:innumEntities){
            KeyValueDTO keyValueDTO = new KeyValueDTO();
            keyValueDTO.setKey(innumEntity.getKey());
            keyValueDTO.setValue(innumEntity.getValue());
            keyValueDTOS.add(keyValueDTO);
        }
        return keyValueDTOS;
    }
    /**
     * 查询该类型中所属类型的所有枚举类
     * @param type
     * @return
     */
    public List<KeyValueDTO> queryByOrder(Integer type, Integer order) throws BizException{
        List<InnumEntity> innumEntities;
        List<KeyValueDTO> keyValueDTOS = new ArrayList<>();
        try {
            innumEntities = innumMapper.queryByOrder(type,order);
        }catch (Exception e){
            logger.debug("查找枚举类异常!");
            throw new BizException("查找枚举类异常!");
        }
        for (InnumEntity innumEntity:innumEntities){
            KeyValueDTO keyValueDTO = new KeyValueDTO();
            keyValueDTO.setKey(innumEntity.getKey());
            keyValueDTO.setValue(innumEntity.getValue());
            keyValueDTOS.add(keyValueDTO);
        }
        return keyValueDTOS;
    }

    /**
     * 按id查询枚举类
     * @param id
     * @return
     */
    public InnumEntity queryById(Integer id) throws BizException{
       InnumEntity innumEntity;
        try {
            innumEntity = innumMapper.queryById(id);
        }catch (Exception e){
            logger.debug("查找枚举类异常!");
            throw new BizException("查找枚举类异常!");
        }
        return innumEntity;
    }
}
