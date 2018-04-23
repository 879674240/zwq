package com.xupt;

import com.xupt.common.PageResult;
import com.xupt.dal.dto.UserinfoDTO;
import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.dto.UserinfoParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserinfoService {
    @Resource
    UserinfoMapper userinfoMapper;

    /**
     * 添加
     * @param userinfoEntity
     * @return
     */
    public int insert(UserinfoEntity userinfoEntity){
        int result = 0;
        UserinfoEntity userinfoEntity1 = userinfoMapper.queryByIdno(userinfoEntity.getIdno());
        if (userinfoEntity1!=null){
            return result;
        }
        result =  userinfoMapper.insert(userinfoEntity);
        return result;
    }

    /**
     * 分页查询
     * @param userinfoParam
     * @return
     */
    public PageResult<List<UserinfoEntity>> query(UserinfoParam userinfoParam){
        PageResult<List<UserinfoEntity>> pageResult = new PageResult<>();
        UserinfoDTO userinfoDTO = new UserinfoDTO();
        BeanUtils.copyProperties(userinfoParam,userinfoDTO);
        userinfoDTO.setOffset((userinfoParam.getCurrentPage()-1)*userinfoParam.getPageSize());
        List<UserinfoEntity> userinfoEntities = userinfoMapper.query(userinfoDTO);
        int count = userinfoMapper.count(userinfoDTO);
        int pageCount = 0;
        pageCount = (count/userinfoParam.getPageSize())+1;
        pageResult.setData(userinfoEntities);
        pageResult.setCount(count);
        pageResult.setCurrentPage(userinfoParam.getCurrentPage());
        pageResult.setPageSize(userinfoParam.getPageSize());
        pageResult.setPageCount(pageCount);
        return pageResult;
    }

    /**
     * 更新
     * @param userinfoEntity
     * @return
     */
    public int update(UserinfoEntity userinfoEntity){
        int result = 0;
        result = userinfoMapper.update(userinfoEntity);
        return result;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(Integer id){
        int result = 0;
        result = userinfoMapper.delete(id);
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
            result = userinfoMapper.delete(id);
            sum +=result;
        }
        return sum;
    }

    /**
     * 重置密码
     * @param userinfoEntity
     * @return
     */
    public int updatePawd(UserinfoEntity userinfoEntity){
        int result = 0;
        userinfoEntity.setPasswd("111111");
        result = userinfoMapper.update(userinfoEntity);
        return result;
    }
}
