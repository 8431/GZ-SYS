/*
* HealtLogHistory.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title HEALTH_LOG_HISTORY表的实体类
 * @Description 日志信息
 * @version 1.0
 * @Author fendo
 * @Date 2018-01-31 20:56:10
 */
@TableName("HEALTH_LOG_HISTORY")
@ApiModel(value="HealtLogHistory对象",description="日志信息")
public class HealtLogHistory extends Model<HealtLogHistory> {
    /**
     * @Fields id 主键
     */
    @ApiModelProperty(hidden=true)
    private String id;

    /**
     * @Fields appId 应用编号
     */
    @ApiModelProperty(value = "应用编号")
    private String appId;

    /**
     * @Fields logLevel 日志级别
     */
    @ApiModelProperty(value = "日志级别")
    private String logLevel;

    /**
     * @Fields logType 日志类型
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;

    /**
     * @Fields logObject 日志对象
     */
    @ApiModelProperty(value = "日志对象")
    private String logObject;

    /**
     * @Fields logMethod 日志方法
     */
    @ApiModelProperty(value = "日志方法")
    private String logMethod;

    /**
     * @Fields logOp 日志操作
     */
    @ApiModelProperty(value = "日志操作")
    private String logOp;

    /**
     * @Fields logIp 客户端IP
     */
    @ApiModelProperty(value = "客户端IP")
    private String logIp;

    /**
     * @Fields logMessageDesc 日志信息描述
     */
    @ApiModelProperty(value = "日志信息描述")
    private String logMessageDesc;

    /**
     * @Fields logOperation 操作信息
     */
    @ApiModelProperty(value = "操作信息")
    private String logOperation;

    /**
     * @Fields logException 异常信息
     */
    @ApiModelProperty(value = "异常信息")
    private String logException;

    /**
     * @Fields createTime 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * @Fields createName 创建名称
     */
    @ApiModelProperty(value = "创建名称")
    private String createName;

    /**
     * @Fields updateTime 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * @Fields updateName 更新名称
     */
    @ApiModelProperty(value = "更新名称")
    private String updateName;

    /**
     * @Fields state 删除标记位 0已删除 1未删除
     */
    @ApiModelProperty(value = "删除标记位")
    private String state;

    /**
     * 获取 主键 字段:HEALTH_LOG_HISTORY.ID
     *
     * @return HEALTH_LOG_HISTORY.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:HEALTH_LOG_HISTORY.ID
     *
     * @param id the value for HEALTH_LOG_HISTORY.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 应用编号 字段:HEALTH_LOG_HISTORY.APP_ID
     *
     * @return HEALTH_LOG_HISTORY.APP_ID, 应用编号
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 应用编号 字段:HEALTH_LOG_HISTORY.APP_ID
     *
     * @param appId the value for HEALTH_LOG_HISTORY.APP_ID, 应用编号
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取 日志级别 字段:HEALTH_LOG_HISTORY.LOG_LEVEL
     *
     * @return HEALTH_LOG_HISTORY.LOG_LEVEL, 日志级别
     */
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * 设置 日志级别 字段:HEALTH_LOG_HISTORY.LOG_LEVEL
     *
     * @param logLevel the value for HEALTH_LOG_HISTORY.LOG_LEVEL, 日志级别
     */
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel == null ? null : logLevel.trim();
    }

    /**
     * 获取 日志类型 字段:HEALTH_LOG_HISTORY.LOG_TYPE
     *
     * @return HEALTH_LOG_HISTORY.LOG_TYPE, 日志类型
     */
    public String getLogType() {
        return logType;
    }

    /**
     * 设置 日志类型 字段:HEALTH_LOG_HISTORY.LOG_TYPE
     *
     * @param logType the value for HEALTH_LOG_HISTORY.LOG_TYPE, 日志类型
     */
    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    /**
     * 获取 日志对象 字段:HEALTH_LOG_HISTORY.LOG_OBJECT
     *
     * @return HEALTH_LOG_HISTORY.LOG_OBJECT, 日志对象
     */
    public String getLogObject() {
        return logObject;
    }

    /**
     * 设置 日志对象 字段:HEALTH_LOG_HISTORY.LOG_OBJECT
     *
     * @param logObject the value for HEALTH_LOG_HISTORY.LOG_OBJECT, 日志对象
     */
    public void setLogObject(String logObject) {
        this.logObject = logObject == null ? null : logObject.trim();
    }

    /**
     * 获取 日志方法 字段:HEALTH_LOG_HISTORY.LOG_METHOD
     *
     * @return HEALTH_LOG_HISTORY.LOG_METHOD, 日志方法
     */
    public String getLogMethod() {
        return logMethod;
    }

    /**
     * 设置 日志方法 字段:HEALTH_LOG_HISTORY.LOG_METHOD
     *
     * @param logMethod the value for HEALTH_LOG_HISTORY.LOG_METHOD, 日志方法
     */
    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod == null ? null : logMethod.trim();
    }

    /**
     * 获取 日志操作 字段:HEALTH_LOG_HISTORY.LOG_OP
     *
     * @return HEALTH_LOG_HISTORY.LOG_OP, 日志操作
     */
    public String getLogOp() {
        return logOp;
    }

    /**
     * 设置 日志操作 字段:HEALTH_LOG_HISTORY.LOG_OP
     *
     * @param logOp the value for HEALTH_LOG_HISTORY.LOG_OP, 日志操作
     */
    public void setLogOp(String logOp) {
        this.logOp = logOp == null ? null : logOp.trim();
    }

    /**
     * 获取 客户端IP 字段:HEALTH_LOG_HISTORY.LOG_IP
     *
     * @return HEALTH_LOG_HISTORY.LOG_IP, 客户端IP
     */
    public String getLogIp() {
        return logIp;
    }

    /**
     * 设置 客户端IP 字段:HEALTH_LOG_HISTORY.LOG_IP
     *
     * @param logIp the value for HEALTH_LOG_HISTORY.LOG_IP, 客户端IP
     */
    public void setLogIp(String logIp) {
        this.logIp = logIp == null ? null : logIp.trim();
    }

    /**
     * 获取 日志信息描述 字段:HEALTH_LOG_HISTORY.LOG_MESSAGE_DESC
     *
     * @return HEALTH_LOG_HISTORY.LOG_MESSAGE_DESC, 日志信息描述
     */
    public String getLogMessageDesc() {
        return logMessageDesc;
    }

    /**
     * 设置 日志信息描述 字段:HEALTH_LOG_HISTORY.LOG_MESSAGE_DESC
     *
     * @param logMessageDesc the value for HEALTH_LOG_HISTORY.LOG_MESSAGE_DESC, 日志信息描述
     */
    public void setLogMessageDesc(String logMessageDesc) {
        this.logMessageDesc = logMessageDesc == null ? null : logMessageDesc.trim();
    }

    /**
     * 获取 操作信息 字段:HEALTH_LOG_HISTORY.LOG_OPERATION
     *
     * @return HEALTH_LOG_HISTORY.LOG_OPERATION, 操作信息
     */
    public String getLogOperation() {
        return logOperation;
    }

    /**
     * 设置 操作信息 字段:HEALTH_LOG_HISTORY.LOG_OPERATION
     *
     * @param logOperation the value for HEALTH_LOG_HISTORY.LOG_OPERATION, 操作信息
     */
    public void setLogOperation(String logOperation) {
        this.logOperation = logOperation == null ? null : logOperation.trim();
    }

    /**
     * 获取 异常信息 字段:HEALTH_LOG_HISTORY.LOG_EXCEPTION
     *
     * @return HEALTH_LOG_HISTORY.LOG_EXCEPTION, 异常信息
     */
    public String getLogException() {
        return logException;
    }

    /**
     * 设置 异常信息 字段:HEALTH_LOG_HISTORY.LOG_EXCEPTION
     *
     * @param logException the value for HEALTH_LOG_HISTORY.LOG_EXCEPTION, 异常信息
     */
    public void setLogException(String logException) {
        this.logException = logException == null ? null : logException.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTH_LOG_HISTORY.CREATE_TIME
     *
     * @return HEALTH_LOG_HISTORY.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:HEALTH_LOG_HISTORY.CREATE_TIME
     *
     * @param createTime the value for HEALTH_LOG_HISTORY.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建名称 字段:HEALTH_LOG_HISTORY.CREATE_NAME
     *
     * @return HEALTH_LOG_HISTORY.CREATE_NAME, 创建名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置 创建名称 字段:HEALTH_LOG_HISTORY.CREATE_NAME
     *
     * @param createName the value for HEALTH_LOG_HISTORY.CREATE_NAME, 创建名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取 更新时间 字段:HEALTH_LOG_HISTORY.UPDATE_TIME
     *
     * @return HEALTH_LOG_HISTORY.UPDATE_TIME, 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:HEALTH_LOG_HISTORY.UPDATE_TIME
     *
     * @param updateTime the value for HEALTH_LOG_HISTORY.UPDATE_TIME, 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新名称 字段:HEALTH_LOG_HISTORY.UPDATE_NAME
     *
     * @return HEALTH_LOG_HISTORY.UPDATE_NAME, 更新名称
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置 更新名称 字段:HEALTH_LOG_HISTORY.UPDATE_NAME
     *
     * @param updateName the value for HEALTH_LOG_HISTORY.UPDATE_NAME, 更新名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * 获取 删除标记位 0已删除 1未删除 字段:HEALTH_LOG_HISTORY.STATE
     *
     * @return HEALTH_LOG_HISTORY.STATE, 删除标记位 0已删除 1未删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标记位 0已删除 1未删除 字段:HEALTH_LOG_HISTORY.STATE
     *
     * @param state the value for HEALTH_LOG_HISTORY.STATE, 删除标记位 0已删除 1未删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * :HEALTH_LOG_HISTORY
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", logLevel=").append(logLevel);
        sb.append(", logType=").append(logType);
        sb.append(", logObject=").append(logObject);
        sb.append(", logMethod=").append(logMethod);
        sb.append(", logOp=").append(logOp);
        sb.append(", logIp=").append(logIp);
        sb.append(", logMessageDesc=").append(logMessageDesc);
        sb.append(", logOperation=").append(logOperation);
        sb.append(", logException=").append(logException);
        sb.append(", createTime=").append(createTime);
        sb.append(", createName=").append(createName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateName=").append(updateName);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }

    /**
     * :HEALTH_LOG_HISTORY
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        HealtLogHistory other = (HealtLogHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getLogLevel() == null ? other.getLogLevel() == null : this.getLogLevel().equals(other.getLogLevel()))
            && (this.getLogType() == null ? other.getLogType() == null : this.getLogType().equals(other.getLogType()))
            && (this.getLogObject() == null ? other.getLogObject() == null : this.getLogObject().equals(other.getLogObject()))
            && (this.getLogMethod() == null ? other.getLogMethod() == null : this.getLogMethod().equals(other.getLogMethod()))
            && (this.getLogOp() == null ? other.getLogOp() == null : this.getLogOp().equals(other.getLogOp()))
            && (this.getLogIp() == null ? other.getLogIp() == null : this.getLogIp().equals(other.getLogIp()))
            && (this.getLogMessageDesc() == null ? other.getLogMessageDesc() == null : this.getLogMessageDesc().equals(other.getLogMessageDesc()))
            && (this.getLogOperation() == null ? other.getLogOperation() == null : this.getLogOperation().equals(other.getLogOperation()))
            && (this.getLogException() == null ? other.getLogException() == null : this.getLogException().equals(other.getLogException()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    /**
     * :HEALTH_LOG_HISTORY
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getLogLevel() == null) ? 0 : getLogLevel().hashCode());
        result = prime * result + ((getLogType() == null) ? 0 : getLogType().hashCode());
        result = prime * result + ((getLogObject() == null) ? 0 : getLogObject().hashCode());
        result = prime * result + ((getLogMethod() == null) ? 0 : getLogMethod().hashCode());
        result = prime * result + ((getLogOp() == null) ? 0 : getLogOp().hashCode());
        result = prime * result + ((getLogIp() == null) ? 0 : getLogIp().hashCode());
        result = prime * result + ((getLogMessageDesc() == null) ? 0 : getLogMessageDesc().hashCode());
        result = prime * result + ((getLogOperation() == null) ? 0 : getLogOperation().hashCode());
        result = prime * result + ((getLogException() == null) ? 0 : getLogException().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}