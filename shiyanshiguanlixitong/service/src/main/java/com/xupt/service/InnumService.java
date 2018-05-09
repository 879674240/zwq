package com.xupt.service;

import com.xupt.component.BizException;
import com.xupt.dal.mapper.ExperimentalTaskMapper;
import com.xupt.dal.mapper.ScheduleMapper;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.service.dto.*;
import com.xupt.dal.mapper.InnumMapper;
import com.xupt.dal.model.InnumEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class InnumService {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(InnumService.class);
    @Resource
    InnumMapper innumMapper;
    @Resource
    ExperimentalTaskMapper experimentalTaskMapper;
    @Resource
    ScheduleMapper scheduleMapper;
    /**
     * 增加实验室
     * @param innumEntity
     * @return
     */
    public Integer insertShiyanshi(InnumEntity innumEntity) throws BizException {
        int result;
        try {
            InnumEntity innumEntity1 = innumMapper.queryByValue(innumEntity.getValue());
            if(innumEntity1!=null){
                return 0;
            }
            innumEntity.setKey(innumEntity.getValue());
            innumEntity.setType("实验室");
            result = innumMapper.insert(innumEntity);
        }catch (Exception e){
            logger.debug("插入实验室异常!");
            throw new BizException("插入实验室异常!");
        }
        return result;
    }
    /**
     * 增加实验室编号
     * @param innumEntity
     * @return
     */
    public Integer insertClassroom(InnumEntity innumEntity) throws BizException {
        int result;
        try {
            InnumEntity innumEntity1 = innumMapper.queryByValue(innumEntity.getValue());
            if(innumEntity1!=null){
                return 0;
            }
            innumEntity.setKey(innumEntity.getValue());
            innumEntity.setType("教室编号");
            result = innumMapper.insert(innumEntity);
        }catch (Exception e){
            logger.debug("插入教室编号异常!");
            throw new BizException("插入教室编号异常!");
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
            InnumEntity innumEntity1 = new InnumEntity();
            innumEntity1.setId(innumEntity.getId());
            innumEntity1.setValue(innumEntity.getValue());
            innumEntity1.setKey(innumEntity.getValue());
            result = innumMapper.update(innumEntity1);
        }catch (Exception e){
            logger.debug("修改枚举类异常!");
            throw new BizException("修改枚举类异常!");
        }
        return result;
    }

    /**
     * 删除枚举类型
     * @param idList
     * @return
     */
    public Integer delete(List<Integer> idList) throws BizException{
        int result = 0;
        try {
            for(Integer id:idList){
                InnumEntity innumEntity = innumMapper.queryById(id);
                if("实验室".equals(innumEntity.getType())){
                    List<InnumEntity> innumEntities = innumMapper.queryByOrder("教室编号",id);
                    for(InnumEntity innumEntity1:innumEntities){
                        result = innumMapper.delete(innumEntity1.getId());
                    }
                }
                result = innumMapper.delete(id);
            }
        }catch (Exception e){
            logger.debug("删除枚举类异常!");
            throw new BizException("删除枚举类异常!");
        }
        return result;
    }

    /**
     * 查询该类型中所属类型的所有枚举类
     * @param innumParam
     * @return
     */
    public List<InnumClassroomDTO> queryByOrder(InnumParam innumParam) throws BizException{
        List<InnumClassroomDTO> innumClassroomDTOS = new ArrayList<>();
        try {
            List<InnumEntity> innumEntities = innumMapper.queryByOrder(innumParam.getType(),innumParam.getOrder());
            if("教室编号".equals(innumParam.getType())){
                for(InnumEntity innumEntity:innumEntities){
                    InnumClassroomDTO innumClassroomDTO = new InnumClassroomDTO();
                    InnumEntity innumEntity1 = innumMapper.queryById(innumEntity.getOrder());
                    BeanUtils.copyProperties(innumEntity,innumClassroomDTO);
                    innumClassroomDTO.setShiyanshi(innumEntity1.getValue());
                    innumClassroomDTOS.add(innumClassroomDTO);
                }
            }else{
                for(InnumEntity innumEntity:innumEntities){
                    InnumClassroomDTO innumClassroomDTO = new InnumClassroomDTO();
                    BeanUtils.copyProperties(innumEntity,innumClassroomDTO);
                    innumClassroomDTOS.add(innumClassroomDTO);
                }
            }

        }catch (Exception e){
            logger.debug("查找枚举类异常!");
            throw new BizException("查找枚举类异常!");
        }
        return innumClassroomDTOS;
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

    /**
     * 查询所有的枚举类，包括实验室，教室编号，课程
     * @return
     */
    public InnumAllDTO queryAll(){
        List<InnumEntity> innumEntities;
        InnumAllDTO innumAllDTO = new InnumAllDTO();
        List<InnumKechengDTO> innumKechengDTOS = new ArrayList<>();
        List<InnumSysDTO> bianhao = new ArrayList<>();
        innumEntities = innumMapper.queryAll();
        if (innumEntities==null){
            return null;
        }
        for(InnumEntity innumEntity:innumEntities){
           if(innumEntity.getType().equals("课程")){
                InnumKechengDTO innumKechengDTO = new InnumKechengDTO();
                String key = innumEntity.getKey();
                ExperimentalTaskEntity experimentalTaskEntity = experimentalTaskMapper.queryByNum(key);
                int time = 0;
                if(experimentalTaskEntity!=null){
                    time = experimentalTaskEntity.getHours();
                    innumKechengDTO.setClasss(experimentalTaskEntity.getClasss());
                    innumKechengDTO.setTeacher(experimentalTaskEntity.getTeacher());
                    innumKechengDTO.setStudentNum(experimentalTaskEntity.getStudentNum());
                    innumKechengDTO.setCompulsory(experimentalTaskEntity.getCompulsoryElective());
                }
                int hourCount = scheduleMapper.hourCount(key);
                BeanUtils.copyProperties(innumEntity,innumKechengDTO);
                innumKechengDTO.setTime(time);
                innumKechengDTO.setTimed(hourCount);
                innumKechengDTOS.add(innumKechengDTO);
            }else if(innumEntity.getType().equals("实验室")){
               InnumSysDTO innumSysDTO = new InnumSysDTO();
               BeanUtils.copyProperties(innumEntity,innumSysDTO);
                List<InnumEntity> innumEntities1 = innumMapper.queryByOrder("教室编号",innumEntity.getId());
                innumSysDTO.setInnumEntityList(innumEntities1);
                innumSysDTO.setInnumEntityList(null);
               bianhao.add(innumSysDTO);
            }
        }
        innumAllDTO.setKecheng(innumKechengDTOS);
        innumAllDTO.setHaoma(bianhao);
        return innumAllDTO;
    }

    /**
     * 根据实验室名称获取教室编号集合
     * @param shiyanshi
     * @return
     */
    public List<InnumEntity> queryByshiyanshi(String shiyanshi){
        List<InnumEntity> innumEntities = null;
        try {
            InnumEntity innumEntity = innumMapper.queryByValue(shiyanshi);
             innumEntities = innumMapper.queryByOrder("教室编号",innumEntity.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return innumEntities;
    }
}
