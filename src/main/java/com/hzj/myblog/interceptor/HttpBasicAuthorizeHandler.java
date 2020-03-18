package com.hzj.myblog.interceptor;

import com.google.gson.Gson;
import com.hzj.myblog.exception.LevelException;
import com.hzj.myblog.model.User;
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
            if (claims != null) {
                String subject = claims.getSubject();
                Gson gson = new Gson();
                User user = gson.fromJson(subject, User.class);
                if ("admin".equals(user.getLevel())) {
                    return true;
                }
            }
        }
        throw new LevelException("权限不足");
    }
}
