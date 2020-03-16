package com.hzj.myblog.config;


import com.hzj.myblog.interceptor.HttpBasicAuthorizeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 *
 * @author 何志坚
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private HttpBasicAuthorizeHandler httpBasicAuthorizeHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(httpBasicAuthorizeHandler)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login", "/user/register", "/user/sendEmail/*", "/user/verifyTicket/**")
                .excludePathPatterns("/blog/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**", "/", "/csrf", "/error");
    }
}
