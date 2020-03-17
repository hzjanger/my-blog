package com.hzj.myblog.service.impl;

import com.hzj.myblog.entity.chart.TagWordCloud;
import com.hzj.myblog.mapper.TagMapper;
import com.hzj.myblog.model.Tag;
import com.hzj.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签信息的service
 *
 * @author hzj
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public void addTag(Tag tag) {
        tagMapper.addTag(tag);
    }

    @Override
    public void deleteTag(Integer id) {
        tagMapper.deleteTag(id);
    }

    @Override
    public List<Tag> findAllTag() {
        return tagMapper.findAllTag();
    }

    @Override
    public List<Tag> findTagByBlogTypeId(Integer blogTypeId) {
        return tagMapper.findTagByBlogTypeId(blogTypeId);
    }

    @Override
    public List<TagWordCloud> tagOfBlogAccount(Integer userId) {
        return tagMapper.tagOfBlogAccount(userId);
    }

    @Override
    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }
}
