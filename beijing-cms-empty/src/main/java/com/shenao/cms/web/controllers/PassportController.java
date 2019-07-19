/**
 * 
 */
package com.shenao.cms.web.controllers;

import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shenao.cms.core.CMSRuntimeException;
import com.shenao.cms.domain.User;
import com.shenao.cms.service.PassportService;
import com.shenao.cms.utils.AssertUtil;
import com.shenao.cms.web.Constant;
import com.shenao.cms.web.forms.UserForm;

/**
 * 说明:登录注册页面
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月12日 上午9:30:52
 */
@Controller
public class PassportController {
	
	private static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@Resource(name = "passportService")
	private PassportService passportService;
	
	/**
	 * 功能说明：去注册页面<br>
	 * @param model
	 * @return
	 * String
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.GET)
	public String reg(Model model){
		model.addAttribute("userForm", new UserForm());
		return "passport/reg";
	}
	
	/**
	 * 功能说明：注册表单提交<br>
	 * 如果注册成功，跳转到登录页，并携带用户名
	 * @param userForm
	 * @param model
	 * @param redirectAttributes
	 * @return
	 * String
	 */
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(@ModelAttribute("userForm") UserForm userForm, Model model, RedirectAttributes redirectAttributes){
		
		try {
			AssertUtil.hasLength(userForm.getUsername(), "用户名不能空");
			AssertUtil.hasLength(userForm.getPassword(), "密码不能空");
			AssertUtil.isTrue(userForm.getPassword().equals(userForm.getRePassword()), "两次密码不一致");
			
			passportService.reg(userForm.getUsername(), userForm.getPassword(), null, userForm.getGender());
			
			redirectAttributes.addFlashAttribute("message", "恭喜您注册成功，请登录。");
			
			return "redirect:/login?username=" + URLEncoder.encode(userForm.getUsername(), "utf-8");
		} 
		catch (CMSRuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		catch (Exception e) {
			model.addAttribute("message", "内部错误");
			log.error("注册发生错误：", e);
		}

		return "passport/reg";
	}
	
	
	/**
	 * 功能说明：去登录页，<br>
	 * 1.如果前面传来了url、用户名，将直接封装到UserForm
	 * 2.如果注册页通过RedirectAttributes传来了message，将在页面上显示message内容。
	 * 3.如果是拦截器过来的，则在登录页面上提示"您需要登录才能进行下一步"
	 * 
	 * @param userForm
	 * @param src
	 * @param model
	 * @return
	 * String
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(UserForm userForm, @RequestParam(required = false) String src, Model model){
		if("interceptor".equals(src)){
			model.addAttribute("message", "您需要登录才能进行下一步");
		}
		return "passport/login";
	}
	
	
	/**
	 * 功能说明：登录提交<br>
	 * 1.如果登录之前携带了URL地址，登录成功之后将跳转到这个地址上
	 * 
	 * @param userForm
	 * @param model
	 * @param session
	 * @return
	 * String
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginSubmit(@ModelAttribute UserForm userForm, Model model, HttpServletRequest request){
		try {
			User user = passportService.login(userForm.getUsername(), userForm.getPassword());
			Constant.setLoginUser(request, user);
			return "redirect:" + userForm.getSafeUrl();
		} 
		catch (CMSRuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		catch (Exception e) {
			model.addAttribute("message", "内部错误");
			log.error("登录错误：", e);
		}
		return "passport/login";
	}
	
	
	/**
	 * 功能说明：退出<br>
	 * @param request
	 * @return
	 * String
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null){
			session.invalidate();
		}
		return "redirect:/index";
	}
	
	
	
}
