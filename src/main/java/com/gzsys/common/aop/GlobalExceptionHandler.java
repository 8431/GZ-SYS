/**
 * projectName: fendo-plus-boot
 * fileName: GlobalExceptionHandler.java
 * packageName: com.fendo.shiro.common.aop
 * date: 2018-01-22 17:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.aop;

import com.gzsys.common.util.SimpleCode;
import com.gzsys.common.util.SimpleResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version: V1.0
 * @author: fendo
 * @className: GlobalExceptionHandler
 * @packageName: com.fendo.shiro.common.aop
 * @description: 全局异常处理（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 * @data: 2018-01-22 17:22
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());



    /**
     * 拦截未知的运行时异常
     *
     * @author fengshuonan
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public SimpleResult notFount(RuntimeException e) {
        log.error("运行时异常:", e);
        return new SimpleResult(SimpleCode.SERVER_ERROR.getCode(),SimpleCode.SERVER_ERROR.getMessage());
    }

}
