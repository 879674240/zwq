package com.xupt.webapp.controller;

import com.xupt.component.BizException;
import com.xupt.component.PageResult;
import com.xupt.component.Response;
import com.xupt.dal.model.ExperimentalTaskEntity;
import com.xupt.service.ExperimentalTaskService;
import com.xupt.service.dto.ExperimentalTaskParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @RequestMapping(value = "/insert")
    public Response<Integer> insert(ExperimentalTaskEntity experimentalTaskEntity){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        response.setMessage("插入实验任务失败！");
        int result;
        try {
            result = experimentalTaskService.insert(experimentalTaskEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("插入实验任务失败！");
            }
        }
        response.setCode(1);
        response.setMessage("插入实验任务成功！");
        return response;
    }

    /**
     * 更新实验任务
     * @param experimentalTaskEntity
     * @return
     */
    @RequestMapping(value = "/update")
    public Response<Integer> update(ExperimentalTaskEntity experimentalTaskEntity){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        response.setMessage("更新实验任务失败！");
        int result;
        try {
            result = experimentalTaskService.update(experimentalTaskEntity);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("更新实验任务失败！");
            }
        }
        response.setCode(1);
        response.setMessage("更新实验任务成功！");
        return response;
    }

    /**
     * 分页查询
     * @param experimentalTaskParam
     * @return
     */
    @RequestMapping(value = "/queryByPage")
    public Response<PageResult<List<ExperimentalTaskEntity>>> queryByPage(ExperimentalTaskParam experimentalTaskParam){
        Response<PageResult<List<ExperimentalTaskEntity>>> response = new Response<>();
        response.setCode(0);
        response.setMessage("查询实验任务失败！");
        PageResult<List<ExperimentalTaskEntity>> pageResult = new PageResult<>();
        try {
            pageResult = experimentalTaskService.queryByPage(experimentalTaskParam);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("查询实验任务失败！");
            }
        }
        response.setData(pageResult);
        response.setCode(1);
        response.setMessage("查询实验任务成功！");
        return response;
    }

    /**
     * 删除实验任务
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete")
    public Response<Integer> delete(@RequestParam("id")Integer id){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        response.setMessage("删除实验任务失败！");
        int result;
        try {
            result = experimentalTaskService.delete(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("删除实验任务失败！");
            }
        }
        response.setCode(1);
        response.setMessage("删除实验任务成功！");
        return response;
    }

    /**
     * 获取实验任务
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryById")
    public Response<ExperimentalTaskEntity> queryById(@RequestParam("id")Integer id){
        Response<ExperimentalTaskEntity> response = new Response<>();
        response.setCode(0);
        response.setMessage("获取实验任务失败！");
        ExperimentalTaskEntity experimentalTaskEntity=null;
        try {
            experimentalTaskEntity = experimentalTaskService.queryById(id);
        }catch (Exception e){
            if (e instanceof BizException){
                response.setMessage("获取实验任务失败！");
            }
        }
        response.setData(experimentalTaskEntity);
        response.setCode(1);
        response.setMessage("获取实验任务成功！");
        return response;
    }
}
