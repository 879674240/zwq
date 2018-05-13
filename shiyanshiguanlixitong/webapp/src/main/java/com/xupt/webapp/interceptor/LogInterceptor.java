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

/**
 * @author: zhi.wenqiang
 * @time: 2018-05-06 20:15
 * @description: 打日志
 */
public class LogInterceptor implements HandlerInterceptor {

    @Resource
    JedisPool jedisPool;
    @Resource
    UserinfoMapper userinfoMapper;
    @Resource
    LogService logService;
    protected final Logger       logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        try {
            String tokenfromweb = request.getHeader("Authorization");
            if(tokenfromweb==null){
                response.setStatus(HttpStatus.SC_UNAUTHORIZED);
                return false;
            }
            Jedis jedis = jedisPool.getResource();
            String temp = jedis.get(tokenfromweb);
            jedis.close();
            UserinfoEntity userinfoEntity = userinfoMapper.queryByName(temp);
            String url = request.getRequestURI();
            //String params = JSON.toJSONString(request.getParameterMap());

            ServletInputStream is;
            String str ="";
            try {
                is = request.getInputStream();
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
            String params = JSONObject.toJSONString(jsonObject);
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
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    //返回modelAndView之前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }

}

