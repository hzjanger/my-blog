package com.hzj.myblog.mapper;

import com.hzj.myblog.entity.Word;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * 单词mapper
 * @author hzj
 */
@Component
public interface WordMapper {
    /**
     * 添加单词
     * @param word 单词
     * @return true: 添加成功
     */
    boolean addWordTOA(Word word);
}
