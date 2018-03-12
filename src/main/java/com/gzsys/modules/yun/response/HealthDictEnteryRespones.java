package com.gzsys.modules.yun.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.baomidou.mybatisplus.annotations.TableId;

@ApiModel(value="字典信息",description="字典信息")
public class HealthDictEnteryRespones {
	
	/**
     * @Fields id 字典项编号
     */
    @TableId(value="ID")
    @ApiModelProperty(hidden=true)
    private String id;

    /**
     * @Fields appId 应用编号
     */
    @ApiModelProperty(value = "应用编号")
    @TableId(value="APP_ID")
    private String appId;

    /**
     * @Fields dictTypeId 字典类型编号
     */
    @ApiModelProperty(value = "字典类型编号")
    @TableId(value="DICT_TYPE_ID")
    private String dictTypeId;

    /**
     * @Fields dictEntryCode 键值代码，手工输入或依据父类指定4-8位流水号
     */
    @ApiModelProperty(value = "键值代码（例：职称代码）")
    @TableId(value="DICT_ENTRY_CODE")
    private String dictEntryCode;

    /**
     * @Fields dictEntryName 字典项名称
     */
    @ApiModelProperty(value = "字典项名称（例：职称名称）")
    @TableId(value="DICT_ENTRY_NAME")
    private String dictEntryName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getDictTypeId() {
		return dictTypeId;
	}

	public void setDictTypeId(String dictTypeId) {
		this.dictTypeId = dictTypeId;
	}

	public String getDictEntryCode() {
		return dictEntryCode;
	}

	public void setDictEntryCode(String dictEntryCode) {
		this.dictEntryCode = dictEntryCode;
	}

	public String getDictEntryName() {
		return dictEntryName;
	}

	public void setDictEntryName(String dictEntryName) {
		this.dictEntryName = dictEntryName;
	}

}
