package com.hzj.myblog.exception;

/**
 * 等级不够抛出的异常
 *
 * @author hzj
 */
public class LevelException extends RuntimeException {

    public LevelException() {
    }

    public LevelException(String message) {
        super(message);
    }
}
