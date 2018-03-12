/*
* UserBase.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title USER_BASE表的实体类
 * @Description 用户基础信息
 * @version 1.0
 * @Author fendo
 * @Date 2018-01-31 20:56:10
 */
@ApiModel(value="UserBase对象",description="用户信息")
@TableName("USER_BASE")
public class UserBase extends Model<UserBase> {
    /**
     * @Fields id 主键 用户ID
     */
    @ApiModelProperty(hidden=true)
    @TableId("ID")
    private String id;

    /**
     * @Fields userRole 2正常用户 3禁言用户 4虚拟用户 5运营
     */
    @ApiModelProperty(value = "用户角色")
    @TableField("USER_ROLE")
    private String userRole;

    /**
     * @Fields userName 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    @TableField("USER_NAME")
    private String userName;

    /**
     * @Fields gender 用户性别 0-female 1-male
     */
    @ApiModelProperty(value = "用户性别（0女1男）")
    private String gender;

    /**
     * @Fields birthday 用户生日
     */
    @ApiModelProperty(value = "用户生日")
    private String birthday;

    /**
     * @Fields idCard 身份证
     */
    @ApiModelProperty(value = "身份证")
    @TableField("ID_CARD")
    private String idCard;

    /**
     * @Fields mobile 手机号码(联系方式)
     */
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    /**
     * @Fields email 邮箱(唯一)
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * @Fields face 头像
     */
    @ApiModelProperty(value = "头像")
    private String face;

    /**
     * @Fields face200 头像 200x200x80
     */
    @ApiModelProperty(value = "头像")
    private String face200;

    /**
     * @Fields srcface 原图头像
     */
    @ApiModelProperty(value = "原图头像")
    private String srcface;

    /**
     * @Fields medicalCard 医保卡号
     */
    @ApiModelProperty(value = "医保卡号")
    @TableField("MEDICAL_CARD")
    private String medicalCard;

    /**
     * @Fields referralCode 推荐码
     */
    @ApiModelProperty(value = "推荐码")
    @TableField("REFERRAL_CODE")
    private String referralCode;

    /**
     * @Fields begood 擅长
     */
    @ApiModelProperty(value = "擅长")
    private String begood;

    /**
     * @Fields title 职称
     */
    @ApiModelProperty(value = "职称")
    private String title;

    /**
     * @Fields department 科室
     */
    @ApiModelProperty(value = "科室")
    private String department;

    /**
     * @Fields hospital 所属医院
     */
    @ApiModelProperty(value = "所属医院")
    private String hospital;

    /**
     * @Fields signature 电子签章
     */
    @ApiModelProperty(value = "电子签章")
    private String signature;

    /**
     * @Fields inPost 是否在岗
     */
    @ApiModelProperty(value = "是否在岗（0不在岗1在岗2离开）")
    @TableField("IN_POST")
    private String inPost;

    /**
     * @Fields createTime 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * @Fields createName 创建名称
     */
    @ApiModelProperty(value = "创建名称")
    @TableField("CREATE_NAME")
    private String createName;

    /**
     * @Fields updateTime 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * @Fields updateName 更新名称
     */
    @ApiModelProperty(value = "更新名称")
    @TableField("UPDATE_NAME")
    private String updateName;

    /**
     * @Fields state 删除标记位 0已删除 1未删除
     */
    @ApiModelProperty(value = "删除标记位")
    private String state;

    /**
     * @Fields lastInlineTime 上次在线时间
     */
    @ApiModelProperty(value = "上次在线时间")
    @TableField("LAST_INLINE_TIME")
    private Date lastInlineTime;

    /**
     * 获取 主键 用户ID 字段:USER_BASE.ID
     *
     * @return USER_BASE.ID, 主键 用户ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 主键 用户ID 字段:USER_BASE.ID
     *
     * @param id the value for USER_BASE.ID, 主键 用户ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 2正常用户 3禁言用户 4虚拟用户 5运营 字段:USER_BASE.USER_ROLE
     *
     * @return USER_BASE.USER_ROLE, 2正常用户 3禁言用户 4虚拟用户 5运营
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置 2正常用户 3禁言用户 4虚拟用户 5运营 字段:USER_BASE.USER_ROLE
     *
     * @param userRole the value for USER_BASE.USER_ROLE, 2正常用户 3禁言用户 4虚拟用户 5运营
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    /**
     * 获取 用户姓名 字段:USER_BASE.USER_NAME
     *
     * @return USER_BASE.USER_NAME, 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户姓名 字段:USER_BASE.USER_NAME
     *
     * @param userName the value for USER_BASE.USER_NAME, 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取 用户性别 0-female 1-male 字段:USER_BASE.GENDER
     *
     * @return USER_BASE.GENDER, 用户性别 0-female 1-male
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置 用户性别 0-female 1-male 字段:USER_BASE.GENDER
     *
     * @param gender the value for USER_BASE.GENDER, 用户性别 0-female 1-male
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取 用户生日 字段:USER_BASE.BIRTHDAY
     *
     * @return USER_BASE.BIRTHDAY, 用户生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置 用户生日 字段:USER_BASE.BIRTHDAY
     *
     * @param birthday the value for USER_BASE.BIRTHDAY, 用户生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 获取 身份证 字段:USER_BASE.ID_CARD
     *
     * @return USER_BASE.ID_CARD, 身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置 身份证 字段:USER_BASE.ID_CARD
     *
     * @param idCard the value for USER_BASE.ID_CARD, 身份证
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取 手机号码(联系方式) 字段:USER_BASE.MOBILE
     *
     * @return USER_BASE.MOBILE, 手机号码(联系方式)
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 手机号码(联系方式) 字段:USER_BASE.MOBILE
     *
     * @param mobile the value for USER_BASE.MOBILE, 手机号码(联系方式)
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取 邮箱(唯一) 字段:USER_BASE.EMAIL
     *
     * @return USER_BASE.EMAIL, 邮箱(唯一)
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 邮箱(唯一) 字段:USER_BASE.EMAIL
     *
     * @param email the value for USER_BASE.EMAIL, 邮箱(唯一)
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取 头像 字段:USER_BASE.FACE
     *
     * @return USER_BASE.FACE, 头像
     */
    public String getFace() {
        return face;
    }

    /**
     * 设置 头像 字段:USER_BASE.FACE
     *
     * @param face the value for USER_BASE.FACE, 头像
     */
    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

    /**
     * 获取 头像 200x200x80 字段:USER_BASE.FACE200
     *
     * @return USER_BASE.FACE200, 头像 200x200x80
     */
    public String getFace200() {
        return face200;
    }

    /**
     * 设置 头像 200x200x80 字段:USER_BASE.FACE200
     *
     * @param face200 the value for USER_BASE.FACE200, 头像 200x200x80
     */
    public void setFace200(String face200) {
        this.face200 = face200 == null ? null : face200.trim();
    }

    /**
     * 获取 原图头像 字段:USER_BASE.SRCFACE
     *
     * @return USER_BASE.SRCFACE, 原图头像
     */
    public String getSrcface() {
        return srcface;
    }

    /**
     * 设置 原图头像 字段:USER_BASE.SRCFACE
     *
     * @param srcface the value for USER_BASE.SRCFACE, 原图头像
     */
    public void setSrcface(String srcface) {
        this.srcface = srcface == null ? null : srcface.trim();
    }

    /**
     * 获取 医保卡号 字段:USER_BASE.MEDICAL_CARD
     *
     * @return USER_BASE.MEDICAL_CARD, 医保卡号
     */
    public String getMedicalCard() {
        return medicalCard;
    }

    /**
     * 设置 医保卡号 字段:USER_BASE.MEDICAL_CARD
     *
     * @param medicalCard the value for USER_BASE.MEDICAL_CARD, 医保卡号
     */
    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard == null ? null : medicalCard.trim();
    }

    /**
     * 获取 推荐码 字段:USER_BASE.REFERRAL_CODE
     *
     * @return USER_BASE.REFERRAL_CODE, 推荐码
     */
    public String getReferralCode() {
        return referralCode;
    }

    /**
     * 设置 推荐码 字段:USER_BASE.REFERRAL_CODE
     *
     * @param referralCode the value for USER_BASE.REFERRAL_CODE, 推荐码
     */
    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode == null ? null : referralCode.trim();
    }

    /**
     * 获取 擅长 字段:USER_BASE.BEGOOD
     *
     * @return USER_BASE.BEGOOD, 擅长
     */
    public String getBegood() {
        return begood;
    }

    /**
     * 设置 擅长 字段:USER_BASE.BEGOOD
     *
     * @param begood the value for USER_BASE.BEGOOD, 擅长
     */
    public void setBegood(String begood) {
        this.begood = begood == null ? null : begood.trim();
    }

    /**
     * 获取 职称 字段:USER_BASE.TITLE
     *
     * @return USER_BASE.TITLE, 职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 职称 字段:USER_BASE.TITLE
     *
     * @param title the value for USER_BASE.TITLE, 职称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取 科室 字段:USER_BASE.DEPARTMENT
     *
     * @return USER_BASE.DEPARTMENT, 科室
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置 科室 字段:USER_BASE.DEPARTMENT
     *
     * @param department the value for USER_BASE.DEPARTMENT, 科室
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 获取 所属医院 字段:USER_BASE.HOSPITAL
     *
     * @return USER_BASE.HOSPITAL, 所属医院
     */
    public String getHospital() {
        return hospital;
    }

    /**
     * 设置 所属医院 字段:USER_BASE.HOSPITAL
     *
     * @param hospital the value for USER_BASE.HOSPITAL, 所属医院
     */
    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    /**
     * 获取 电子签章 字段:USER_BASE.SIGNATURE
     *
     * @return USER_BASE.SIGNATURE, 电子签章
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置 电子签章 字段:USER_BASE.SIGNATURE
     *
     * @param signature the value for USER_BASE.SIGNATURE, 电子签章
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 获取 是否在岗 字段:USER_BASE.IN_POST
     *
     * @return USER_BASE.IN_POST, 是否在岗
     */
    public String getInPost() {
        return inPost;
    }

    /**
     * 设置 是否在岗 字段:USER_BASE.IN_POST
     *
     * @param inPost the value for USER_BASE.IN_POST, 是否在岗
     */
    public void setInPost(String inPost) {
        this.inPost = inPost == null ? null : inPost.trim();
    }

    /**
     * 获取 创建时间 字段:USER_BASE.CREATE_TIME
     *
     * @return USER_BASE.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:USER_BASE.CREATE_TIME
     *
     * @param createTime the value for USER_BASE.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建名称 字段:USER_BASE.CREATE_NAME
     *
     * @return USER_BASE.CREATE_NAME, 创建名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置 创建名称 字段:USER_BASE.CREATE_NAME
     *
     * @param createName the value for USER_BASE.CREATE_NAME, 创建名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取 更新时间 字段:USER_BASE.UPDATE_TIME
     *
     * @return USER_BASE.UPDATE_TIME, 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:USER_BASE.UPDATE_TIME
     *
     * @param updateTime the value for USER_BASE.UPDATE_TIME, 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新名称 字段:USER_BASE.UPDATE_NAME
     *
     * @return USER_BASE.UPDATE_NAME, 更新名称
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置 更新名称 字段:USER_BASE.UPDATE_NAME
     *
     * @param updateName the value for USER_BASE.UPDATE_NAME, 更新名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * 获取 删除标记位 0已删除 1未删除 字段:USER_BASE.STATE
     *
     * @return USER_BASE.STATE, 删除标记位 0已删除 1未删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标记位 0已删除 1未删除 字段:USER_BASE.STATE
     *
     * @param state the value for USER_BASE.STATE, 删除标记位 0已删除 1未删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getLastInlineTime() {
        return lastInlineTime;
    }

    public void setLastInlineTime(Date lastInlineTime) {
        this.lastInlineTime = lastInlineTime;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}