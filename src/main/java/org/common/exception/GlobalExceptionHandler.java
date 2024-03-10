package org.common.exception;

/**
 * ClassName: GlobalExceptionHandler
 * Package: org.common.exception
 * Description:
 *
 * @Author: @weixueshi
 * @Create: 2024/3/10 - 11:59
 * @Version: v1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.common.response.ResponseCodeEnum;
import org.common.response.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResultData systemExceptionHandler(Exception e){
        log.info("运行时异常：",e);
        return ResultData.fail(ResponseCodeEnum.NEED_LOGIN.getCode(),e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public ResultData systemExceptionHandler(SystemException e){
        log.info("系统异常：",e);
        return ResultData.fail(e.getCode(),e.getMessage());
    }
}
