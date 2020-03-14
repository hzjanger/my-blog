package com.hzj.myblog.service;

import com.hzj.myblog.entity.request.Login;
import com.hzj.myblog.model.User;

import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    /**
     * 查找用户的信息，通过账户名和密码
     *
     * @param login 用户信息
     * @return 用户信息
     */
    User findUserByAccountAndPassword(Login login);

    /**
     * 通过账户名称查找用户的信息
     *
     * @param account 账户名称
     * @return 用户信息
     */
    User findUserByAccount(String account);

    /**
     * 查询所有的用户
     *
     * @return 用户信息
     */
    List<User> findAllUser();

    /**
     * 通过用户的昵称查询用户的信息
     *
     * @param nickName 用户昵称
     * @return 用户的信息
     */
    User findUserByNickname(String nickName);

    /**
     * 创建用户
     *
     * @param user 用户信息
     */
    void addUser(Login user);

    /**
     * 发送注册码
     *
     * @param email 发送的地址
     */
    void sendRegisterEmail(String email) throws MessagingException;
}
