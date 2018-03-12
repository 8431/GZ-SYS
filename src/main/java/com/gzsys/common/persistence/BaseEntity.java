/**
 * projectName: GZ
 * fileName: BaseEntity.java
 * packageName: com.gzsys.common.base.entity
 * date: 2018-02-02 20:45
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.persistence;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: V1.0
 * @author: fendo
 * @className: BaseEntity
 * @packageName: com.gzsys.common.base.entity
 * @description: 实体类基类
 * @data: 2018-02-02 20:45
 **/
public class BaseEntity <T extends Model> extends Model<T> {

    /**
     *  主键
     */
    @TableId(value="ID")
    private String id;

    /**
     * @Fields createTime 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * @Fields createName 创建名称
     */
    @TableField("CREATE_NAME")
    private String createName;

    /**
     * @Fields updateTime 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * @Fields updateName 更新名称
     */
    @TableField("UPDATE_NAME")
    private String updateName;

    /**
     * @Fields state 删除标记位 0已删除 1未删除
     */
    private String state;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
