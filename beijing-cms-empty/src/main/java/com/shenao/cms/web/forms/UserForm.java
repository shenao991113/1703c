/**
 * 
 */
package com.shenao.cms.web.forms;

import java.io.Serializable;
import java.net.URLDecoder;

import com.shenao.cms.metas.Gender;

/**
 * 说明:登录注册用户表单对应类
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月12日 上午9:36:52
 */
public class UserForm implements Serializable {

	private static final long serialVersionUID = -2890420482047142324L;

	private String username;
	
	private Gender gender;
	
	private String password;
	
	private String rePassword;
	
	private String url;

	
	/**
	 * 功能说明：<br>
	 * http://localhost/login?url=http://localhost/blog?id=1
	 * @return
	 * String
	 */
	public String getSafeUrl(){
		if(this.url != null){
			try {
				return URLDecoder.decode(this.url, "utf-8");
			} catch (Exception e) {
				
			}
		}
		return "/index";
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public String getUrl() {
		return url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
