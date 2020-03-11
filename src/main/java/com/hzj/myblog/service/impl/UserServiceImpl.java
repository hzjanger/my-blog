package com.hzj.myblog.service.impl;

import com.hzj.myblog.exception.VerificationCodeException;
import com.hzj.myblog.model.User;
import com.hzj.myblog.entity.request.Login;
import com.hzj.myblog.mapper.UserMapper;
import com.hzj.myblog.service.MailService;
import com.hzj.myblog.service.UserService;
import com.hzj.myblog.utils.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 用户service层
 *
 * @author 何志坚
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * template模板引擎
     */
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    /**
     * 查找用户的信息，通过账户名和密码
     *
     * @param login 用户信息
     * @return 用户信息
     */
    public User findUserByAccountAndPassword(Login login) {
        return userMapper.findUserByAccountAndPassword(login);
    }

    /**
     * 通过账户名称查找用户的信息
     *
     * @param account 账户名称
     * @return 用户信息
     */
    public User findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }

    /**
     * 查询所有的用户
     *
     * @return 用户信息
     */
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    /**
     * 创建用户
     *
     * @param user 用户信息
     */
    public void addUser(Login user) {
        String code = stringRedisTemplate.opsForValue().get(user.getAccount());
        if (code != null && !code.equals(user.getCode())) {
            stringRedisTemplate.delete(user.getAccount());
            throw new VerificationCodeException("验证码错误");
        } else if (code == null) {
            throw new VerificationCodeException("验证码已过期");
        }
        userMapper.addUser(user);
    }

    /**
     * 发送注册码
     *
     * @param email 发送的地址
     */
    @Override
    public void sendRegisterEmail(String email) throws MessagingException {
        Context context = new Context();
        String code = RandomUtils.getRandomCode(6);
        context.setVariable("code", code);
        stringRedisTemplate.opsForValue().set(email, code, 5, TimeUnit.MINUTES);
        String content = templateEngine.process("/mail", context);
        mailService.sendHtmlMail(email, "验证邮箱", content);
    }
}
