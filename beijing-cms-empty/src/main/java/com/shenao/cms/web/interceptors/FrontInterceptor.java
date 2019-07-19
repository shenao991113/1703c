/**
 * 
 */
package com.shenao.cms.web.interceptors;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shenao.cms.service.ChannelCategoryService;
import com.shenao.cms.utils.WebUtil;
import com.shenao.cms.web.Constant;

/**
 * 说明:拦截器
 * 1、负责拦截权限
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月12日 下午7:15:34
 */
public class FrontInterceptor implements HandlerInterceptor {
	
	@Resource
	private ServletContext application;
	
	@Resource
	private ChannelCategoryService categoryService;

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(handler instanceof HandlerMethod){
			HttpSession session = request.getSession(false);
			if(session == null || session.getAttribute(Constant.LOGIN_USER) == null){
				response.sendRedirect("/login?src=interceptor&url=" + WebUtil.getUrl(request, true));
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
