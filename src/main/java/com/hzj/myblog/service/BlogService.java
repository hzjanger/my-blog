package com.hzj.myblog.service;

import com.hzj.myblog.model.Blog;

import java.util.List;

/**
 * 博客的service接口
 *
 * @author hzj
 */
public interface BlogService {
    /**
     * 添加博客
     *
     * @param blog 博客信息
     */
    void addBlog(Blog blog);

    /**
     * 删除博客
     *
     * @param id 博客的id
     */
    void deleteBlog(Integer id);

    /**
     * 查找博客通过博客的id
     *
     * @param id 博客id
     * @return 博客信息
     */

    Blog findBlogById(Integer id);

    /**
     * 通过用户id查找博客
     *
     * @param userId 用户id
     * @return 查找的博客列表
     */
    List<Blog> findBlogByUserId(Integer userId);

    /**
     * 得到最新的博客列表
     *
     * @param userId 用户id
     * @return 查找的博客列表
     */
    List<Blog> findNewestBlog(Integer userId);

    /**
     * 通过用户id和博客标题查询博客
     *
     * @param userId 用户id
     * @param title  博客标题
     * @return 查询到的博客信息
     */
    Blog findBlogByUserIdAndTitle(Integer userId, String title);

    /**
     * 更新博客的信息
     *
     * @param blog 博客信息
     */
    void updateBlog(Blog blog);
}
