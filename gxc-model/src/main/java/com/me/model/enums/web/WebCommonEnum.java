package com.me.model.enums.web;

import com.me.model.enums.DictEnum;

public enum WebCommonEnum implements DictEnum {

	Session中的User("loginUser","Session中的User");
	
	private String code;

    private String desc;

    private WebCommonEnum(String code , String desc) {
        this.code = code;
        this.desc = desc;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }
}
