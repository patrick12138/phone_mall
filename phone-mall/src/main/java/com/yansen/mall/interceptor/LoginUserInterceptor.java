package com.yansen.mall.interceptor;

import com.yansen.mall.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginUserInterceptor implements HandlerInterceptor {

    public static ThreadLocal<UserEntity> loginUser = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserEntity attribute = (UserEntity) request.getSession().getAttribute("loginUser");
        if (attribute != null) {
            loginUser.set(attribute);
            return true;
        } else {
            //跳转登录页
            request.getSession().setAttribute("msg", "请先登录");
            response.sendRedirect("http://localhost:8090/login.html");
            return false;
        }
    }
}
