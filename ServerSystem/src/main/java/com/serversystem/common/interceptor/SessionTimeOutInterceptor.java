package com.serversystem.common.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionTimeOutInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if (request.getSession(false) == null){
            boolean isAjaxRequest = false;
            if (!StringUtils.isEmpty(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")){
                isAjaxRequest = true;
            }
            if (isAjaxRequest){
                response.setHeader("sessionstatus","TIMEOUT");
                response.setHeader("content_path","/page/login");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            } else {
                response.sendRedirect("/page/login");
                return false;
            }
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
