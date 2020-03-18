package com.hzj.myblog.model;

/**
 * 用户实体
 *
 * @author hzj
 */
public class User {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 账户名称
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户的等级,admin,user
     */
    private String level;

    public User() {
    }

    public User(Integer userId, String account, String password, String nickName, String level) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.nickName = nickName;
        this.level = level;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
