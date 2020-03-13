package com.hzj.myblog.service.impl;

import com.hzj.myblog.mapper.BlogMapper;
import com.hzj.myblog.model.Blog;
import com.hzj.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 博客的service层接口实现
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public void addBlog(Blog blog) {
        // 设置创建时间
        blog.setUpdateDate(new Date());

        blogMapper.addBlog(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogMapper.deleteBlog(id);
    }

    @Override
    public Blog findBlogById(Integer id) {
        return blogMapper.findBlogById(id);
    }

    @Override
    public List<Blog> findBlogByUserId(Integer userId) {
        return blogMapper.findBlogByUserId(userId);
    }

    /**
     * 得到最新的博客列表
     *
     * @param userId 用户id
     * @return 查找的博客列表
     */
    @Override
    public List<Blog> findNewestBlog(Integer userId) {
        return blogMapper.findNewestBlog(userId);
    }

    @Override
    public Blog findBlogByUserIdAndTitle(Integer userId, String title) {
        return blogMapper.findBlogByUserIdAndTitle(userId, title);
    }

    @Override
    public void updateBlog(Blog blog) {
        // 设置更新时间
        blog.setUpdateDate(new Date());
        blogMapper.updateBlog(blog);
    }
}