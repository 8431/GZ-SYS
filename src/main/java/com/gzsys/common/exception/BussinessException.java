/**
 * projectName: fendo-plus-boot
 * fileName: BussinessException.java
 * packageName: com.gzsys.common.exception
 * date: 2018-02-01 2:34
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.exception;

/**
 * @version: V1.0
 * @author: fendo
 * @className: BussinessException
 * @packageName: com.gzsys.common.exception
 * @description: 业务异常
 * @data: 2018-02-01 2:34
 **/
public class BussinessException extends BaseException{

    public BussinessException(BaseExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
    }

}
