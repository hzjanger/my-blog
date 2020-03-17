package com.hzj.myblog.service;

import com.hzj.myblog.entity.chart.TagWordCloud;
import com.hzj.myblog.model.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 标签信息的service接口
 *
 * @author hzj
 */
public interface TagService {
    /**
     * 添加标签
     *
     * @param tag 标签信息
     */
    void addTag(Tag tag);

    /**
     * 删除标签
     *
     * @param id 标签id
     */
    void deleteTag(Integer id);

    /**
     * 查找所有的标签
     *
     * @return 标签对象列表
     */
    List<Tag> findAllTag();

    /**
     * 查找博客分类所对应的标签
     *
     * @param blogTypeId 博客分类id
     * @return 标签对象列表
     */
    List<Tag> findTagByBlogTypeId(Integer blogTypeId);

    /**
     * 统计用户每个标签的数量
     *
     * @param userId 用户id
     * @return 标签数量
     */
    List<TagWordCloud> tagOfBlogAccount(Integer userId);

    /**
     * 更新标签信息
     *
     * @param tag 标签信息
     */
    void updateTag(Tag tag);
}
