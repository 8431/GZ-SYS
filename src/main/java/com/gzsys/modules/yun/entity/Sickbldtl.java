/**
 * projectName: GZ
 * fileName: Sickbldtl.java
 * packageName: com.gzsys.modules.yun.entity
 * date: 2018-02-01 15:09
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version: V1.0
 * @author: fendo
 * @className: Sickbldtl
 * @packageName: com.gzsys.modules.yun.entity
 * @description: 用药方案
 * @data: 2018-02-01 15:09
 **/
@TableName("SICKBLDTL")
@ApiModel(value="Sickbldtl对象",description="用药方案")
public class Sickbldtl extends Model<Sickbldtl> {

    @TableId(value="GUID")
    @ApiModelProperty(hidden=true)
    private String guid;

    @ApiModelProperty(value = "明细顺序号")
    private BigDecimal seqid;

    @ApiModelProperty(value = "参考头信息唯一编号")
    private String formguid;

    @ApiModelProperty(value = "药品编号")
    private String druid;

    @ApiModelProperty(value = "药品名称")
    private String drunam;

    @ApiModelProperty(value = "规格")
    private String unit;

    @ApiModelProperty(value = "数量")
    private Integer ypnum;

    @ApiModelProperty(value = "次")
    private String ci;

    @ApiModelProperty(value = "剂量")
    private String pian;

    @ApiModelProperty(value = "天")
    private String day;

    @ApiModelProperty(value = "数量单位")
    private String numnit;

    @ApiModelProperty(value = "服用方式名称")
    private String kfwy;

    @ApiModelProperty(value = "频次")
    private String pc;

    @ApiModelProperty(value = "频次名称")
    private String pcname;

    @ApiModelProperty(value = "服用方式名称")
    private String kfwyname;

    @ApiModelProperty(value = "小剂量单位")
    private String smlunt;

    @ApiModelProperty(value = "零售价")
    private BigDecimal stPrice;

    @ApiModelProperty(value = "是否有库存1有0无")
    private String stQty;

    /**
     * 删除标志位 1未删除 0已删除
     */
    private String state;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public BigDecimal getSeqid() {
        return seqid;
    }

    public void setSeqid(BigDecimal seqid) {
        this.seqid = seqid;
    }

    public String getFormguid() {
        return formguid;
    }

    public void setFormguid(String formguid) {
        this.formguid = formguid == null ? null : formguid.trim();
    }

    public String getDruid() {
        return druid;
    }

    public void setDruid(String druid) {
        this.druid = druid == null ? null : druid.trim();
    }

    public String getDrunam() {
        return drunam;
    }

    public void setDrunam(String drunam) {
        this.drunam = drunam == null ? null : drunam.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Integer getYpnum() {
        return ypnum;
    }

    public void setYpnum(Integer ypnum) {
        this.ypnum = ypnum;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci == null ? null : ci.trim();
    }

    public String getPian() {
        return pian;
    }

    public void setPian(String pian) {
        this.pian = pian == null ? null : pian.trim();
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
    }

    public String getNumnit() {
        return numnit;
    }

    public void setNumnit(String numnit) {
        this.numnit = numnit == null ? null : numnit.trim();
    }

    public String getKfwy() {
        return kfwy;
    }

    public void setKfwy(String kfwy) {
        this.kfwy = kfwy == null ? null : kfwy.trim();
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc == null ? null : pc.trim();
    }

    public String getPcname() {
        return pcname;
    }

    public void setPcname(String pcname) {
        this.pcname = pcname == null ? null : pcname.trim();
    }

    public String getKfwyname() {
        return kfwyname;
    }

    public void setKfwyname(String kfwyname) {
        this.kfwyname = kfwyname == null ? null : kfwyname.trim();
    }

    public String getSmlunt() {
        return smlunt;
    }

    public void setSmlunt(String smlunt) {
        this.smlunt = smlunt == null ? null : smlunt.trim();
    }

    public BigDecimal getStPrice() {
        return stPrice;
    }

    public void setStPrice(BigDecimal stPrice) {
        this.stPrice = stPrice;
    }

    public String getStQty() {
        return stQty;
    }

    public void setStQty(String stQty) {
        this.stQty = stQty == null ? null : stQty.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.guid;
    }
}
