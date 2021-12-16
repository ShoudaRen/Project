package com.cy.myProject.config;

import com.cy.myProject.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Configuration // Load the current interceptor
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    // Create a custom interceptor object, from myProject.interceptor.LoginInterceptor ; check uid if exist
    HandlerInterceptor interceptor = new LoginInterceptor();
    /**
     * Configuring interceptors
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
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
        patterns.add("/templates/allticketByPrice.html");
        patterns.add("/templates/allticketByTime.html");
        // url has been submitted
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/tickets/");
        patterns.add("/tickets/**");
       // Add interceptor to register
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
        // "/**" indicates that all requests will be intercepted

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
