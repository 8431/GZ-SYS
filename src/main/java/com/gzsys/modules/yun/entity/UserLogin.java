/*
* UserLogin.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title USER_LOGIN表的实体类
 * @Description 用户登录表
 * @version 1.0
 * @Author fendo
 * @Date 2018-01-31 20:56:10
 */
@TableName("USER_LOGIN")
@ApiModel(value="UserLogin对象",description="用户登录表")
public class UserLogin extends Model<UserLogin> {
    /**
     * @Fields id 主键
     */
    @ApiModelProperty(hidden=true)
	@TableId(value="ID")
    private String id;

    /**
     * @Fields identityType 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
     */
    @ApiModelProperty(value = "登陆类型")
    private String identityType;

    /**
     * @Fields userType 用户类型 1患者 2医生
     */
    @ApiModelProperty(value = "用户类型")
    private String userType;

    /**
     * @Fields identifier 手机号 邮箱 用户名或第三方应用的唯一标识
     */
    @ApiModelProperty(value = "唯一标识")
    private String identifier;

    /**
     * @Fields certificate 密码凭证(站内的保存密码，站外的不保存或保存token)
     */
    @ApiModelProperty(value = "密码凭证")
    private String certificate;

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
     * 获取 主键 字段:USER_LOGIN.ID
     *
     * @return USER_LOGIN.ID, 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 字段:USER_LOGIN.ID
     *
     * @param id the value for USER_LOGIN.ID, 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博 字段:USER_LOGIN.IDENTITY_TYPE
     *
     * @return USER_LOGIN.IDENTITY_TYPE, 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * 设置 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博 字段:USER_LOGIN.IDENTITY_TYPE
     *
     * @param identityType the value for USER_LOGIN.IDENTITY_TYPE, 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * 获取 用户类型 1患者 2医生 字段:USER_LOGIN.USER_TYPE
     *
     * @return USER_LOGIN.USER_TYPE, 用户类型 1患者 2医生
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置 用户类型 1患者 2医生 字段:USER_LOGIN.USER_TYPE
     *
     * @param userType the value for USER_LOGIN.USER_TYPE, 用户类型 1患者 2医生
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取 手机号 邮箱 用户名或第三方应用的唯一标识 字段:USER_LOGIN.IDENTIFIER
     *
     * @return USER_LOGIN.IDENTIFIER, 手机号 邮箱 用户名或第三方应用的唯一标识
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 设置 手机号 邮箱 用户名或第三方应用的唯一标识 字段:USER_LOGIN.IDENTIFIER
     *
     * @param identifier the value for USER_LOGIN.IDENTIFIER, 手机号 邮箱 用户名或第三方应用的唯一标识
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * 获取 密码凭证(站内的保存密码，站外的不保存或保存token) 字段:USER_LOGIN.CERTIFICATE
     *
     * @return USER_LOGIN.CERTIFICATE, 密码凭证(站内的保存密码，站外的不保存或保存token)
     */
    public String getCertificate() {
        return certificate;
    }

    /**
     * 设置 密码凭证(站内的保存密码，站外的不保存或保存token) 字段:USER_LOGIN.CERTIFICATE
     *
     * @param certificate the value for USER_LOGIN.CERTIFICATE, 密码凭证(站内的保存密码，站外的不保存或保存token)
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    /**
     * 获取 创建时间 字段:USER_LOGIN.CREATE_TIME
     *
     * @return USER_LOGIN.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:USER_LOGIN.CREATE_TIME
     *
     * @param createTime the value for USER_LOGIN.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建名称 字段:USER_LOGIN.CREATE_NAME
     *
     * @return USER_LOGIN.CREATE_NAME, 创建名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置 创建名称 字段:USER_LOGIN.CREATE_NAME
     *
     * @param createName the value for USER_LOGIN.CREATE_NAME, 创建名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取 更新时间 字段:USER_LOGIN.UPDATE_TIME
     *
     * @return USER_LOGIN.UPDATE_TIME, 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:USER_LOGIN.UPDATE_TIME
     *
     * @param updateTime the value for USER_LOGIN.UPDATE_TIME, 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新名称 字段:USER_LOGIN.UPDATE_NAME
     *
     * @return USER_LOGIN.UPDATE_NAME, 更新名称
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置 更新名称 字段:USER_LOGIN.UPDATE_NAME
     *
     * @param updateName the value for USER_LOGIN.UPDATE_NAME, 更新名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * 获取 删除标记位 0已删除 1未删除 字段:USER_LOGIN.STATE
     *
     * @return USER_LOGIN.STATE, 删除标记位 0已删除 1未删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标记位 0已删除 1未删除 字段:USER_LOGIN.STATE
     *
     * @param state the value for USER_LOGIN.STATE, 删除标记位 0已删除 1未删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}