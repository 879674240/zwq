package com.xupt.webapp.controller;

import com.xupt.common.Response;
import com.xupt.dal.model.FeessetEntity;
import com.xupt.dto.CarnumParam;
import com.xupt.FeeManageService;
import com.xupt.dto.PreStopDTO;
import com.xupt.dto.TempStopDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "feeManage", description = "收费管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/feeManage")
public class FeeManageController {
    @Resource
    FeeManageService feeManageService;

    @CrossOrigin("*")
    @ApiOperation(value = "添加收费设置", notes = "添加收费设置", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "配置信息",required = true) @RequestBody FeessetEntity feessetEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = feeManageService.insertFeeset(feessetEntity);
            response.setCode(1);
            response.setData(result);
            response.setMessage("添加成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("添加失败！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "临时停车查询", notes = "临时停车查询", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/tempStop",method=RequestMethod.POST)
    public Response<TempStopDTO> tempStop(@ApiParam(value = "信息",required = true) @RequestBody CarnumParam carnumParam){
        Response<TempStopDTO> response = new Response<>();
        TempStopDTO tempStopDTO;
        try {
            tempStopDTO = feeManageService.tempStop(carnumParam.getCarnum());
            if(tempStopDTO.getCarnum().equals("-1")){
                response.setCode(0);
                response.setMessage("该车辆为固定车辆收费！");
            }else{
                response.setCode(1);
                response.setData(tempStopDTO);
                response.setMessage("查询成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询失败！");
        }
        return response;
    }
    @CrossOrigin("*")
    @ApiOperation(value = "临时停车结算", notes = "临时停车结算", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/tempCal",method=RequestMethod.POST)
    public Response<Integer> tempCal(@ApiParam(value = "信息",required = true) @RequestBody CarnumParam carnumParam){
        Response<Integer> response = new Response<>();
        int result;
        try {
            result = feeManageService.tempCal(carnumParam.getCarnum());
            if(result==0){
                response.setCode(0);
                response.setMessage("车费余额不足，请充值！");
            }else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("结算成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("结算异常！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "固定停车结算", notes = "固定停车结算", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/preCal",method=RequestMethod.POST)
    public Response<PreStopDTO> preCal(@ApiParam(value = "信息",required = true) @RequestBody CarnumParam carnumParam){
        Response<PreStopDTO> response = new Response<>();
        PreStopDTO preStopDTO;
        try {
            preStopDTO = feeManageService.preCal(carnumParam.getCarnum());
            if(preStopDTO.getCarnum().equals("-2")){
                response.setCode(0);
                response.setMessage("该车辆为临时车辆收费！");
            }else if(preStopDTO.getStatus()==2){
                response.setCode(1);
                response.setData(preStopDTO);
                response.setMessage("卡已经过期，请重新充值！");
            }else if(preStopDTO.getStatus()==1){
                response.setCode(1);
                response.setData(preStopDTO);
                response.setMessage("卡已经过期，请重新充值！");
            }else{
                response.setCode(1);
                response.setData(preStopDTO);
                response.setMessage("查询成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("查询异常！");
        }
        return response;
    }
}
