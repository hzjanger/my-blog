package com.hzj.myblog.model;

/**
 * @author hzj
 * 博客分类实体
 */
public class BlogType {
    /**
     * 分类的id,主键
     */
    private Integer id;
    /**
     * 分类的名称
     */
    private String typeName;

    public BlogType() {
    }

    public BlogType(Integer id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
