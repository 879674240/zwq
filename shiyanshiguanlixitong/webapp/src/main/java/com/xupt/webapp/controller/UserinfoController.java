package com.xupt.webapp.controller;

import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.UserinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserinfoController {
    @Resource
    private UserinfoService userinfoService;
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public UserinfoEntity query(){
        UserinfoEntity userinfoEntity = userinfoService.query();
        return userinfoEntity;
    }
}
