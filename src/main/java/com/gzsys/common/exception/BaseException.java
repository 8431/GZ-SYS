/**
 * projectName: fendo-plus-boot
 * fileName: BaseException.java
 * packageName: com.gzsys.common.exception
 * date: 2018-02-01 2:31
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.exception;

/**
 * @version: V1.0
 * @author: fendo
 * @className: BaseException
 * @packageName: com.gzsys.common.exception
 * @description: 业务异常封装
 * @data: 2018-02-01 2:31
 **/
public class BaseException extends RuntimeException{

    /**
     * 友好提示的code码
     */
    protected int friendlyCode;

    /**
     * 友好提示
     */
    protected String friendlyMsg;

    /**
     * 业务异常跳转的页面
     */
    protected String urlPath;

    protected BaseException(int friendlyCode, String friendlyMsg, String urlPath) {
        this.setValues(friendlyCode, friendlyMsg, urlPath);
    }

    public BaseException(BaseExceptionEnum bizExceptionEnum) {
        this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
    }

    private void setValues(int friendlyCode, String friendlyMsg, String urlPath) {
        this.friendlyCode = friendlyCode;
        this.friendlyMsg = friendlyMsg;
        this.urlPath = urlPath;
    }

    public int getCode() {
        return friendlyCode;
    }

    public void setCode(int code) {
        this.friendlyCode = code;
    }

    @Override
    public String getMessage() {
        return friendlyMsg;
    }

    public void setMessage(String message) {
        this.friendlyMsg = message;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }


}
