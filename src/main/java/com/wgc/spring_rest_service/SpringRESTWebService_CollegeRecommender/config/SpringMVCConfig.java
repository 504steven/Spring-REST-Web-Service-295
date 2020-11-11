package com.wgc.spring_rest_service.SpringRESTWebService_CollegeRecommender.config;


import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// used in the proj ?
//@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new MyLogInterceptor());
    }

}


class MyLogInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MyLogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.warn("------------------  Interceptor prehandle before controller");
//        ThreadContext.put("id", fishTag);
//        ThreadContext.put("path", operationPath);
//        ThreadContext.put("user", user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.warn("------------------  Interceptor posthandle  ");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) throws Exception {
        logger.warn("------------------  Interceptor afterComplete  ");
//        long renderingStartTime = (Long)request.getAttribute("rendering-start-time");
//        long renderingEndTime = System.currentTimeMillis();
//        long renderingDuration = renderingEndTime - renderingStartTime;
//        ThreadContext.put("rendering-duration", renderingDuration);
//        logger.info("My interceptor handler message");
        ThreadContext.clearMap();
    }

}