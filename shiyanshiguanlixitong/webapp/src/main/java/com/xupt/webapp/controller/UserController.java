package com.xupt.webapp.controller;

import com.xupt.component.Response;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.UserinfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Resource
    UserinfoService userinfoService;

    /**
     * 登录
     * @param request
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login")
    public Response<String> login(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("password") String password){
        Response<String> response = new Response<>();
        response.setCode(0);
        response.setMessage("登录失败！");
        if (com.alibaba.druid.util.StringUtils.isEmpty(name) || com.alibaba.druid.util.StringUtils.isEmpty(password)){
            return response;
        }

        UserinfoEntity userinfoEntity = userinfoService.queryByName(name);
        if (password.equals(userinfoEntity.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("status","ok");
            response.setCode(1);
            response.setMessage("登录成功！");
            return response;
        }
        return response;
    }

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

}
