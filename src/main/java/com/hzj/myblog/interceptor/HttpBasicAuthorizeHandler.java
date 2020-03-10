package com.hzj.myblog.interceptor;

import com.hzj.myblog.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 *
 * @author hzj
 */
@Component
public class HttpBasicAuthorizeHandler implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(HttpBasicAuthorizeHandler.class);

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("请求的url" + request.getRequestURI());
        String token = request.getHeader("Authorization");
        if (token != null) {
            Claims claims = jwtUtil.parseJwt(token);
            return claims != null;
        }
        logger.warn("权限不够");
        return false;
    }
}
