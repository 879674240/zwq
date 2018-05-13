package com.xupt.service;

import com.xupt.dal.mapper.OperationLogMapper;
import com.xupt.dal.model.OperationLogEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LogService {
    @Resource
    OperationLogMapper operationLogMapper;
    public int insert(OperationLogEntity operationLogEntity){
        int result = 0;
        try {
            result = operationLogMapper.insert(operationLogEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
