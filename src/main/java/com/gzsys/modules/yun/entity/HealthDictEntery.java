/*
* HealthDictEntery.java
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
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title HEALTH_DICT_ENTRY表的实体类
 * @Description 字典键值信息表
 * @version 1.0
 * @Author fendo
 * @Date 2018-01-31 20:56:10
 */
@TableName("HEALTH_DICT_ENTRY")
@ApiModel(value="HealthDictEntery对象",description="字典键值信息表")
public class HealthDictEntery  extends Model<HealthDictEntery> {

    /**
     * @Fields id 字典项编号
     */
    @ApiModelProperty(hidden=true)
    @TableId(value="ID")
    private String id;

    /**
     * @Fields appId 应用编号
     */
    @TableId(value="APP_ID")
    @ApiModelProperty(value = "应用编号")
    private String appId;

    /**
     * @Fields dictTypeId 字典类型编号
     */
    @TableId(value="DICT_TYPE_ID")
    @ApiModelProperty(value = "字典类型编号")
    private String dictTypeId;

    /**
     * @Fields dictEntryCode 键值代码，手工输入或依据父类指定4-8位流水号
     */
    @TableId(value="DICT_ENTRY_CODE")
    @ApiModelProperty(value = "键值代码，手工输入或依据父类指定4-8位流水号")
    private String dictEntryCode;

    /**
     * @Fields dictEntryName 字典项名称
     */
    @TableId(value="DICT_ENTRY_NAME")
    @ApiModelProperty(value = "字典项名称")
    private String dictEntryName;

    /**
     * @Fields dictEntryRank 层级
     */
    @TableId(value="DICT_ENTRY_RANK")
    @ApiModelProperty(value = "层级")
    private String dictEntryRank;

    /**
     * @Fields dictEntryValue 键值值域
     */
    @TableId(value="DICT_ENTRY_VALUE")
    @ApiModelProperty(value = "键值值域")
    private String dictEntryValue;

    /**
     * @Fields createTime 创建时间
     */
    @TableId(value="CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * @Fields createName 创建名称
     */
    @TableId(value="CREATE_NAME")
    @ApiModelProperty(value = "创建名称")
    private String createName;

    /**
     * @Fields updateTime 更新时间
     */
    @TableId(value="UPDATE_TIME")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * @Fields updateName 更新名称
     */
    @TableId(value="UPDATE_NAME")
    @ApiModelProperty(value = "更新名称")
    private String updateName;

    /**
     * @Fields state 删除标记位 0已删除 1未删除
     */
    @ApiModelProperty(value = "删除标记位")
    private String state;

    /**
     * @Fields dictEntrySortNo 排序字段
     */
    @TableId(value="DICT_ENTRY_SORT_NO")
    @ApiModelProperty(value = "排序字段")
    private BigDecimal dictEntrySortNo;


    /**
     * 获取 字典项编号 字段:HEALTH_DICT_ENTRY.ID
     *
     * @return HEALTH_DICT_ENTRY.ID, 字典项编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 字典项编号 字段:HEALTH_DICT_ENTRY.ID
     *
     * @param id the value for HEALTH_DICT_ENTRY.ID, 字典项编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 应用编号 字段:HEALTH_DICT_ENTRY.APP_ID
     *
     * @return HEALTH_DICT_ENTRY.APP_ID, 应用编号
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 应用编号 字段:HEALTH_DICT_ENTRY.APP_ID
     *
     * @param appId the value for HEALTH_DICT_ENTRY.APP_ID, 应用编号
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取 字典类型编号 字段:HEALTH_DICT_ENTRY.DICT_TYPE_ID
     *
     * @return HEALTH_DICT_ENTRY.DICT_TYPE_ID, 字典类型编号
     */
    public String getDictTypeId() {
        return dictTypeId;
    }

    /**
     * 设置 字典类型编号 字段:HEALTH_DICT_ENTRY.DICT_TYPE_ID
     *
     * @param dictTypeId the value for HEALTH_DICT_ENTRY.DICT_TYPE_ID, 字典类型编号
     */
    public void setDictTypeId(String dictTypeId) {
        this.dictTypeId = dictTypeId == null ? null : dictTypeId.trim();
    }

    /**
     * 获取 键值代码，手工输入或依据父类指定4-8位流水号 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_CODE
     *
     * @return HEALTH_DICT_ENTRY.DICT_ENTRY_CODE, 键值代码，手工输入或依据父类指定4-8位流水号
     */
    public String getDictEntryCode() {
        return dictEntryCode;
    }

    /**
     * 设置 键值代码，手工输入或依据父类指定4-8位流水号 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_CODE
     *
     * @param dictEntryCode the value for HEALTH_DICT_ENTRY.DICT_ENTRY_CODE, 键值代码，手工输入或依据父类指定4-8位流水号
     */
    public void setDictEntryCode(String dictEntryCode) {
        this.dictEntryCode = dictEntryCode == null ? null : dictEntryCode.trim();
    }

    /**
     * 获取 字典项名称 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_NAME
     *
     * @return HEALTH_DICT_ENTRY.DICT_ENTRY_NAME, 字典项名称
     */
    public String getDictEntryName() {
        return dictEntryName;
    }

    /**
     * 设置 字典项名称 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_NAME
     *
     * @param dictEntryName the value for HEALTH_DICT_ENTRY.DICT_ENTRY_NAME, 字典项名称
     */
    public void setDictEntryName(String dictEntryName) {
        this.dictEntryName = dictEntryName == null ? null : dictEntryName.trim();
    }

    /**
     * 获取 层级 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_RANK
     *
     * @return HEALTH_DICT_ENTRY.DICT_ENTRY_RANK, 层级
     */
    public String getDictEntryRank() {
        return dictEntryRank;
    }

    /**
     * 设置 层级 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_RANK
     *
     * @param dictEntryRank the value for HEALTH_DICT_ENTRY.DICT_ENTRY_RANK, 层级
     */
    public void setDictEntryRank(String dictEntryRank) {
        this.dictEntryRank = dictEntryRank == null ? null : dictEntryRank.trim();
    }

    /**
     * 获取 键值值域 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_VALUE
     *
     * @return HEALTH_DICT_ENTRY.DICT_ENTRY_VALUE, 键值值域
     */
    public String getDictEntryValue() {
        return dictEntryValue;
    }

    /**
     * 设置 键值值域 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_VALUE
     *
     * @param dictEntryValue the value for HEALTH_DICT_ENTRY.DICT_ENTRY_VALUE, 键值值域
     */
    public void setDictEntryValue(String dictEntryValue) {
        this.dictEntryValue = dictEntryValue == null ? null : dictEntryValue.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTH_DICT_ENTRY.CREATE_TIME
     *
     * @return HEALTH_DICT_ENTRY.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:HEALTH_DICT_ENTRY.CREATE_TIME
     *
     * @param createTime the value for HEALTH_DICT_ENTRY.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建名称 字段:HEALTH_DICT_ENTRY.CREATE_NAME
     *
     * @return HEALTH_DICT_ENTRY.CREATE_NAME, 创建名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置 创建名称 字段:HEALTH_DICT_ENTRY.CREATE_NAME
     *
     * @param createName the value for HEALTH_DICT_ENTRY.CREATE_NAME, 创建名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取 更新时间 字段:HEALTH_DICT_ENTRY.UPDATE_TIME
     *
     * @return HEALTH_DICT_ENTRY.UPDATE_TIME, 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:HEALTH_DICT_ENTRY.UPDATE_TIME
     *
     * @param updateTime the value for HEALTH_DICT_ENTRY.UPDATE_TIME, 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新名称 字段:HEALTH_DICT_ENTRY.UPDATE_NAME
     *
     * @return HEALTH_DICT_ENTRY.UPDATE_NAME, 更新名称
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置 更新名称 字段:HEALTH_DICT_ENTRY.UPDATE_NAME
     *
     * @param updateName the value for HEALTH_DICT_ENTRY.UPDATE_NAME, 更新名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * 获取 删除标记位 0已删除 1未删除 字段:HEALTH_DICT_ENTRY.STATE
     *
     * @return HEALTH_DICT_ENTRY.STATE, 删除标记位 0已删除 1未删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标记位 0已删除 1未删除 字段:HEALTH_DICT_ENTRY.STATE
     *
     * @param state the value for HEALTH_DICT_ENTRY.STATE, 删除标记位 0已删除 1未删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 排序字段 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_SORT_NO
     *
     * @return HEALTH_DICT_ENTRY.DICT_ENTRY_SORT_NO, 排序字段
     */
    public BigDecimal getDictEntrySortNo() {
        return dictEntrySortNo;
    }

    /**
     * 设置 排序字段 字段:HEALTH_DICT_ENTRY.DICT_ENTRY_SORT_NO
     *
     * @param dictEntrySortNo the value for HEALTH_DICT_ENTRY.DICT_ENTRY_SORT_NO, 排序字段
     */
    public void setDictEntrySortNo(BigDecimal dictEntrySortNo) {
        this.dictEntrySortNo = dictEntrySortNo;
    }

    /**
     * :HEALTH_DICT_ENTRY
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", dictTypeId=").append(dictTypeId);
        sb.append(", dictEntryCode=").append(dictEntryCode);
        sb.append(", dictEntryName=").append(dictEntryName);
        sb.append(", dictEntryRank=").append(dictEntryRank);
        sb.append(", dictEntryValue=").append(dictEntryValue);
        sb.append(", createTime=").append(createTime);
        sb.append(", createName=").append(createName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateName=").append(updateName);
        sb.append(", state=").append(state);
        sb.append(", dictEntrySortNo=").append(dictEntrySortNo);
        sb.append("]");
        return sb.toString();
    }

    /**
     * :HEALTH_DICT_ENTRY
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
        HealthDictEntery other = (HealthDictEntery) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getDictTypeId() == null ? other.getDictTypeId() == null : this.getDictTypeId().equals(other.getDictTypeId()))
            && (this.getDictEntryCode() == null ? other.getDictEntryCode() == null : this.getDictEntryCode().equals(other.getDictEntryCode()))
            && (this.getDictEntryName() == null ? other.getDictEntryName() == null : this.getDictEntryName().equals(other.getDictEntryName()))
            && (this.getDictEntryRank() == null ? other.getDictEntryRank() == null : this.getDictEntryRank().equals(other.getDictEntryRank()))
            && (this.getDictEntryValue() == null ? other.getDictEntryValue() == null : this.getDictEntryValue().equals(other.getDictEntryValue()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDictEntrySortNo() == null ? other.getDictEntrySortNo() == null : this.getDictEntrySortNo().equals(other.getDictEntrySortNo()));
    }

    /**
     * :HEALTH_DICT_ENTRY
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getDictTypeId() == null) ? 0 : getDictTypeId().hashCode());
        result = prime * result + ((getDictEntryCode() == null) ? 0 : getDictEntryCode().hashCode());
        result = prime * result + ((getDictEntryName() == null) ? 0 : getDictEntryName().hashCode());
        result = prime * result + ((getDictEntryRank() == null) ? 0 : getDictEntryRank().hashCode());
        result = prime * result + ((getDictEntryValue() == null) ? 0 : getDictEntryValue().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDictEntrySortNo() == null) ? 0 : getDictEntrySortNo().hashCode());
        return result;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}