package com.xupt.webapp.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.xupt.component.HttpStatus;
import com.xupt.dal.mapper.UserinfoMapper;
import com.xupt.dal.model.OperationLogEntity;
import com.xupt.dal.model.UserinfoEntity;
import com.xupt.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    JedisPool jedisPool;
    @Resource
    UserinfoMapper userinfoMapper;
    @Resource
    LogService logService;
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器preHandel方法");

        String tokenfromweb = request.getHeader("Authorization");
        String tokenfromweb1 = request.getHeader("authorization");
        if(tokenfromweb==null){
            //response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }
        Jedis jedis = jedisPool.getResource();
        String temp = jedis.get(tokenfromweb);
        jedis.close();
        if(temp==null){
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }else{
            UserinfoEntity userinfoEntity = userinfoMapper.queryByName(temp);
            String url = request.getRequestURI();
            //String params = JSON.toJSONString(request.getParameterMap());

            /*ServletInputStream is;
            String str ="";
            try {
                MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest(request);
                is = multiReadRequest.getInputStream();
                int nRead = 1;
                int nTotalRead = 0;
                byte[] bytes = new byte[10240];
                while (nRead > 0) {
                    nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
                    if (nRead > 0)
                        nTotalRead = nTotalRead + nRead;
                }
                str = new String(bytes, 0, nTotalRead, "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONObject jsonObject=JSONObject.parseObject(str);
            String params = JSONObject.toJSONString(jsonObject);*/
            String params = "";
            logger.error("访问日志=url:{},param:{}", url, params);

            if (null != temp) {
                OperationLogEntity operationLogEntity = new OperationLogEntity();
                if(userinfoEntity!=null){
                    operationLogEntity.setName(userinfoEntity.getName());
                    operationLogEntity.setReallyName(userinfoEntity.getRealname());
                }
                operationLogEntity.setPath(url);
                operationLogEntity.setParams(params);
                if (url.contains("insert") || url.contains("update") || url.contains("delete") || url.contains("arrange")
                        || url.contains("register") || url.contains("login")) {
                    logger.info("-----已拦截到特定方法-----");
                    logService.insert(operationLogEntity);
                }
            } else {
                logger.error("获取登录用户信息失败=url:{}", url);
            }
        }
            return true;

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
