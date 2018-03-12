/*
* ChisChartMsg.java
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
 * @Title CHIS_CHARTMSG表的实体类
 * @Description null
 * @version 1.0
 * @Author fendo
 * @Date 2018-01-31 20:56:10
 */
@TableName("CHIS_CHARTMSG")
@ApiModel(value="ChisChartMsg对象",description="ChisChartMsg")
public class ChisChartMsg extends Model<ChisChartMsg> {


    /**
     * @Fields guid 唯一编码
     */
    @TableId(value="GUID")
    @ApiModelProperty(hidden=true)
    private String guid;

    /**
     * @Fields org 组织
     */
    @ApiModelProperty(value = "组织")
    private String org;

    /**
     * @Fields usrid 发送人guid
     */
    @ApiModelProperty(value = "发送人guid")
    private String usrid;

    /**
     * @Fields usrnam 发送人name
     */
    @ApiModelProperty(value = "发送人name")
    private String usrnam;

    /**
     * @Fields crtdat 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date crtdat;

    /**
     * @Fields tousr 接收人id
     */
    @ApiModelProperty(value = "接收人id")
    private String tousr;

    /**
     * @Fields toname 接收人name
     */
    @ApiModelProperty(value = "接收人name")
    private String toname;

    /**
     * @Fields type 类型
     */
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * @Fields flg 标志
     */
    @ApiModelProperty(value = "标志")
    private String flg;

    /**
     * @Fields msg 内容
     */
    @ApiModelProperty(value = "内容")
    private Object msg;

    /**
     * @Fields usrimg 发送人头像
     */
    @ApiModelProperty(value = "发送人头像")
    private String usrimg;

    /**
     * @Fields imgfile 图片文件
     */
    @ApiModelProperty(value = "图片文件")
    private String imgfile;

    /**
     * @Fields audiofile 语音文件
     */
    @ApiModelProperty(value = "语音文件")
    private String audiofile;


    /**
     * 获取 唯一编码 字段:CHIS_CHARTMSG.GUID
     *
     * @return CHIS_CHARTMSG.GUID, 唯一编码
     */
    public String getGuid() {
        return guid;
    }

    /**
     * 设置 唯一编码 字段:CHIS_CHARTMSG.GUID
     *
     * @param guid the value for CHIS_CHARTMSG.GUID, 唯一编码
     */
    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    /**
     * 获取 组织 字段:CHIS_CHARTMSG.ORG
     *
     * @return CHIS_CHARTMSG.ORG, 组织
     */
    public String getOrg() {
        return org;
    }

    /**
     * 设置 组织 字段:CHIS_CHARTMSG.ORG
     *
     * @param org the value for CHIS_CHARTMSG.ORG, 组织
     */
    public void setOrg(String org) {
        this.org = org == null ? null : org.trim();
    }

    /**
     * 获取 发送人guid 字段:CHIS_CHARTMSG.USRID
     *
     * @return CHIS_CHARTMSG.USRID, 发送人guid
     */
    public String getUsrid() {
        return usrid;
    }

    /**
     * 设置 发送人guid 字段:CHIS_CHARTMSG.USRID
     *
     * @param usrid the value for CHIS_CHARTMSG.USRID, 发送人guid
     */
    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    /**
     * 获取 发送人name 字段:CHIS_CHARTMSG.USRNAM
     *
     * @return CHIS_CHARTMSG.USRNAM, 发送人name
     */
    public String getUsrnam() {
        return usrnam;
    }

    /**
     * 设置 发送人name 字段:CHIS_CHARTMSG.USRNAM
     *
     * @param usrnam the value for CHIS_CHARTMSG.USRNAM, 发送人name
     */
    public void setUsrnam(String usrnam) {
        this.usrnam = usrnam == null ? null : usrnam.trim();
    }

    /**
     * 获取 创建时间 字段:CHIS_CHARTMSG.CRTDAT
     *
     * @return CHIS_CHARTMSG.CRTDAT, 创建时间
     */
    public Date getCrtdat() {
        return crtdat;
    }

    /**
     * 设置 创建时间 字段:CHIS_CHARTMSG.CRTDAT
     *
     * @param crtdat the value for CHIS_CHARTMSG.CRTDAT, 创建时间
     */
    public void setCrtdat(Date crtdat) {
        this.crtdat = crtdat;
    }

    /**
     * 获取 接收人id 字段:CHIS_CHARTMSG.TOUSR
     *
     * @return CHIS_CHARTMSG.TOUSR, 接收人id
     */
    public String getTousr() {
        return tousr;
    }

    /**
     * 设置 接收人id 字段:CHIS_CHARTMSG.TOUSR
     *
     * @param tousr the value for CHIS_CHARTMSG.TOUSR, 接收人id
     */
    public void setTousr(String tousr) {
        this.tousr = tousr == null ? null : tousr.trim();
    }

    /**
     * 获取 接收人name 字段:CHIS_CHARTMSG.TONAME
     *
     * @return CHIS_CHARTMSG.TONAME, 接收人name
     */
    public String getToname() {
        return toname;
    }

    /**
     * 设置 接收人name 字段:CHIS_CHARTMSG.TONAME
     *
     * @param toname the value for CHIS_CHARTMSG.TONAME, 接收人name
     */
    public void setToname(String toname) {
        this.toname = toname == null ? null : toname.trim();
    }

    /**
     * 获取 类型 字段:CHIS_CHARTMSG.TYPE
     *
     * @return CHIS_CHARTMSG.TYPE, 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 类型 字段:CHIS_CHARTMSG.TYPE
     *
     * @param type the value for CHIS_CHARTMSG.TYPE, 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取 标志 字段:CHIS_CHARTMSG.FLG
     *
     * @return CHIS_CHARTMSG.FLG, 标志
     */
    public String getFlg() {
        return flg;
    }

    /**
     * 设置 标志 字段:CHIS_CHARTMSG.FLG
     *
     * @param flg the value for CHIS_CHARTMSG.FLG, 标志
     */
    public void setFlg(String flg) {
        this.flg = flg == null ? null : flg.trim();
    }

    /**
     * 获取 内容 字段:CHIS_CHARTMSG.MSG
     *
     * @return CHIS_CHARTMSG.MSG, 内容
     */
    public Object getMsg() {
        return msg;
    }

    /**
     * 设置 内容 字段:CHIS_CHARTMSG.MSG
     *
     * @param msg the value for CHIS_CHARTMSG.MSG, 内容
     */
    public void setMsg(Object msg) {
        this.msg = msg;
    }

    /**
     * 获取 发送人头像 字段:CHIS_CHARTMSG.USRIMG
     *
     * @return CHIS_CHARTMSG.USRIMG, 发送人头像
     */
    public String getUsrimg() {
        return usrimg;
    }

    /**
     * 设置 发送人头像 字段:CHIS_CHARTMSG.USRIMG
     *
     * @param usrimg the value for CHIS_CHARTMSG.USRIMG, 发送人头像
     */
    public void setUsrimg(String usrimg) {
        this.usrimg = usrimg == null ? null : usrimg.trim();
    }

    /**
     * 获取 图片文件 字段:CHIS_CHARTMSG.IMGFILE
     *
     * @return CHIS_CHARTMSG.IMGFILE, 图片文件
     */
    public String getImgfile() {
        return imgfile;
    }

    /**
     * 设置 图片文件 字段:CHIS_CHARTMSG.IMGFILE
     *
     * @param imgfile the value for CHIS_CHARTMSG.IMGFILE, 图片文件
     */
    public void setImgfile(String imgfile) {
        this.imgfile = imgfile == null ? null : imgfile.trim();
    }

    /**
     * 获取 语音文件 字段:CHIS_CHARTMSG.AUDIOFILE
     *
     * @return CHIS_CHARTMSG.AUDIOFILE, 语音文件
     */
    public String getAudiofile() {
        return audiofile;
    }

    /**
     * 设置 语音文件 字段:CHIS_CHARTMSG.AUDIOFILE
     *
     * @param audiofile the value for CHIS_CHARTMSG.AUDIOFILE, 语音文件
     */
    public void setAudiofile(String audiofile) {
        this.audiofile = audiofile == null ? null : audiofile.trim();
    }

    /**
     * :CHIS_CHARTMSG
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", guid=").append(guid);
        sb.append(", org=").append(org);
        sb.append(", usrid=").append(usrid);
        sb.append(", usrnam=").append(usrnam);
        sb.append(", crtdat=").append(crtdat);
        sb.append(", tousr=").append(tousr);
        sb.append(", toname=").append(toname);
        sb.append(", type=").append(type);
        sb.append(", flg=").append(flg);
        sb.append(", msg=").append(msg);
        sb.append(", usrimg=").append(usrimg);
        sb.append(", imgfile=").append(imgfile);
        sb.append(", audiofile=").append(audiofile);
        sb.append("]");
        return sb.toString();
    }

    /**
     * :CHIS_CHARTMSG
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
        ChisChartMsg other = (ChisChartMsg) that;
        return (this.getGuid() == null ? other.getGuid() == null : this.getGuid().equals(other.getGuid()))
            && (this.getOrg() == null ? other.getOrg() == null : this.getOrg().equals(other.getOrg()))
            && (this.getUsrid() == null ? other.getUsrid() == null : this.getUsrid().equals(other.getUsrid()))
            && (this.getUsrnam() == null ? other.getUsrnam() == null : this.getUsrnam().equals(other.getUsrnam()))
            && (this.getCrtdat() == null ? other.getCrtdat() == null : this.getCrtdat().equals(other.getCrtdat()))
            && (this.getTousr() == null ? other.getTousr() == null : this.getTousr().equals(other.getTousr()))
            && (this.getToname() == null ? other.getToname() == null : this.getToname().equals(other.getToname()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFlg() == null ? other.getFlg() == null : this.getFlg().equals(other.getFlg()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getUsrimg() == null ? other.getUsrimg() == null : this.getUsrimg().equals(other.getUsrimg()))
            && (this.getImgfile() == null ? other.getImgfile() == null : this.getImgfile().equals(other.getImgfile()))
            && (this.getAudiofile() == null ? other.getAudiofile() == null : this.getAudiofile().equals(other.getAudiofile()));
    }

    /**
     * :CHIS_CHARTMSG
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGuid() == null) ? 0 : getGuid().hashCode());
        result = prime * result + ((getOrg() == null) ? 0 : getOrg().hashCode());
        result = prime * result + ((getUsrid() == null) ? 0 : getUsrid().hashCode());
        result = prime * result + ((getUsrnam() == null) ? 0 : getUsrnam().hashCode());
        result = prime * result + ((getCrtdat() == null) ? 0 : getCrtdat().hashCode());
        result = prime * result + ((getTousr() == null) ? 0 : getTousr().hashCode());
        result = prime * result + ((getToname() == null) ? 0 : getToname().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFlg() == null) ? 0 : getFlg().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getUsrimg() == null) ? 0 : getUsrimg().hashCode());
        result = prime * result + ((getImgfile() == null) ? 0 : getImgfile().hashCode());
        result = prime * result + ((getAudiofile() == null) ? 0 : getAudiofile().hashCode());
        return result;
    }

    @Override
    protected Serializable pkVal() {
        return this.guid;
    }
}