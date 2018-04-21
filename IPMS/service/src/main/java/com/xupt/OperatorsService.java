package com.xupt;

import com.xupt.common.PageResult;
import com.xupt.dal.dto.OperatorsDTO;
import com.xupt.dal.mapper.OperatorsMapper;
import com.xupt.dal.model.OperatorsEntity;
import com.xupt.dto.OperatorsParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperatorsService {
    @Resource
    OperatorsMapper operatorsMapper;

    public int insert(OperatorsEntity operatorsEntity){
        int result = 0;
        OperatorsEntity operatorsEntity1 = operatorsMapper.queryByIdno(operatorsEntity.getIdno());
        if (operatorsEntity1!=null){
            return result;
        }
        result =  operatorsMapper.insert(operatorsEntity);
        return result;
    }
    public PageResult<List<OperatorsEntity>> query(OperatorsParam operatorsParam){
        PageResult<List<OperatorsEntity>> pageResult = new PageResult<>();
        OperatorsDTO operatorsDTO = new OperatorsDTO();
        BeanUtils.copyProperties(operatorsParam,operatorsDTO);
        operatorsDTO.setOffset((operatorsParam.getCurrentPage()-1)*operatorsParam.getPageSize());
        List<OperatorsEntity> operatorsEntities = operatorsMapper.query(operatorsDTO);
        int count = operatorsMapper.count(operatorsDTO);
        pageResult.setData(operatorsEntities);
        pageResult.setCount(count);
        pageResult.setCurrentPage(operatorsParam.getCurrentPage());
        pageResult.setPageSize(operatorsParam.getPageSize());
        return pageResult;
    }
}
