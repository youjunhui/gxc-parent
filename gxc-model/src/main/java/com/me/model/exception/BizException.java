package com.me.model.exception;

import com.me.model.enums.error.ErrorCode;

public class BizException extends RuntimeException {
	private static final long serialVersionUID = -1762310582543423572L;

	private static final String ERROR_CODE_DETAILS = "errorCode :";

	private static final String ERROR_MESSAGE_DETAILS = " errorMessage :";

	/**
	 * 错误枚举类
	 */
	private ErrorCode error;

	/**
	 * 错误信息
	 */
	private String errorMsg;

	public BizException() {
		super();
	}

	public BizException(ErrorCode error) {
		super(ERROR_CODE_DETAILS + error.getErrorCode() + ERROR_MESSAGE_DETAILS + error.getErrorMsg(), null);
		this.error = error;
	}

	public BizException(ErrorCode error, Throwable cause) {
		super(ERROR_CODE_DETAILS + error.getErrorCode() + ERROR_MESSAGE_DETAILS + error.getErrorMsg(), cause);
		this.error = error;
	}

	public BizException(ErrorCode error, String errorMsg) {
		super(ERROR_CODE_DETAILS + error.getErrorCode() + ERROR_MESSAGE_DETAILS + error.getErrorMsg(), null);
		this.error = error;
		this.errorMsg = errorMsg;
	}

	public ErrorCode getError() {
		return error;
	}

	public void setError(ErrorCode error) {
		this.error = error;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * 获取枚举类中错误信息码
	 * 
	 * @return
	 */
	public String getErrorCode() {
		return error.getErrorCode();
	}

	/**
	 * 获取枚举类中错误信息
	 */
	public String getErrorMessage() {
		return error.getErrorMsg();
	}
}
