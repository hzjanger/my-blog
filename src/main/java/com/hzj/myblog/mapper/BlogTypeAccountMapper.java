package com.hzj.myblog.mapper;

import com.hzj.myblog.model.BlogTypeAccount;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 博客分类统计
 *
 * @author hzj
 */
@Component
public interface BlogTypeAccountMapper {
    /**
     * 查找博客分类数量
     *
     * @return 博客数量列表
     */
    List<BlogTypeAccount> findUserBlogTypeAccount(Integer userId);
}
