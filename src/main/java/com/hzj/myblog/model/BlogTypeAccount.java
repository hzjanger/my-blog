package com.hzj.myblog.model;

/**
 * 博客分类数量
 *
 * @author hzj
 */
public class BlogTypeAccount extends BlogType {
    /**
     * 博客分类数量
     */
    private Integer account;

    public BlogTypeAccount() {
    }

    public BlogTypeAccount(Integer id, String typeName, Integer account) {
        super(id, typeName);
        this.account = account;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "BlogTypeAccount{" +
                "account=" + account +
                '}';
    }
}
