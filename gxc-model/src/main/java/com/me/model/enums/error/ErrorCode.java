package com.me.model.enums.error;

public enum ErrorCode {

	;
	  /**
     * 枚举类中的错误码
     */
    private String errorCode;
    /**
     * 枚举类中的错误信息
     */
    private String errorMsg;
    private ErrorCode(String errorCode , String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
}
