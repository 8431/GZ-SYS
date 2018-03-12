package com.gzsys.modules.yun.response;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class RegisterUserReqeust {
	 
	//@Pattern(regexp = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))[0-9]{8}$", message = "手机号格式错误")
	private String identifier;// 手机号

	@Length(min = 6, max = 20, message = "密码长度只能在6-20之间")
	private String certificate;// 密码

	@NotNull(message = "姓名不能为空")
	@Length(min = 2, max = 10, message = "用户名长度必须位于2到10之间")
	private String userName;// 用户名

	@NotNull(message = "身份证不能为空")
	//@Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
	private String idCard;// 身份证号

	@Length(min = 0, max = 18, message = "医保卡长度最大为18位")
	private String medicalCard;// 医保卡号

	@Length(min = 0, max = 10, message = "推荐码长度最大为10位")
	private String referralCode;// 推荐号

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

}
