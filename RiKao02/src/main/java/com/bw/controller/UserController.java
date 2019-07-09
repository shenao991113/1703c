package com.bw.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import aj.org.objectweb.asm.Type;

import com.alibaba.fastjson.JSON;
import com.bw.Service.UserService;
import com.bw.Utils.ResultUtil;
import com.bw.entity.Shop;
import com.bw.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
public class UserController {
	
	@Resource
	private UserService service;
	
	@RequestMapping("login.do")
	@ResponseBody
	private ResultUtil longin(User user,HttpSession session){
		
		ResultUtil r=service.login(user,session);
		
		return r;
	}
	
	@RequestMapping("/list.do")
	public String findAll(Model m,@RequestParam(required=false,defaultValue="1")Integer pageNum,String sname,String Minprice,String Maxprice){
		
		Page<Object> page = PageHelper.startPage(pageNum,3);
		List<Shop> list=service.findAll(sname,Minprice,Maxprice);
		
		m.addAttribute("list", list);
		m.addAttribute("page", pageNum);
		m.addAttribute("pages", page.getPages());
		
		return "list";
	}
	
	@RequestMapping("/deleteAll.do")
	@ResponseBody
	public Integer deleteAll(String sid){
		
		int num=service.deleteAll(sid);
		
		return num;
	}
	
	@RequestMapping("/findType.do")
	@ResponseBody
	public String findType(Model m){
		
		List<Type> list=service.findType();
		
		m.addAttribute("list", list);
		
		String string = JSON.toJSONString(m);
		
		return (String) JSON.toJSON(string);
	}
	
	@RequestMapping("/addOne.do")
	@ResponseBody
	public Integer addOne(Shop shop){
		
		int num=service.addOne(shop);
		
		return num;
	}
}
