package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.component.Response;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.service.ExperimentalTaskService;
import com.xupt.service.dto.ExperimentalTaskParam;
import com.xupt.service.dto.ListParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "experi", description = "实验任务编排", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(value = "/api/experi")
public class ExperimentalTaskController {
    @Resource
    ExperimentalTaskService experimentalTaskService;

    /**
     * 插入实验任务
     * @param experimentalTaskEntity
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "插入实验任务", notes = "插入实验任务", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "实验任务",required = true) @RequestBody ExperimentalTaskEntity experimentalTaskEntity){
        Response<Integer> response = new Response<>();
        int result;
        try {
            result = experimentalTaskService.insert(experimentalTaskEntity);
            if(result==0){
                response.setMessage("该编号的实验任务已存在！");
                response.setCode(0);
            }else{
                response.setCode(1);
                response.setMessage("插入实验任务成功！");
            }
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("插入实验任务异常！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 更新实验任务
     * @param experimentalTaskEntity
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "更新实验任务", notes = "更新实验任务", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response<Integer> update(@ApiParam(value = "实验任务",required = true) @RequestBody ExperimentalTaskEntity experimentalTaskEntity){
        Response<Integer> response = new Response<>();
        int result;
        try {
            result = experimentalTaskService.update(experimentalTaskEntity);
            response.setCode(1);
            response.setMessage("更新实验任务成功！");
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("更新实验任务异常！");
            }
        }
        return response;
    }

    /**
     * 分页查询
     * @param experimentalTaskParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "分页查询", notes = "分页查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByPage",method = RequestMethod.POST)
    public Response<PageResult<List<ExperimentalTaskEntity>>> queryByPage(@ApiParam(value = "实验任务",required = true) @RequestBody ExperimentalTaskParam experimentalTaskParam){
        Response<PageResult<List<ExperimentalTaskEntity>>> response = new Response<>();
        PageResult<List<ExperimentalTaskEntity>> pageResult = new PageResult<>();
        try {
            pageResult = experimentalTaskService.queryByPage(experimentalTaskParam);
            response.setData(pageResult);
            response.setCode(1);
            response.setMessage("查询实验任务成功！");
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("查询实验任务异常！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 删除实验任务
     * @param listParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "删除实验任务", notes = "删除实验任务", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Response<Integer> delete(@ApiParam(value = "所删除id集合",required = true) @RequestBody ListParam listParam){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = experimentalTaskService.delete(listParam.getIdList());
            response.setCode(1);
            response.setData(result);
            response.setMessage("删除实验任务成功！");
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("删除实验任务失败！");
                response.setCode(0);
            }
        }
        return response;
    }

    /**
     * 获取实验任务
     * @param id
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "获取实验任务", notes = "获取实验任务", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryById",method = RequestMethod.POST)
    public Response<ExperimentalTaskEntity> queryById(@RequestParam("id")Integer id){
        Response<ExperimentalTaskEntity> response = new Response<>();
        ExperimentalTaskEntity experimentalTaskEntity=null;
        try {
            experimentalTaskEntity = experimentalTaskService.queryById(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setCode(0);
                response.setMessage("获取实验任务异常！");
            }
        }
        response.setData(experimentalTaskEntity);
        response.setCode(1);
        response.setMessage("获取实验任务成功！");
        return response;
    }
}
