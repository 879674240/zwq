package com.xupt.webapp.controller;

import com.xupt.OperatorsService;
import com.xupt.common.PageResult;
import com.xupt.common.Response;
import com.xupt.dal.model.OperatorsEntity;
import com.xupt.dto.OperatorsParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/operators")
public class OperatorsController {
    @Resource
    OperatorsService operatorsService;
    @CrossOrigin("*")
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<PageResult<List<OperatorsEntity>>> query(@RequestBody OperatorsParam operatorsParam){
        Response<PageResult<List<OperatorsEntity>>> response = new Response<>();
        PageResult<List<OperatorsEntity>> pageResult = new PageResult<>();
        try {
            pageResult = operatorsService.query(operatorsParam);
            response.setData(pageResult);
            response.setCode(1);
            response.setMessage("返回操作人员信息成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询操作人员信息异常！");
        }

        return response;
    }
    @CrossOrigin("*")
    @RequestMapping(value = "insert",method=RequestMethod.POST)
    public Response<Integer> insert(@RequestBody OperatorsEntity operatorsEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = operatorsService.insert(operatorsEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该操作人员已经存在！");
            }else{
                response.setCode(0);
                response.setData(result);
                response.setMessage("添加成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("添加失败！");
        }
        return response;
    }
}
