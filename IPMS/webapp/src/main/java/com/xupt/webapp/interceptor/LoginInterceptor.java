package com.xupt.webapp.interceptor;

import com.xupt.common.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    JedisPool jedisPool;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器preHandel方法");
        String tokenfromweb = request.getHeader("Authorization");
        if(tokenfromweb==null){
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }
        Jedis jedis = jedisPool.getResource();
        String temp = jedis.get(tokenfromweb);
        jedis.close();
        if(temp==null){
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }else{
           return true;
        }
    }

    //返回modelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    //执行Handler完成执行此方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}
