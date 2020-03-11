package com.hzj.myblog.entity;

/**
 * 单元实体
 * @author hzj
 */
public class Unit {
    /**
     * 单元id，主键
     */
    private String id;
    /**
     * 单元名称
     */
    private String unitName;
    /**
     * 单词编号id
     */
    private String wordId;
    /**
     * 单词所在表
     */
    private String wordTable;
    /**
     * 词书id
     */
    private String wordBookId;

    public Unit() {
    }

    public Unit(String id, String unitName, String wordId, String wordTable, String wordBookId) {
        this.id = id;
        this.unitName = unitName;
        this.wordId = wordId;
        this.wordTable = wordTable;
        this.wordBookId = wordBookId;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id='" + id + '\'' +
                ", unitName='" + unitName + '\'' +
                ", wordId='" + wordId + '\'' +
                ", wordTable='" + wordTable + '\'' +
                ", wordBookId='" + wordBookId + '\'' +
                '}';
    }
}
