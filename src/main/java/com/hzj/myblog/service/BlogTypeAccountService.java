package com.hzj.myblog.service;

import com.hzj.myblog.model.BlogTypeAccount;

import java.util.List;

/**
 * 博客分类统计service接口
 *
 * @author hzj
 */
public interface BlogTypeAccountService {
    /**
     * 查找博客分类数量
     *
     * @return 博客数量列表
     */
    List<BlogTypeAccount> findUserBlogTypeAccount(Integer userId);
}
