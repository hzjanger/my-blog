package com.hzj.myblog.entity;

/**
 * @author hzj
 */
public class Word {
    private String word;
    private String translation;
    private String voidSrc;
    private String phonetic;

    public Word() {
    }

    public Word(String word, String translation, String voidSrc, String phonetic) {
        this.word = word;
        this.translation = translation;
        this.voidSrc = voidSrc;
        this.phonetic = phonetic;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getVoidSrc() {
        return voidSrc;
    }

    public void setVoidSrc(String voidSrc) {
        this.voidSrc = voidSrc;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                ", voidSrc='" + voidSrc + '\'' +
                ", phonetic='" + phonetic + '\'' +
                '}';
    }
}
