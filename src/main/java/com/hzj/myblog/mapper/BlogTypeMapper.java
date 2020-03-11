package com.hzj.myblog.mapper;

import com.hzj.myblog.model.BlogType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 博客分类的Mapper层
 *
 * @author hzj
 */
@Component
public interface BlogTypeMapper {

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
