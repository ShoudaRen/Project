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
     * Check whether the global session object has Uid data. If so, it is allowed. If not, it is redirected to login
     * @param request
     * @param response
     * @param handler  Processor (url+ controller; mapping)
     * @return If true is returned, intercept otherwise
     * @throws Exception
     */
    @Override
    //Interceptor
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
//HttpServletRequest
        Object obj= request.getSession().getAttribute("uid");
        if (obj==null){
            // The user is not logged in to the system
            response.sendRedirect("/templates/LogIn.html");
            return false;}
        return true;
    }
}
