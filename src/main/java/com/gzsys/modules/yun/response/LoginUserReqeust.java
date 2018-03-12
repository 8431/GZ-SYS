package com.gzsys.modules.yun.response;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User(用户模型)")
public class LoginUserReqeust implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="手机号",name="identifier",example="18900000001")
	//@Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号格式不正确")
	private String identifier;// 手机号
    @ApiModelProperty(value="密码",name="certificate",example="123456")
	@Length(min = 6, max = 20, message = "密码长度只能在6-20之间")
	private String certificate;// 密码

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

	@Override
	public String toString() {
		return "LoginUserReqeust [identifier=" + identifier + ", certificate=" + certificate + ", getIdentifier()="
				+ getIdentifier() + ", getCertificate()=" + getCertificate() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
