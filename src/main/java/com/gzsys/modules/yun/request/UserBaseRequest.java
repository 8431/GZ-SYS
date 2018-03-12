package com.gzsys.modules.yun.request;

import io.swagger.annotations.ApiModelProperty;


public class UserBaseRequest {

	@ApiModelProperty(hidden=true)
	private String id;
	@ApiModelProperty(value = "职称code")
	private String title;
	@ApiModelProperty(value = "科室code")
	private String department;
	@ApiModelProperty(value = "在线状态 0不在线1在线2离开")
	private String inPost;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getInPost() {
		return inPost;
	}
	public void setInPost(String inPost) {
		this.inPost = inPost;
	}
	
}
