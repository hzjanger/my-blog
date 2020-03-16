package com.hzj.myblog.entity.group;

import com.hzj.myblog.model.Blog;
import com.hzj.myblog.model.BlogType;
import com.hzj.myblog.model.Tag;

/**
 * 博客和博客分类和标签的组合实体
 */
public class BlogAndTypeAndTagGroup {

    /**
     * 博客信息
     */
    private Blog blog;

    /**
     * 博客分类
     */
    private BlogType blogType;

    /**
     * 标签信息
     */
    private Tag tag;

    public BlogAndTypeAndTagGroup() {
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "BlogAndTypeAndTagGroup{" +
                "blog=" + blog +
                ", blogType=" + blogType +
                ", tag=" + tag +
                '}';
    }
}
