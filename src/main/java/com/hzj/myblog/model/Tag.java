package com.hzj.myblog.model;

/**
 * 博客标签实体
 *
 * @author hzj
 */
public class Tag {
    /**
     * 标签id
     */
    private Integer id;
    /**
     * 标签名称
     */
    private String tagName;
    /**
     * 博客分类id
     */
    private Integer blogTypeId;

    public Tag() {
    }

    public Tag(Integer id, String tagName, Integer blogTypeId) {
        this.id = id;
        this.tagName = tagName;
        this.blogTypeId = blogTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getBlogTypeId() {
        return blogTypeId;
    }

    public void setBlogTypeId(Integer blogTypeId) {
        this.blogTypeId = blogTypeId;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", blogTypeId=" + blogTypeId +
                '}';
    }
}
