package com.xupt.service;

import com.xupt.component.PageResult;
import com.xupt.dal.dto.ExperimentalTaskDTO;
import com.xupt.dal.dto.StatisticsDTO;
import com.xupt.dal.mapper.ExperimentalTaskMapper;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.service.dto.ExperimentalTaskParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Resource
    ExperimentalTaskMapper experimentalTaskMapper;

    public PageResult<List<StatisticsDTO>> query(ExperimentalTaskParam experimentalTaskParam){
        PageResult<List<StatisticsDTO>> pageResult = new PageResult<>();
        List<StatisticsDTO> statisticsDTOS = new ArrayList<>();
        ExperimentalTaskDTO experimentalTaskDTO = new ExperimentalTaskDTO();
        BeanUtils.copyProperties(experimentalTaskParam,experimentalTaskDTO);
        List<ExperimentalTaskEntity> experimentalTaskEntities = experimentalTaskMapper.queryByPage(experimentalTaskDTO);
        int cout = experimentalTaskMapper.count(experimentalTaskDTO);
        for(ExperimentalTaskEntity experimentalTaskEntity:experimentalTaskEntities){
            StatisticsDTO statisticsDTO = new StatisticsDTO();
            statisticsDTO.setHours(experimentalTaskEntity.getHours());
            statisticsDTO.setStudentNum(experimentalTaskEntity.getStudentNum());
            statisticsDTO.setTotalHours(experimentalTaskEntity.getReserve1());
            statisticsDTO.setNum(experimentalTaskEntity.getNumberr());
            statisticsDTOS.add(statisticsDTO);
        }
        pageResult.setData(statisticsDTOS);
        pageResult.setCount(cout);
        pageResult.setCurrentPage(experimentalTaskParam.getCurrentPage());
        pageResult.setPageSize(experimentalTaskParam.getPageSize());
        return  pageResult;
    }
}
