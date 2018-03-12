/*
* HealtDictType.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title HEALTH_DICT_TYPE表的实体类
 * @Description 字典类型表
 * @version 1.0
 * @Author fendo
 * @Date 2018-01-31 20:56:10
 */
@TableName("HEALTH_DICT_TYPE")
@ApiModel(value="HealtDictType对象",description="字典类型表")
public class HealtDictType extends Model<HealtDictType> {
    /**
     * @Fields id 字典类型编号
     */
    @ApiModelProperty(hidden=true)
    private String id;

    /**
     * @Fields parentId 字典类型父级编号
     */
    @ApiModelProperty(value = "字典类型父级编号")
    private String parentId;

    /**
     * @Fields appId 应用编号
     */
    @ApiModelProperty(value = "应用编号")
    private String appId;

    /**
     * @Fields dictTypeName 字典类型名称
     */
    @ApiModelProperty(value = "字典类型名称")
    private String dictTypeName;

    /**
     * @Fields dictTypeRank 层级
     */
    @ApiModelProperty(value = "层级")
    private Long dictTypeRank;

    /**
     * @Fields dictTypeCode 字典编码
     */
    @ApiModelProperty(value = "字典编码")
    private String dictTypeCode;

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
     * @Fields dictTypeSortNo 字典类型排序码
     */
    @ApiModelProperty(value = "字典类型排序码")
    private BigDecimal dictTypeSortNo;


    /**
     * 获取 字典类型编号 字段:HEALTH_DICT_TYPE.ID
     *
     * @return HEALTH_DICT_TYPE.ID, 字典类型编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 字典类型编号 字段:HEALTH_DICT_TYPE.ID
     *
     * @param id the value for HEALTH_DICT_TYPE.ID, 字典类型编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 字典类型父级编号 字段:HEALTH_DICT_TYPE.PARENT_ID
     *
     * @return HEALTH_DICT_TYPE.PARENT_ID, 字典类型父级编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置 字典类型父级编号 字段:HEALTH_DICT_TYPE.PARENT_ID
     *
     * @param parentId the value for HEALTH_DICT_TYPE.PARENT_ID, 字典类型父级编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * 获取 应用编号 字段:HEALTH_DICT_TYPE.APP_ID
     *
     * @return HEALTH_DICT_TYPE.APP_ID, 应用编号
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置 应用编号 字段:HEALTH_DICT_TYPE.APP_ID
     *
     * @param appId the value for HEALTH_DICT_TYPE.APP_ID, 应用编号
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 获取 字典类型名称 字段:HEALTH_DICT_TYPE.DICT_TYPE_NAME
     *
     * @return HEALTH_DICT_TYPE.DICT_TYPE_NAME, 字典类型名称
     */
    public String getDictTypeName() {
        return dictTypeName;
    }

    /**
     * 设置 字典类型名称 字段:HEALTH_DICT_TYPE.DICT_TYPE_NAME
     *
     * @param dictTypeName the value for HEALTH_DICT_TYPE.DICT_TYPE_NAME, 字典类型名称
     */
    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName == null ? null : dictTypeName.trim();
    }

    /**
     * 获取 层级 字段:HEALTH_DICT_TYPE.DICT_TYPE_RANK
     *
     * @return HEALTH_DICT_TYPE.DICT_TYPE_RANK, 层级
     */
    public Long getDictTypeRank() {
        return dictTypeRank;
    }

    /**
     * 设置 层级 字段:HEALTH_DICT_TYPE.DICT_TYPE_RANK
     *
     * @param dictTypeRank the value for HEALTH_DICT_TYPE.DICT_TYPE_RANK, 层级
     */
    public void setDictTypeRank(Long dictTypeRank) {
        this.dictTypeRank = dictTypeRank;
    }

    /**
     * 获取 字典编码 字段:HEALTH_DICT_TYPE.DICT_TYPE_CODE
     *
     * @return HEALTH_DICT_TYPE.DICT_TYPE_CODE, 字典编码
     */
    public String getDictTypeCode() {
        return dictTypeCode;
    }

    /**
     * 设置 字典编码 字段:HEALTH_DICT_TYPE.DICT_TYPE_CODE
     *
     * @param dictTypeCode the value for HEALTH_DICT_TYPE.DICT_TYPE_CODE, 字典编码
     */
    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode == null ? null : dictTypeCode.trim();
    }

    /**
     * 获取 创建时间 字段:HEALTH_DICT_TYPE.CREATE_TIME
     *
     * @return HEALTH_DICT_TYPE.CREATE_TIME, 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置 创建时间 字段:HEALTH_DICT_TYPE.CREATE_TIME
     *
     * @param createTime the value for HEALTH_DICT_TYPE.CREATE_TIME, 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取 创建名称 字段:HEALTH_DICT_TYPE.CREATE_NAME
     *
     * @return HEALTH_DICT_TYPE.CREATE_NAME, 创建名称
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * 设置 创建名称 字段:HEALTH_DICT_TYPE.CREATE_NAME
     *
     * @param createName the value for HEALTH_DICT_TYPE.CREATE_NAME, 创建名称
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * 获取 更新时间 字段:HEALTH_DICT_TYPE.UPDATE_TIME
     *
     * @return HEALTH_DICT_TYPE.UPDATE_TIME, 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置 更新时间 字段:HEALTH_DICT_TYPE.UPDATE_TIME
     *
     * @param updateTime the value for HEALTH_DICT_TYPE.UPDATE_TIME, 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取 更新名称 字段:HEALTH_DICT_TYPE.UPDATE_NAME
     *
     * @return HEALTH_DICT_TYPE.UPDATE_NAME, 更新名称
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * 设置 更新名称 字段:HEALTH_DICT_TYPE.UPDATE_NAME
     *
     * @param updateName the value for HEALTH_DICT_TYPE.UPDATE_NAME, 更新名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * 获取 删除标记位 0已删除 1未删除 字段:HEALTH_DICT_TYPE.STATE
     *
     * @return HEALTH_DICT_TYPE.STATE, 删除标记位 0已删除 1未删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置 删除标记位 0已删除 1未删除 字段:HEALTH_DICT_TYPE.STATE
     *
     * @param state the value for HEALTH_DICT_TYPE.STATE, 删除标记位 0已删除 1未删除
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 获取 字典类型排序码 字段:HEALTH_DICT_TYPE.DICT_TYPE_SORT_NO
     *
     * @return HEALTH_DICT_TYPE.DICT_TYPE_SORT_NO, 字典类型排序码
     */
    public BigDecimal getDictTypeSortNo() {
        return dictTypeSortNo;
    }

    /**
     * 设置 字典类型排序码 字段:HEALTH_DICT_TYPE.DICT_TYPE_SORT_NO
     *
     * @param dictTypeSortNo the value for HEALTH_DICT_TYPE.DICT_TYPE_SORT_NO, 字典类型排序码
     */
    public void setDictTypeSortNo(BigDecimal dictTypeSortNo) {
        this.dictTypeSortNo = dictTypeSortNo;
    }

    /**
     * :HEALTH_DICT_TYPE
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", appId=").append(appId);
        sb.append(", dictTypeName=").append(dictTypeName);
        sb.append(", dictTypeRank=").append(dictTypeRank);
        sb.append(", dictTypeCode=").append(dictTypeCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", createName=").append(createName);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateName=").append(updateName);
        sb.append(", state=").append(state);
        sb.append(", dictTypeSortNo=").append(dictTypeSortNo);
        sb.append("]");
        return sb.toString();
    }

    /**
     * :HEALTH_DICT_TYPE
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
        HealtDictType other = (HealtDictType) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getDictTypeName() == null ? other.getDictTypeName() == null : this.getDictTypeName().equals(other.getDictTypeName()))
            && (this.getDictTypeRank() == null ? other.getDictTypeRank() == null : this.getDictTypeRank().equals(other.getDictTypeRank()))
            && (this.getDictTypeCode() == null ? other.getDictTypeCode() == null : this.getDictTypeCode().equals(other.getDictTypeCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateName() == null ? other.getCreateName() == null : this.getCreateName().equals(other.getCreateName()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getUpdateName() == null ? other.getUpdateName() == null : this.getUpdateName().equals(other.getUpdateName()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDictTypeSortNo() == null ? other.getDictTypeSortNo() == null : this.getDictTypeSortNo().equals(other.getDictTypeSortNo()));
    }

    /**
     * :HEALTH_DICT_TYPE
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getDictTypeName() == null) ? 0 : getDictTypeName().hashCode());
        result = prime * result + ((getDictTypeRank() == null) ? 0 : getDictTypeRank().hashCode());
        result = prime * result + ((getDictTypeCode() == null) ? 0 : getDictTypeCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateName() == null) ? 0 : getCreateName().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getUpdateName() == null) ? 0 : getUpdateName().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDictTypeSortNo() == null) ? 0 : getDictTypeSortNo().hashCode());
        return result;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}