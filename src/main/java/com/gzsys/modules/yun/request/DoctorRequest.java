/**
 * projectName: GZ
 * fileName: DoctorRequest.java
 * packageName: com.gzsys.modules.yun.request
 * date: 2018-02-26 11:16
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.request;

import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DoctorRequest
 * @packageName: com.gzsys.modules.yun.request
 * @description: 医生信息
 * @data: 2018-02-26 11:16
 **/
@ApiModel(value="Doctor对象",description="医生信息")
public class DoctorRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields id 主键 用户ID
     */
    @ApiModelProperty(value = "用户ID",name="userId",example="123456789")
    private String userId;

    /**
     * @Fields userRole 2正常用户 3禁言用户 4虚拟用户 5运营
     */
    @ApiModelProperty(value = "用户角色",name="userRole",example="admin")
    private String userRole;

    /**
     * @Fields userName 用户姓名
     */
    @ApiModelProperty(value = "用户姓名", required = true ,name="userName",example="fendo")
    private String userName;

    /**
     * @Fields gender 用户性别 0-female 1-male
     */
    @ApiModelProperty(value = "用户性别")
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
    private String medicalCard;

    /**
     * @Fields referralCode 推荐码
     */
    @ApiModelProperty(value = "推荐码")
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
    @ApiModelProperty(value = "是否在岗")
    private String inPost;


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


    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getFace200() {
        return face200;
    }

    public void setFace200(String face200) {
        this.face200 = face200;
    }

    public String getSrcface() {
        return srcface;
    }

    public void setSrcface(String srcface) {
        this.srcface = srcface;
    }

    public String getMedicalCard() {
        return medicalCard;
    }

    public void setMedicalCard(String medicalCard) {
        this.medicalCard = medicalCard;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getBegood() {
        return begood;
    }

    public void setBegood(String begood) {
        this.begood = begood;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getInPost() {
        return inPost;
    }

    public void setInPost(String inPost) {
        this.inPost = inPost;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public DoctorRequest() {
    }

}
