package com.me.model.enums.common;

import com.me.model.enums.DictEnum;

public enum CommonEnum implements DictEnum {

	加密属性文件的密钥("wbaobei","加密属性文件的密钥");
	
	private String code;

    private String desc;

    private CommonEnum(String code , String desc) {
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
