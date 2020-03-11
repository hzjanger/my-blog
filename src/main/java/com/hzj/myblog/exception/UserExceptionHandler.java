package com.hzj.myblog.exception;

import com.hzj.myblog.controller.UserController;
import com.hzj.myblog.entity.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户操作的异常信息处理
 *
 * @author hzj
 */
@RestControllerAdvice(assignableTypes = {UserController.class})
public class UserExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(VerificationCodeException.class)
    public ResponseEntity<ErrorResponse> verificationCodeException(VerificationCodeException verificationCodeException, HttpServletRequest request) {
        logger.error("注册时验证码错误");
        ErrorResponse response = new ErrorResponse(verificationCodeException.getMessage(), verificationCodeException.getClass().getName(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
