package com.xupt;

import com.xupt.common.PageResult;
import com.xupt.dal.dto.CarinfoDTO;
import com.xupt.dal.mapper.CarinfoMapper;
import com.xupt.dal.model.CarinfoEntity;
import com.xupt.dto.CarinfoParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarinfoService {
    @Resource
    CarinfoMapper carinfoMapper;

    /**
     * 分页查询
     * @param carinfoParam
     * @return
     */
    public PageResult<List<CarinfoEntity>> query(CarinfoParam carinfoParam){
        PageResult<List<CarinfoEntity>> pageResult = new PageResult<>();
        CarinfoDTO carinfoDTO = new CarinfoDTO();
        BeanUtils.copyProperties(carinfoParam,carinfoDTO);
        carinfoDTO.setOffset((carinfoParam.getCurrentPage()-1)*carinfoParam.getPageSize());
        List<CarinfoEntity> carinfoEntities = carinfoMapper.query(carinfoDTO);
        int count = carinfoMapper.count(carinfoDTO);
        pageResult.setData(carinfoEntities);
        pageResult.setCount(count);
        pageResult.setCurrentPage(carinfoParam.getCurrentPage());
        pageResult.setPageSize(carinfoParam.getPageSize());
        return pageResult;
    }

    /**
     * 添加
     * @param carinfoEntity
     * @return
     */
    public int insert(CarinfoEntity carinfoEntity){
        int result = 0;
        CarinfoEntity carinfoEntity1 = carinfoMapper.queryByCardriverno(carinfoEntity.getCardriverno());
        if (carinfoEntity1!=null){
            return result;
        }
        result = carinfoMapper.insert(carinfoEntity);
        int result2 = carinfoMapper.update(carinfoEntity);
        return result+result2;
    }

    /**
     * 删除
     * @param idList
     * @return
     */
    public int deleteList(List<Integer> idList){
        int result = 0;
        int sum = 0;
        for(Integer id:idList){
            result = carinfoMapper.delete(id);
            sum += result;
        }
        return sum;
    }
}
