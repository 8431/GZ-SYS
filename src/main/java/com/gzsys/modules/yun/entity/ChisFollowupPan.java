/**
 * projectName: GZ
 * fileName: ChisFollowupPan.java
 * packageName: com.gzsys.modules.yun.entity
 * date: 2018-02-01 14:50
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ChisFollowupPan
 * @packageName: com.gzsys.modules.yun.entity
 * @description: 随访计划
 * @data: 2018-02-01 14:50
 **/
@TableName("CHIS_FOLLOWUP_PLAN")
@ApiModel(value="ChisFollowupPan对象",description="随访计划")
public class ChisFollowupPan extends Model<ChisFollowupPan> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(hidden=true)
    @TableId(value="GUID")
    private String guid;
    @ApiModelProperty(value = "系统编号")
    private String org;
    @ApiModelProperty(value = "医生guid")
    private String docguid;
    @ApiModelProperty(value = "患者guid")
    private String usrguid;
    @ApiModelProperty(value = "病例guid")
    private String sicguid;
    @ApiModelProperty(value = "随访项目")
    private String followoption;
    @ApiModelProperty(value = "随访时间")
    private Date followdatetime;
    @ApiModelProperty(value = "随访时间")
    private String followtime;
    @ApiModelProperty(value = "随访状态")
    private String followstate;
    @ApiModelProperty(value = "创建人")
    private String crtusr;
    @ApiModelProperty(value = "创建时间")
    private Date crtdat;
    @ApiModelProperty(value = "更新人")
    private String updateusr;
    @ApiModelProperty(value = "更新时间")
    private Date updatedate;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
    private String status;

    public String getFollowtime() {
        return followtime;
    }

    public void setFollowtime(String followtime) {
        this.followtime = followtime;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    public String getDocguid() {
        return docguid;
    }

    public void setDocguid(String docguid) {
        this.docguid = docguid == null ? null : docguid.trim();
    }

    public String getUsrguid() {
        return usrguid;
    }

    public void setUsrguid(String usrguid) {
        this.usrguid = usrguid == null ? null : usrguid.trim();
    }

    public String getSicguid() {
        return sicguid;
    }

    public void setSicguid(String sicguid) {
        this.sicguid = sicguid == null ? null : sicguid.trim();
    }

    public String getFollowoption() {
        return followoption;
    }

    public void setFollowoption(String followoption) {
        this.followoption = followoption == null ? null : followoption.trim();
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getFollowdatetime() {
        return followdatetime;
    }

    public void setFollowdatetime(Date followdatetime) {
        this.followdatetime = followdatetime;
    }

    public String getFollowstate() {
        return followstate;
    }

    public void setFollowstate(String followstate) {
        this.followstate = followstate == null ? null : followstate.trim();
    }

    public String getCrtusr() {
        return crtusr;
    }

    public void setCrtusr(String crtusr) {
        this.crtusr = crtusr == null ? null : crtusr.trim();
    }

    public Date getCrtdat() {
        return crtdat;
    }

    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    public String getUpdateusr() {
        return updateusr;
    }

    public void setUpdateusr(String updateusr) {
        this.updateusr = updateusr == null ? null : updateusr.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.guid;
    }
}
