package com.hzj.myblog.mapper;

import com.hzj.myblog.entity.group.BlogAndTypeAndTagGroup;
import com.hzj.myblog.model.Blog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogMapper {
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
    @Delete("DELETE FROM blog WHERE id = #{id}")
    void deleteBlog(@Param("id") Integer id);

    /**
     * 查找博客通过博客的id
     *
     * @param id 博客id
     * @return 博客信息
     */
    @Select("SELECT id, title, markdown, userId, blogTypeId, tagId, imageUrl, updateDate FROM blog WHERE id = #{id}")
    Blog findBlogById(@Param("id") Integer id);

    /**
     * 通过用户id查找博客
     *
     * @param userId 用户id
     * @return 查找的博客列表
     */
    List<Blog> findBlogByUserId(Integer userId);

    /**
     * 搜索用户的博客列表
     *
     * @param userId      用户id
     * @param typeName    博客分类
     * @param searchValue 博客内容
     * @param tagName     标签名称
     * @return 查找的博客列表
     */
    List<BlogAndTypeAndTagGroup> searchUserBlog(@Param("userId") Integer userId, @Param("typeName") String typeName, @Param("searchValue") String searchValue, @Param("tagName") String tagName);

    /**
     * 通过用户id和博客标题查询博客
     *
     * @param userId 用户id
     * @param title  博客标题
     * @return 查询到的博客信息
     */
    @Select("SELECT id, title, userId, blogTypeId, tagId, description, imageUrl FROM blog WHERE title = #{title} AND userId = #{userId}")
    Blog findBlogByUserIdAndTitle(@Param("userId") Integer userId, @Param("title") String title);

    /**
     * 更新博客的信息
     *
     * @param blog 博客信息
     */
    void updateBlog(Blog blog);
}
