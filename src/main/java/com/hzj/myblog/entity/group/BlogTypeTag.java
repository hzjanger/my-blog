package com.hzj.myblog.entity.group;

import com.hzj.myblog.model.BlogType;
import com.hzj.myblog.model.Tag;

/**
 * 博客分类--标签对应关系,一对多
 *
 * @author hzj
 */
public class BlogTypeTag {
    /**
     * 博客分类
     */
    private BlogType blogType;
    /**
     * 标签
     */
    private Tag tag;

    /**
     * 数量
     */
    private Integer account;



}
