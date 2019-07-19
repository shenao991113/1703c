package com.shenao.cms.core;

/**
 * 说明:自定义异常
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:15:23
 */
public class CMSRuntimeException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public CMSRuntimeException() {
		super();
	}

	public CMSRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CMSRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CMSRuntimeException(String message) {
		super(message);
	}

	public CMSRuntimeException(Throwable cause) {
		super(cause);
	}

	
}
