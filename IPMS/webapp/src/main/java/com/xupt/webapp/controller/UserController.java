package com.xupt.webapp.controller;

import com.alibaba.druid.util.StringUtils;
import com.xupt.Tool.JedisUtil;
import com.xupt.UserService;
import com.xupt.common.HttpStatus;
import com.xupt.common.Response;
import com.xupt.dto.AuthType;
import com.xupt.dto.LoginParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 用户管理
 */
@RestController
@RequestMapping(value = "/api/authtype")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    JedisPool jedisPool;

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "登录token验证", notes = "登录token验证", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response<String> login(@ApiParam(value = "登录token验证",required = true) @RequestBody LoginParam loginParam){
        Response<String> response = new Response<>();
        String result = "";
        if (StringUtils.isEmpty(loginParam.getName()) || StringUtils.isEmpty(loginParam.getPassword())){
            response.setCode(0);
            response.setMessage("请输入账号密码！");
            return response;
        }
        try {
            result = userService.loginToken(loginParam);
            if("000".equals(result)){
                response.setCode(0);
                response.setMessage("账号或密码错误！");
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

    /**
     * 修改密码
     * @param loginParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "修改密码", notes = "修改密码", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Response<Integer> update(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,@ApiParam(value = "修改密码",required = true) @RequestBody LoginParam loginParam){
        Response<Integer> response = new Response<>();
        Integer result;
        if (StringUtils.isEmpty(loginParam.getPassword()) || StringUtils.isEmpty(loginParam.getNewpassword())){
            response.setCode(0);
            response.setMessage("请输入账号密码！");
            return response;
        }
        try {
            String authorization = httpServletRequest.getHeader("Authorization");
            if(authorization==null){
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
            }
            Jedis jedis = jedisPool.getResource();
            String temp = jedis.get(authorization);
            jedis.close();
            if(temp==null){
                response.setCode(0);
                response.setMessage("未授权！");
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
            }
            loginParam.setName(temp);
            result = userService.update(loginParam);
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
     * 退出
     * @param loginParam
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "退出", notes = "退出", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/loginout",method = RequestMethod.POST)
    public Response<Integer> loginout(HttpServletRequest httpServletRequest, @ApiParam(value = "退出",required = true) @RequestBody LoginParam loginParam){
        Response<Integer> response = new Response<>();
        long result = 0;
        try {
            String authorization = httpServletRequest.getHeader("Authorization");
            result = userService.loginout(authorization);
            response.setCode(0);
            response.setMessage("退出成功！");
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("退出异常！");
            return response;
        }
        return response;
    }

    /**
     * 页面
     * @param
     * @return
     */
    @CrossOrigin("*")
    @ApiOperation(value = "页面", notes = "页面", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/authtype",method = RequestMethod.POST)
    public Response<AuthType> authtype(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        Response<AuthType> response = new Response<>();
        AuthType authType;
        try {
            String authorization = httpServletRequest.getHeader("Authorization");
            if(authorization==null){
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
            }
            Jedis jedis = jedisPool.getResource();
            String temp = jedis.get(authorization);
            jedis.close();
            if(temp==null){
                response.setCode(0);
                response.setMessage("未授权！");
                httpServletResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
            }
            authType = userService.authType(temp);
            response.setCode(1);
            response.setMessage("验证成功！");
            response.setData(authType);
        }catch (Exception e){
            response.setCode(0);
            response.setMessage("验证账号密码异常！");
            return response;
        }
        return response;
    }
}
