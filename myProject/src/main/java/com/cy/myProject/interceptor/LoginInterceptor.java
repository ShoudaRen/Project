package com.cy.myProject.interceptor;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * define a interceptor
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 检测全局session对象是否有Uid数据，如果有则放行，如果没有重新定向到login
     * @param request 请求对象
     * @param response 响应对象
     * @param handler  处理器（url+ controller ;映射）
     * @return 如果返回值true 放行，否则拦截
     * @throws Exception
     */
    @Override
    //Interceptor
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
//HttpServletRequest 对象来获取session对象
        Object obj= request.getSession().getAttribute("uid");
        if (obj==null){
            //用户没有登录系统，重定向
            response.sendRedirect("/templates/LogIn.html");
            //结束后续调用
            return false;}
        //放行
        return true;
    }
}
