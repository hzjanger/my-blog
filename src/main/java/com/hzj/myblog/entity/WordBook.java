package com.hzj.myblog.entity;

/**
 * 词书
 * @author hzj
 */
public class WordBook {
    /**
     * 词书id，主键
     */
    private String id;
    /**
     * 词书名称
     */
    private String wordBookName;

    public WordBook() {
    }

    public WordBook(String id, String wordBookName) {
        this.id = id;
        this.wordBookName = wordBookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWordBookName() {
        return wordBookName;
    }

    public void setWordBookName(String wordBookName) {
        this.wordBookName = wordBookName;
    }

    @Override
    public String toString() {
        return "WordBook{" +
                "id='" + id + '\'' +
                ", wordBookName='" + wordBookName + '\'' +
                '}';
    }
}

