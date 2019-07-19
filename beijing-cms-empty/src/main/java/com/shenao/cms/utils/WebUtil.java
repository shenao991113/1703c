/**
 * 
 */
package com.shenao.cms.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月12日 下午7:25:50
 */
public class WebUtil {

	/**
	 * 从Request对象中取出字符串
	 * @param request
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static String getStringByRequestParameter(HttpServletRequest request, String name, String defaultValue){
		if(request == null) return defaultValue;
		String str = request.getParameter(name);
		return str == null ?  defaultValue : str.trim();
	}

	
	/**
	 * 从Request对象中取出布尔值
	 * @param request
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static boolean getBooleanByRequestParameter(HttpServletRequest request, String name, boolean defaultValue){
		if(request == null || request.getParameter(name) == null)
			return defaultValue;
		try {
			return Boolean.parseBoolean(request.getParameter(name));
		} catch (Exception e) {
			return defaultValue;
		}
	}

	
	/**
	 * 从Request对象中取出整数
	 * @param request
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static Integer getIntByRequestParameter(HttpServletRequest request, String name, Integer defaultValue){
		if(request == null) return defaultValue;
		try {
			return Integer.parseInt(request.getParameter(name));
		} catch (Exception e) {
			return defaultValue;
		}
	}
	
	
	/**
	 * 从Request对象中取出Long整数
	 * @param request
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static Long getLongByRequestParameter(HttpServletRequest request, String name, Long defaultValue){
		if(request == null) return defaultValue;
		try {
			return Long.parseLong(request.getParameter(name));
		} catch (Exception e) {
			return defaultValue;
		}
	}


	/**
	 *
	 * @param request
	 * @param urlCodeType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getUrl(HttpServletRequest request, boolean urlEncoding) throws UnsupportedEncodingException{
		StringBuffer url = new StringBuffer(request.getAttribute("javax.servlet.forward.servlet_path") == null ? request.getRequestURL() : (String)request.getAttribute("javax.servlet.forward.servlet_path"));
		String parm = param(request);
		if (StringUtil.hasLength(parm)) {
			url.append("?").append(parm);
		}
		
		String result = url.toString();
		
		if(urlEncoding){
			return URLEncoder.encode(result, "UTF-8");
		}
		return result;
	}

	/**
	 * 解码url字符串
	 * @param url
	 * @param urlCodeType 编码方式
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String parseUrl(String url, boolean urlCoding) throws UnsupportedEncodingException{
		if(urlCoding){
			url = URLDecoder.decode(url, "UTF-8");
		}
		return url;
	}


	/**
	 * 获取URL上的参数，但可以忽略指定的参数
	 * @param request
	 * @param ignores
	 * @return
	 */
	public static String param(HttpServletRequest request, String...ignoreParams){

		StringBuffer url = new StringBuffer();
		Enumeration<?> param = request.getParameterNames();//得到所有参数名

		Set<String> ignoreSet = ignoreParams.length == 0 ? null : new HashSet<String>(Arrays.asList(ignoreParams));

		//如果没有忽略参数，则单独处理以提高性能
		if(ignoreSet == null){
			while(param.hasMoreElements()){
				String pname = param.nextElement().toString();
				url.append(pname).append("=").append(request.getParameter(pname)).append("&");
			}
		}

		else{
			while(param.hasMoreElements()){
				String pname = param.nextElement().toString();
				if(ignoreSet.contains(pname)){
					continue;
				}
				url.append(pname).append("=").append(request.getParameter(pname)).append("&");
			}
		}

		if(url.toString().endsWith("&")){
			url.deleteCharAt( url.length() - 1 );
		}
		String result = url.toString();
		result = result.replace("\"", "%22").replace("'", "%27").replace("<", "&lt;").replace(">", "&gt;");
		return result;
	}

	
}
