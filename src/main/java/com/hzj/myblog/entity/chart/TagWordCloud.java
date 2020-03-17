package com.hzj.myblog.entity.chart;

import com.hzj.myblog.model.ECharts;

/**
 * 标签词云实体
 *
 * @author hzj
 */
public class TagWordCloud extends ECharts {
    private Integer tagId;

    public TagWordCloud() {
    }

    public TagWordCloud(String name, Integer value, Integer tagId) {
        super(name, value);
        this.tagId = tagId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "TagWordCloud{" +
                "tagId=" + tagId +
                '}';
    }
}
