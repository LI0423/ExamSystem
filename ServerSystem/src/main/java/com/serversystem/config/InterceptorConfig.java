package com.serversystem.config;

import com.serversystem.common.interceptor.PageInterceptor;
import com.serversystem.common.interceptor.RequestInterceptor;
import com.serversystem.common.interceptor.SessionTimeOutInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public PageInterceptor getPageInterceptor() {
        return new PageInterceptor();
    }

    @Bean
    public RequestInterceptor getRequestInterceptor() {
        return new RequestInterceptor();
    }

    @Bean
    public SessionTimeOutInterceptor getSessionTimeOutInterceptor(){
        return new SessionTimeOutInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        registry.addInterceptor(getPageInterceptor())
                .addPathPatterns("//**")
                .addPathPatterns("//**");
        registry.addInterceptor(getRequestInterceptor())
                .addPathPatterns("/resource/**")
                .addPathPatterns("/api");
        registry.addInterceptor(getSessionTimeOutInterceptor())
                .addPathPatterns("/login");

    }

}
