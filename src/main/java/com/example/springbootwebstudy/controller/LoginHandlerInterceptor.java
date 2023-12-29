package com.example.springbootwebstudy.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * @author subeiLY
 * @create 2021-11-06 23:57
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
        // 获取 loginuser 信息进行判断
        Object user = request.getSession().getAttribute("loginUser");
        if(user==null){
            // 未登录，返回首页
            request.setAttribute("msg","没有权限，请登录账户");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else {
            // 登录，放行
            return true;
        }

    }
}
