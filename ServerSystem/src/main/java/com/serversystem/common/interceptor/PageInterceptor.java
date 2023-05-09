package com.serversystem.common.interceptor;

import com.github.pagehelper.PageHelper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class PageInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String _page = request.getParameter("page");
        String _limit = request.getParameter("limit");
        if (_page != null && _limit != null) {
            String regex = "^[0-9]*$";
            if (_page.matches(regex) && _limit.matches(regex)) {
                Integer page = Integer.valueOf(_page);
                Integer limit = Integer.valueOf(_limit);
                PageHelper.startPage(page, limit);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }


}
