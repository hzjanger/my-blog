package com.hzj.myblog.exception;

/**
 * 验证码错误异常
 *
 * @author hzj
 */
public class VerificationCodeException extends RuntimeException {

    public VerificationCodeException() {
    }

    public VerificationCodeException(String message) {
        super(message);
    }
}
