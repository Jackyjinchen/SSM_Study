package com.jacky.Handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("拦截器preHandler()");

        Object name = request.getSession().getAttribute("name");
        String loginName="";
        if(name!=null){
            loginName=(String)name;
        }

        if(!"zs".equals(loginName)){
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }

        return true;
    }
}
