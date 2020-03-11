package com.hzj.myblog.service;

import com.hzj.myblog.entity.Word;
import com.hzj.myblog.mapper.WordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 单词service
 *
 * @author hzj
 */
@Service
public class WordService {

    @Autowired
    private WordMapper wordMapper;

    /**
     * 添加单词
     *
     * @param word 单词
     * @return true: 添加成功， false： 添加失败
     */
    public boolean addWord(Word word) {
        try {
            word.setWord(word.getWord().toLowerCase());
            wordMapper.addWordTOA(word);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
