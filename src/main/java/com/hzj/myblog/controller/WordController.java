package com.hzj.myblog.controller;

import com.hzj.myblog.entity.Word;
import com.hzj.myblog.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单词control
 *
 * @author hzj
 */
@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @PostMapping("/addWord")
    public boolean addWord(@RequestBody Word word) {
        return wordService.addWord(word);
    }
}
