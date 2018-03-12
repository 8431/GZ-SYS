package com.gzsys.common.util;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserTypeEnum implements IEnum {
    ONE(1, "手机号"),
    TWO(2, "邮箱"),
	THREE(3, "用户名"),
	FOUR(4, "qq"),
	FIVE(5, "微信"),
	SIX(6, "腾讯微博"),
	SEVEN(7, "新浪微博");
	
    private int value;
    private String desc;

    UserTypeEnum(final int value, final String desc) {
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
