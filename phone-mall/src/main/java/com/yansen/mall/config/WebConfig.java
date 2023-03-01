package com.yansen.mall.config;

import com.yansen.mall.interceptor.LoginUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    LoginUserInterceptor loginUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginUserInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/",
                        "/register",
                        "/index.html",
                        "/cart.html",
                        "/login.html",
                        "/reg.html",
                        "/search.html",
                        "/*.html",
                        "/cart/**",
                        "/index/**",
                        "/item/**",
                        "/login/**",
                        "/reg/**",
                        "/search/**"
                );
    }
}