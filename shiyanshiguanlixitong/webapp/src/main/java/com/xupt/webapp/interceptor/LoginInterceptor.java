package com.xupt.webapp.interceptor;
import com.mysql.jdbc.StringUtils;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.UserinfoService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private UserinfoService userinfoService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if(name !=null && password!=null & !"".equals(name) && !"".equals(password)){
            if (name.equals((String) request.getSession().getAttribute("name")) &&
                    password.equals((String)request.getSession().getAttribute("passowrd"))){
                return true;
            }
        }else {
            List<UserinfoEntity> userinfoEntities = userinfoService.query();
            for (UserinfoEntity userinfoEntity:userinfoEntities){
                if (name.equals(userinfoEntity.getName())){
                    if (password.equals(userinfoEntity.getPassword())){
                        request.getSession().setAttribute("name",name);
                        request.getSession().setAttribute("password",password);
                        return true;
                    }
                }
            }

        }
        System.out.println("拦截器preHandel方法");
        return false;
    }
    //返回modelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
    //执行Handler完成执行此方法
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}
