package com.hzj.myblog.utils;

import java.util.UUID;

/**
 *
 * @author 何志坚
 */
public class Constant {
    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 加密密文
     */
    public static final String JWT_SECRET = "098f6bcd4621d373cade4e832627b4f6";

    public static final int JWT_TTL = 8 * 60 * 60 * 1000;
}
