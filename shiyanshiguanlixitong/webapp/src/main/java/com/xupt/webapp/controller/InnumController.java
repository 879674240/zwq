package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.Response;
import com.xupt.dal.model.InnumEntity;
import com.xupt.service.InnumService;
import com.xupt.service.dto.KeyValueDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/innum/")
public class InnumController {
    @Resource
    InnumService innumService;
    /**
     * 增加枚举类型
     * @param innumEntity
     * @return
     */
    @RequestMapping(value = "insert")
    public Response<Integer> insert(InnumEntity innumEntity){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        int result = 0;
        try {
            result = innumService.insert(innumEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("插入失败！");
            }
        }
        response.setMessage("插入成功！");
        response.setCode(1);
        response.setData(result);
        return response;
    }

    /**
     * 修改枚举类型
     * @param innumEntity
     * @return
     */
    @RequestMapping(value = "update")
    public Response<Integer> update(InnumEntity innumEntity){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        int result = 0;
        try {
            result = innumService.update(innumEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("修改失败！");
            }
        }
        response.setMessage("修改成功！");
        response.setCode(1);
        response.setData(result);
        return response;
    }

    /**
     * 删除枚举类型
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    public Response<Integer> delete(Integer id){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        int result = 0;
        try {
            result = innumService.delete(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("删除失败！");
            }
        }
        response.setMessage("删除成功！");
        response.setCode(1);
        response.setData(result);
        return response;
    }

    /**
     * 查询该类型中所有枚举类
     * @param type
     * @return
     */
    @RequestMapping(value = "query")
    public Response<List<KeyValueDTO>> query(Integer type){
        Response<List<KeyValueDTO>> response = new Response<>();
        response.setCode(0);
       List<KeyValueDTO> keyValueDTOS = null;
        try {
            keyValueDTOS = innumService.query(type);
            if (keyValueDTOS ==null){
                response.setMessage("没有获取到数据！");
                return response;
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("获取数据失败！");
            }
        }
        response.setMessage("获取数据成功！");
        response.setCode(1);
        response.setData(keyValueDTOS);
        return response;
    }

    /**
     * 查询该类型中所属类型的所有枚举类
     * @param type
     * @return
     */
    @RequestMapping(value = "queryByOrder")
    public Response<List<KeyValueDTO>> queryByOrder(Integer type, Integer order){
        Response<List<KeyValueDTO>> response = new Response<>();
        response.setCode(0);
        List<KeyValueDTO> keyValueDTOS = null;
        try {
            keyValueDTOS = innumService.queryByOrder(type,order);
            if (keyValueDTOS ==null){
                response.setMessage("没有获取到数据！");
                return response;
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("获取数据失败！");
            }
        }
        response.setMessage("获取数据成功！");
        response.setCode(1);
        response.setData(keyValueDTOS);
        return response;
    }

    /**
     * 按id查询枚举类
     * @param id
     * @return
     */
    @RequestMapping(value = "queryById")
    public Response<InnumEntity> queryById(Integer id){
        Response<InnumEntity> response = new Response<>();
        response.setCode(0);
        InnumEntity innumEntitie = null;
        try {
            innumEntitie = innumService.queryById(id);
            if (innumEntitie ==null){
                response.setMessage("没有获取到数据！");
                return response;
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("获取数据失败！");
            }
        }
        response.setMessage("获取数据成功！");
        response.setCode(1);
        response.setData(innumEntitie);
        return response;
    }
}
