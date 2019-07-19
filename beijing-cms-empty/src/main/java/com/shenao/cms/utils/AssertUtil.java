/**
 * 
 */
package com.shenao.cms.utils;

import com.shenao.cms.core.CMSRuntimeException;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:16:37
 */
public class AssertUtil {

	/**
	 * 功能说明：断言为真<br>
	 * @param exp
	 * @param defaultMessage
	 * void
	 */
	public static void isTrue(Boolean exp, String defaultMessage){
		if(!Boolean.TRUE.equals(exp)){
			throw new CMSRuntimeException(defaultMessage);
		}
	}
	
	/**
	 * 功能说明：断言为假<br>
	 * @param exp
	 * @param defaultMessage
	 * void
	 */
	public static void isFalse(Boolean exp, String defaultMessage){
		if(exp != null && exp){
			throw new CMSRuntimeException(defaultMessage);
		}
	}
	
	/**
	 * 功能说明：断言字符串必须有值<br>
	 * @param exp
	 * @param defaultMessage
	 * void
	 */
	public static void hasLength(String exp, String defaultMessage){
		if(exp == null || exp.length() == 0){
			throw new CMSRuntimeException(defaultMessage);
		}
	}
	
	public static void notNull(Object object, String defaultMessage){
		if(object == null){
			throw new CMSRuntimeException(defaultMessage);
		}
	}
	
}
