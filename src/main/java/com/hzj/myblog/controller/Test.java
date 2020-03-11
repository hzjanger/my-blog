package com.hzj.myblog.controller;

import com.hzj.myblog.entity.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzj
 */

@RestController
public class Test {
    @RequestMapping("/test")
    public List<Word> test() {
        List<Word> list = new ArrayList<>();
        list.add(new Word("tape", "n.胶带", "", "[teɪp]"));
        list.add(new Word("put", "n.放下", "", "[teɪp]"));
        list.add(new Word("caterpillar", "n.毛虫", "", "[teɪp]"));
        list.add(new Word("cocoon", "n.尖", "", "[teɪp]"));
        list.add(new Word("egg", "n.蛋", "", "[teɪp]"));
        list.add(new Word("anyone", "pron.任何人", "", ""));
        return list;
    }
}
