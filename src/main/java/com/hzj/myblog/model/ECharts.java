package com.hzj.myblog.model;

/**
 * ECharts所需的基本数据
 *
 * @author hzj
 */
public class ECharts {

    private String name;

    private Integer value;

    public ECharts() {
    }


    public ECharts(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ECharts{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
