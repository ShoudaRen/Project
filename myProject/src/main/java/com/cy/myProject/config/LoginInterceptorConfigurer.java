package com.cy.myProject.config;

import com.cy.myProject.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器注册 白名单黑名单
 */
@Configuration //加载当前的拦截器并进行注册
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    //创建自定义的拦截器对象
    HandlerInterceptor interceptor = new LoginInterceptor();
    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //*配置白名单：
        List<String> patterns = new ArrayList<>();
        patterns.add("/CSS/**");
        patterns.add("/static/**");
        patterns.add("/fontAwesome/**");
        patterns.add("/js/**");
        patterns.add("/templates/index.html");
        patterns.add("/templates/LogIn.html");
        patterns.add("/templates/register.html");
        patterns.add("/templates/allticket.html");
        patterns.add("/templates/PartTicket.html");
        patterns.add("/templates/Onsalesticket.html");

        //url 放行
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/tickets/");
        patterns.add("/tickets/**");
        //往注册里添加拦截器
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")//表示要拦截的url是什么
                .excludePathPatterns(patterns);
        // “/**”代表所有的请求都会拦截

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
