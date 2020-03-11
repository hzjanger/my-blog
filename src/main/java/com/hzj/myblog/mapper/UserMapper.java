package com.hzj.myblog.mapper;

import com.hzj.myblog.model.User;
import com.hzj.myblog.entity.request.Login;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户的mapper层
 *
 * @author 何志坚
 */
@Mapper
@Component
public interface UserMapper {
    /**
     * 查找用户的信息，通过账户名和密码
     *
     * @param login 登录信息
     * @return 用户信息
     */
    User findUserByAccountAndPassword(Login login);

    /**
     * 查找用户,通过用户的
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
     * 新增用户
     *
     * @param user 用户信息
     */
    void addUser(Login user);
}
