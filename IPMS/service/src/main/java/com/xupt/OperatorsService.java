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

    /**
     * 添加
     * @param operatorsEntity
     * @return
     */
    public int insert(OperatorsEntity operatorsEntity){
        int result = 0;
        OperatorsEntity operatorsEntity1 = operatorsMapper.queryByIdno(operatorsEntity.getIdno());
        if (operatorsEntity1!=null){
            return result;
        }
        result =  operatorsMapper.insert(operatorsEntity);
        return result;
    }

    /**
     * 分页查询
     * @param operatorsParam
     * @return
     */
    public PageResult<List<OperatorsEntity>> query(OperatorsParam operatorsParam){
        PageResult<List<OperatorsEntity>> pageResult = new PageResult<>();
        OperatorsDTO operatorsDTO = new OperatorsDTO();
        BeanUtils.copyProperties(operatorsParam,operatorsDTO);
        operatorsDTO.setOffset((operatorsParam.getCurrentPage()-1)*operatorsParam.getPageSize());
        List<OperatorsEntity> operatorsEntities = operatorsMapper.query(operatorsDTO);
        int count = operatorsMapper.count(operatorsDTO);
        int pageCount = 0;
        pageCount = (count/operatorsParam.getPageSize())+1;
        pageResult.setData(operatorsEntities);
        pageResult.setCount(count);
        pageResult.setCurrentPage(operatorsParam.getCurrentPage());
        pageResult.setPageSize(operatorsParam.getPageSize());
        pageResult.setPageCount(pageCount);
        return pageResult;
    }

    /**
     * 更新
     * @param operatorsEntity
     * @return
     */
    public int update(OperatorsEntity operatorsEntity){
        int result = 0;
        result = operatorsMapper.update(operatorsEntity);
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id){
        int result = 0;
        result = operatorsMapper.delete(id);
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
            result = operatorsMapper.delete(id);
            sum +=result;
        }
        return sum;
    }

    /**
     * 重置密码
     * @param operatorsEntity
     * @return
     */
    public int updatePawd(OperatorsEntity operatorsEntity){
        int result = 0;
        operatorsEntity.setPasswd("111111");
        result = operatorsMapper.update(operatorsEntity);
        return result;
    }

}
