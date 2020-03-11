package com.hzj.myblog.utils;

import java.util.Random;

/**
 * 随机生成数字
 *
 * @author hzj
 */
public class RandomUtils {

    /**
     * 生成随机码值，包含数字、大小写字母
     *
     * @param number 生成的随机码位数
     * @return 生成的随机数
     */
    public static String getRandomCode(int number) {
        StringBuilder codeNum = new StringBuilder();
        int[] code = new int[3];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum.append((char) code[random.nextInt(3)]);
        }

        return codeNum.toString();
    }
}
