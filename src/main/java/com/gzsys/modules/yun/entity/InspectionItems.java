/*
* Copyright(C) 2017-2020 贯众健康公司
* @date 2017-12-02
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
 * @Title InspectionItems表的实体类
 * @Description 病历中的-检查项目
 * @version 1.0
 * @Author fendo
 * @Date 2017年12月22日 16时28分09秒 星期五 
 */
@TableName("INSPECTIONITEMS")
@ApiModel(value="InspectionItems对象",description="病历中的-检查项目")
public class InspectionItems extends Model<InspectionItems> {


    private static final long serialVersionUID = 1L;
 
    /**
    *  主键
    */
    @TableId(value="ID")
    @ApiModelProperty(hidden=true)
    private String id;
    /**
    *  项目名
    */
    @ApiModelProperty(value = "项目名")
    private String projectname;
    /**
    *  备注
    */
    @ApiModelProperty(value = "备注")
    private String remarks;
    /**
    *  删除标志位
    */
    @ApiModelProperty(value = "删除标志位")
    private String state;
    /**
    *  创建时间
    */
    @ApiModelProperty(value = "创建时间")
    private Date createdate;
    /**
    *  创建人
    */
    @ApiModelProperty(value = "创建人")
    private String createname;
    /**
    *  更新时间
    */
    @ApiModelProperty(value = "更新时间")
    private Date updatedate;
    /**
    *  更新人
    */
    @ApiModelProperty(value = "更新人")
    private String updatename;
    /**
    *  病历ID
    */
    @ApiModelProperty(value = "病历ID")
    private String sickblhdrid;
     
    public InspectionItems(){
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId(){    
      return this.id;    
    }

    public void setId(String id){    
      this.id = id;    
    }    
    public String getProjectname(){    
      return this.projectname;    
    }

    public void setProjectname(String projectname){    
      this.projectname = projectname;    
    }    
    public String getRemarks(){    
      return this.remarks;    
    }

    public void setRemarks(String remarks){    
      this.remarks = remarks;    
    }    
    public String getState(){    
      return this.state;    
    }

    public void setState(String state){    
      this.state = state;    
    }    
    public Date getCreatedate(){    
      return this.createdate;    
    }

    public void setCreatedate(Date createdate){    
      this.createdate = createdate;    
    }    
    public String getCreatename(){    
      return this.createname;    
    }

    public void setCreatename(String createname){    
      this.createname = createname;    
    }    
    public Date getUpdatedate(){    
      return this.updatedate;    
    }

    public void setUpdatedate(Date updatedate){    
      this.updatedate = updatedate;    
    }    
    public String getUpdatename(){    
      return this.updatename;    
    }

    public void setUpdatename(String updatename){    
      this.updatename = updatename;    
    }    
    public String getSickblhdrid(){    
      return this.sickblhdrid;    
    }

    public void setSickblhdrid(String sickblhdrid){    
      this.sickblhdrid = sickblhdrid;    
    }    
  
      
}  