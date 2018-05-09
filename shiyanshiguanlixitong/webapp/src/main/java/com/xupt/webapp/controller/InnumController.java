package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.Response;
import com.xupt.service.dto.*;
import com.xupt.dal.model.InnumEntity;
import com.xupt.service.InnumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "innum", description = "实验任务枚举类", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value = "/api/innum/")
public class InnumController {
    @Resource
    InnumService innumService;
    /**
     * 增加实验室
     * @param innumEntity
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "增加实验室", notes = "增加实验室", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertShiyanshi",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "枚举类实体",required = true) @RequestBody InnumEntity innumEntity){
        Response<Integer> response = new Response<>();

        int result = 0;
        try {
            result = innumService.insertShiyanshi(innumEntity);
            if(result==0){
                response.setMessage("该实验室已经存在！");
                response.setCode(1);
            }else{
                response.setMessage("插入成功！");
                response.setCode(1);
                response.setData(result);
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("插入失败！");
                response.setCode(0);
            }
        }
        return response;
    }
    /**
     * 增加实验室编号
     * @param innumEntity
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "增加实验室编号", notes = "增加实验室编号", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insertClassroom",method = RequestMethod.POST)
    public Response<Integer> insertClassroom(@ApiParam(value = "枚举类实体",required = true) @RequestBody InnumEntity innumEntity){
        Response<Integer> response = new Response<>();

        int result = 0;
        try {
            result = innumService.insertClassroom(innumEntity);
            if(result==0){
                response.setMessage("该实验室编号已经存在！");
                response.setCode(1);
            }else{
                response.setMessage("插入成功！");
                response.setCode(1);
                response.setData(result);
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("插入失败！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 修改实验室或者教室
     * @param innumEntity
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "修改实验室或者教室", notes = "修改实验室或者教室", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateShiyanshi",method = RequestMethod.POST)
    public Response<Integer> updateShiyanshi(@ApiParam(value = "枚举类实体",required = true) @RequestBody InnumEntity innumEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = innumService.update(innumEntity);
            response.setMessage("修改成功！");
            response.setCode(1);
            response.setData(result);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("修改失败！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 删除枚举类型
     * @param listParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "删除枚举类", notes = "删除枚举类", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "id列表",required = true) @RequestBody ListParam listParam){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = innumService.delete(listParam.getIdList());
            response.setMessage("删除成功！");
            response.setCode(1);
            response.setData(result);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("删除失败！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 查询该类型中所属类型的所有枚举类
     * @param innumParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "查询该类型中所属类型的所有枚举类", notes = "查询该类型中所属类型的所有枚举类", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByOrder",method = RequestMethod.POST)
    public Response<List<InnumClassroomDTO>> queryByOrder(@ApiParam(value = "id列表",required = true) @RequestBody InnumParam innumParam){
        Response<List<InnumClassroomDTO>> response = new Response<>();
        List<InnumClassroomDTO> innumClassroomDTOS = null;
        try {
            innumClassroomDTOS = innumService.queryByOrder(innumParam);
            response.setMessage("获取数据成功！");
            response.setCode(1);
            response.setData(innumClassroomDTOS);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("获取数据失败！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 按id查询枚举类
     * @param id
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "按id查询枚举类", notes = "按id查询枚举类", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryById",method = RequestMethod.POST)
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

    /**
     * 查询所有枚举类
     * @param
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "查询所有枚举类", notes = "查询所有枚举类", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryAll",method = RequestMethod.POST)
    public Response<InnumAllDTO> queryAll(){
        Response<InnumAllDTO> response = new Response<>();
        InnumAllDTO innumAllDTO = null;
        try {
            innumAllDTO = innumService.queryAll();
            if (innumAllDTO ==null){
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
        response.setData(innumAllDTO);
        return response;
    }

    /**
     * 查询所有枚举类
     * @param
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "按实验室查询教室编号", notes = "按实验室查询教室编号", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByshiyanshi",method = RequestMethod.POST)
    public Response<List<InnumEntity>> queryByshiyanshi(@ApiParam(value = "实验室名称",required = true) @RequestBody InnumshiyanshiDTO innumshiyanshiDTO){
        Response<List<InnumEntity>> response = new Response<>();
        List<InnumEntity> innumEntities = null;
        try {
            innumEntities = innumService.queryByshiyanshi(innumshiyanshiDTO.getShiyanshi());
            if (innumEntities ==null){
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
        response.setData(innumEntities);
        return response;
    }
}
