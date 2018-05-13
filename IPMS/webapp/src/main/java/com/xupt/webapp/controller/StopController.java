package com.xupt.webapp.controller;

import com.xupt.StopService;
import com.xupt.common.Response;
import com.xupt.dal.model.ParkingEntity;
import com.xupt.dal.model.StopEntity;
import com.xupt.dto.CarnumParam;
import com.xupt.dto.ParkingInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "停车管理", description = "停车管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/api/stop")
public class StopController {
    @Resource
    StopService stopService;
    @CrossOrigin("*")
    @ApiOperation(value = "添加停车信息", notes = "添加停车信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/insert",method=RequestMethod.POST)
    public Response<Integer> insert(@ApiParam(value = "车辆停放信息",required = true) @RequestBody StopEntity stopEntity){
        Response<Integer> response = new Response<>();
        int result = 0;
        try {
            result = stopService.insert(stopEntity);
            if (result==0){
                response.setCode(0);
                response.setMessage("该车已在车位停放！");
            }else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("停车成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("停车操作异常！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "获取空位信息", notes = "获取空位信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/query",method=RequestMethod.POST)
    public Response<List<ParkingEntity>> query(){
        Response<List<ParkingEntity>> response = new Response<>();
        List<ParkingEntity> parkingEntities = null;
        try {
            parkingEntities = stopService.queryPark();
            response.setData(parkingEntities);
            response.setCode(1);
            response.setMessage("获取空位信息成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("获取空位信息异常！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "根据车牌号获取信息", notes = "根据车牌号获取信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/queryByCarnum",method=RequestMethod.POST)
    public Response<ParkingInfo> queryByCarnum(@RequestBody @ApiParam(value = "车牌号",required = true) CarnumParam carnum){
        Response<ParkingInfo> response = new Response<>();
        ParkingInfo parkingInfos = null;
        try {
            parkingInfos = stopService.queryByCarnum(carnum.getCarnum());
            response.setData(parkingInfos);
            response.setCode(1);
            response.setMessage("获取信息成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("获取信息异常！");
        }
        return response;
    }

    @CrossOrigin("*")
    @ApiOperation(value = "反向寻车", notes = "反向寻车", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/querySpace",method=RequestMethod.POST)
    public Response<StopEntity> querySpace(@RequestBody CarnumParam carnumParam){
        Response<StopEntity> response = new Response<>();
        StopEntity stopEntity = null;
        try {
            stopEntity = stopService.querySpace(carnumParam.getCarnum());
            if(stopEntity==null){
                response.setCode(0);
                response.setMessage("没有查到该车信息！");
            }else{
                response.setData(stopEntity);
                response.setCode(1);
                response.setMessage("获取车位信息成功！");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("获取车位信息异常！");
        }
        return response;
    }

}
