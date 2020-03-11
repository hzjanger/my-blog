package com.hzj.myblog.model;

import java.util.Date;

/**
 * 博客实体
 *
 * @author hzj
 */
public class Blog {
    /**
     * 博客id
     */
    private Integer id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String markdown;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 博客分类id
     */
    private Integer blogTypeId;
    /**
     * 博客标签id
     */
    private Integer tagId;

    /**
     * 更新时间
     */
    private Date updateDate;

    public Blog() {
    }

    public Blog(Integer id, String title, String markdown, Integer userId, Integer blogTypeId, Integer tagId, Date updateDate) {
        this.id = id;
        this.title = title;
        this.markdown = markdown;
        this.userId = userId;
        this.blogTypeId = blogTypeId;
        this.tagId = tagId;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlogTypeId() {
        return blogTypeId;
    }

    public void setBlogTypeId(Integer blogTypeId) {
        this.blogTypeId = blogTypeId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", markdown='" + markdown + '\'' +
                ", userId=" + userId +
                ", blogTypeId=" + blogTypeId +
                ", tagId=" + tagId +
                ", updateDate=" + updateDate +
                '}';
    }
}
