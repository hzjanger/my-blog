package com.hzj.myblog.utils;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Random;

/**
 * 随机数生成
 *
 * @author hzj
 */
public class RandomUtilsTest {

    /**
     * 生成随机码值，包含数字、大小写字母
     */
    @Test
    public void getRandomCodeTest(){
        String randomCode = RandomUtils.getRandomCode(6);
        System.out.println(randomCode);
    }

    @Test
    public void nowDate() {
        System.out.println(new Date());
    }
}
