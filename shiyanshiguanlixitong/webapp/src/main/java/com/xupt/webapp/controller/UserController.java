package com.xupt.webapp.controller;

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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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


    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/register")
    public Response<Integer> register(@RequestParam("name") String name, @RequestParam("password") String password){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        response.setMessage("注册失败！");
        if (com.alibaba.druid.util.StringUtils.isEmpty(name) || com.alibaba.druid.util.StringUtils.isEmpty(password)){
            return response;
        }
        List<UserinfoEntity> userinfoEntitys = userinfoService.query();
        for (UserinfoEntity userinfoEntityTemp:userinfoEntitys){
            if (name.equals(userinfoEntityTemp.getName())){
                response.setMessage("该用户已存在！");
                return response;
            }
        }
        UserinfoEntity userinfoEntity = new UserinfoEntity();
        userinfoEntity.setName(name);
        userinfoEntity.setPassword(password);
        int result = userinfoService.insert(userinfoEntity);
        response.setCode(1);
        response.setMessage("注册成功");
        response.setData(1);
        return response;
    }

    /**
     * 修改密码
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/update")
    public Response<Integer> update(@RequestParam("name") String name, @RequestParam("password") String password){
        Response<Integer> response = new Response<>();
        response.setCode(0);
        response.setMessage("修改密码！");
        if (com.alibaba.druid.util.StringUtils.isEmpty(name) || com.alibaba.druid.util.StringUtils.isEmpty(password)){
            return response;
        }
        userinfoService.update(name,password);
        response.setCode(1);
        response.setMessage("修改密码成功！");
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
                response.setCode(0);
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
