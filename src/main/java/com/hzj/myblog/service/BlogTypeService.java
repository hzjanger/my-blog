package com.hzj.myblog.service;

import com.hzj.myblog.model.BlogType;

import java.util.List;

/**
 * 博客分类的service层接口
 *
 * @author hzj
 */
public interface BlogTypeService {
    /**
     * 添加博客分类
     *
     * @param blogType 分类信息
     */
    void addBlogType(BlogType blogType);

    /**
     * 删除博客分类
     *
     * @param id 博客分类
     */
    void deleteBlogType(Integer id);

    /**
     * 查找所有的博客分类
     *
     * @return 返回查找到的列表
     */
    List<BlogType> findAllBlogType();

    /**
     * 更新博客分类的信息
     *
     * @param blogType 博客分类的信息
     */
    void updateBlogType(BlogType blogType);
}
