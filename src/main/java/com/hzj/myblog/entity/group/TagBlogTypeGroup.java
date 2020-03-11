package com.hzj.myblog.entity.group;

import com.hzj.myblog.model.BlogType;
import com.hzj.myblog.model.Tag;

public class TagBlogTypeGroup extends Tag {
    /**
     * 标签所对应的博客分类
     */
    private BlogType blogType;

    public TagBlogTypeGroup() {
    }

    public TagBlogTypeGroup(Integer id, String tagName, Integer blogTypeId, BlogType blogType) {
        super(id, tagName, blogTypeId);
        this.blogType = blogType;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    @Override
    public String toString() {
        return "TagBlogTypeGroup{" +
                "blogType=" + blogType +
                '}';
    }
}
