package com.hzj.myblog.exception;

import com.hzj.myblog.entity.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局的错误处理方法
 *
 * @author 何志坚
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理请求参数不符合要求的错误信息
     *
     * @param methodArgumentNotValidException 抛出的异常
     * @param request                         请求
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest request) {
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        for (ObjectError error : bindingResult.getAllErrors()) {
            String message = error.getDefaultMessage();
            logger.error("参数不符合要求: " + message);
            ErrorResponse representation = new ErrorResponse(message, methodArgumentNotValidException.getClass().getName(), request.getRequestURI());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
        }
        return null;
    }

    /**
     * jwt验证异常处理
     *
     * @param expiredJwtException 抛出的异常
     * @param request             请求
     * @return 错误信息
     */
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorResponse> token(ExpiredJwtException expiredJwtException, HttpServletRequest request) {
        logger.error("token过期");
        ErrorResponse response = new ErrorResponse("权限不够", expiredJwtException.getClass().getName(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    /**
     * 权限不足的异常
     *
     * @param levelException 权限异常
     * @param request        请求
     * @return 错误信息
     */
    @ExceptionHandler(LevelException.class)
    public ResponseEntity<ErrorResponse> level(LevelException levelException, HttpServletRequest request) {
        logger.error("权限不足");
        ErrorResponse response = new ErrorResponse("权限不足", levelException.getClass().getName(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}

