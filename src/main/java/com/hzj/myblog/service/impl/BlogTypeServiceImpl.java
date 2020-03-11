package com.hzj.myblog.service.impl;

import com.hzj.myblog.mapper.BlogTypeMapper;
import com.hzj.myblog.model.BlogType;
import com.hzj.myblog.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 博客分类service层接口的实现
 *
 * @author hzj
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService {


    @Autowired
    private BlogTypeMapper blogTypeMapper;

    @Override
    public void addBlogType(BlogType blogType) {
        blogTypeMapper.addBlogType(blogType);
    }

    @Override
    public void deleteBlogType(Integer id) {
        blogTypeMapper.deleteBlogType(id);
    }

    @Override
    public List<BlogType> findAllBlogType() {
        return blogTypeMapper.findAllBlogType();
    }

    @Override
    public void updateBlogType(BlogType blogType) {
        blogTypeMapper.updateBlogType(blogType);
    }
}
