/**
 * 
 */
package com.shenao.cms.web;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shenao.cms.domain.User;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月13日 上午9:48:04
 */
public class Constant implements Serializable {

	
	private static final long serialVersionUID = 1L;

	/**上传目录**/
	public static final String UPLOAD_DIR = "/upload";
	
	/**管理员登录key**/
	public static final String LOGIN_ADMIN = "_LOGIN_ADMIN_";
	
	/**登录用户key**/
	public static final String LOGIN_USER = "_LOGIN_USER_";
	
	public static void setLoginUser(HttpServletRequest request, User user){
		HttpSession session = request.getSession();
		setLoginUser(session, user);
	}
	
	public static void setLoginUser(HttpSession session, User user){
		session.setAttribute(Constant.LOGIN_USER, user);
	}
	
	public static User getLoginUser(HttpServletRequest request){
		return getLoginUser(request.getSession(false));
	}
	
	public static User getLoginUser(HttpSession session){
		User user = session == null ? null : (User) session.getAttribute(Constant.LOGIN_USER);
		return user;
	}

}
