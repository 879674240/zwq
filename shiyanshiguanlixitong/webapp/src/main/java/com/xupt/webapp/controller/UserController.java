package com.xupt.webapp.controller;

import com.alibaba.druid.util.StringUtils;
import com.xupt.component.HttpStatus;
import com.xupt.component.Response;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.UserinfoService;
import com.xupt.service.dto.ExpeiLogParam;
import com.xupt.service.dto.LoginParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户管理
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    UserinfoService userinfoService;
    @Resource
    JedisPool jedisPool;


    /**
     * 注册
     * @param userinfoEntity
     * @return
     */
    @RequestMapping(value = "/register")
    public Response<Integer> register(@ApiParam(value = "用户信息",required = true) @RequestBody UserinfoEntity userinfoEntity){
        Response<Integer> response = new Response<>();
        String name = userinfoEntity.getName();
        String password = userinfoEntity.getPassword();
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password) || StringUtils.isEmpty(userinfoEntity.getRealname())){
            response.setCode(0);
            response.setMessage("账号密码等关键信息不能为空！");
            return response;
        }
        try {
            int result = userinfoService.insert(userinfoEntity);
            if(result==-1){
                response.setCode(0);
                response.setMessage("该用户已注册!");
            }else{
                response.setCode(1);
                response.setMessage("注册成功!");
                response.setData(1);
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("注册异常!");
        }
        return response;
    }

    /**
     * 修改密码
     * @param loginParam
     * @return
     */
    @ApiOperation(value = "修改密码", notes = "修改密码", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response<Integer> update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @ApiParam(value = "修改密码",required = true) @RequestBody LoginParam loginParam){
        Response<Integer> response = new Response<>();
        Integer result;
        if (StringUtils.isEmpty(loginParam.getPassword()) || StringUtils.isEmpty(loginParam.getNewpassword())){
            response.setCode(0);
            response.setMessage("请输入密码！");
            return response;
        }
        try {
            String authorization = httpServletRequest.getHeader("Authorization");
            if(authorization==null){
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
                response.setCode(0);
                response.setMessage("未授权！");
                return response;
            }
            Jedis jedis = jedisPool.getResource();
            String temp = jedis.get(authorization);
            jedis.close();
            if(temp==null){
                response.setCode(0);
                response.setMessage("未授权！");
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
                return response;
            }
            loginParam.setName(temp);
            result = userinfoService.update(loginParam);
            if(result==-1){
                response.setCode(0);
                response.setMessage("输入账号不存在！");
            }else if(result==0){
                response.setCode(0);
                response.setMessage("输入密码错误！");
            }else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("修改成功");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("修改密码异常！");
            return response;
        }
        return response;
    }

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "登录token验证", notes = "登录token验证", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/loginToken",method = RequestMethod.POST)
    public Response<String> loginToken(@ApiParam(value = "日志查询条件",required = true) @RequestBody LoginParam loginParam){
        Response<String> response = new Response<>();
        String result = "";
        if (com.alibaba.druid.util.StringUtils.isEmpty(loginParam.getName()) || com.alibaba.druid.util.StringUtils.isEmpty(loginParam.getPassword())){
            response.setCode(0);
            response.setMessage("请输入账号密码！");
            return response;
        }
        try {
            result = userinfoService.loginToken(loginParam);
            if("000".equals(result)){
                response.setCode(0);
                response.setMessage("密码错误！");
            }else if("111".equals(result)){
                response.setCode(0);
                response.setMessage("账号错误！");
            }else{
                response.setCode(1);
                response.setData(result);
                response.setMessage("登录成功");
            }
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("验证账号密码异常！");
            return response;
        }
        return response;
    }

}
