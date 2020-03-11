package com.hzj.myblog.entity.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 接收登录注册参数的实体
 *
 * @author 何志坚
 */
public class Login {

    /**
     * 账户
     */
    @NotNull(message = "账户不能为空")
    @Email(message = "邮箱格式不正确")
    private String account;

    /**
     * 密码
     */
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 20, message = "密码长度需要在6到20之间")
    private String password;

    /**
     * 验证码
     */
    private String code;

    public Login() {
    }

    public Login(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Login{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
