package com.gzsys.common.util;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRoleEnum implements IEnum {
    ONE(1, "正常用户"),
    TWO(2, "禁言用户"),
	THREE(3, "虚拟用户"),
	FOUR(4, "运营用户");
	
    private int value;
    private String desc;

    UserRoleEnum(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }

    @JsonValue
    public String getDesc(){
        return this.desc;
    }

}
