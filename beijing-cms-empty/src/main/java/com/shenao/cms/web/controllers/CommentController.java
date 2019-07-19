package com.shenao.cms.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shenao.cms.domain.Comment;
import com.shenao.cms.domain.User;
import com.shenao.cms.service.CommentService;
import com.shenao.cms.utils.Result;
import com.shenao.cms.web.Constant;

/**
 * 评论Controller
 * @author ASUS
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping("save")
	@ResponseBody
	public Result save(Comment comment,HttpSession seesion){
		comment.setDisplayTime(new Date());
		User user = (User) seesion.getAttribute(Constant.LOGIN_USER);
		comment.setUser(user);
		Result result = new Result();
		try {
			//Result:专门用于给客户端相应的消息类
			commentService.save(comment);
			result.setStatus(true);
			result.setMsg("评论成功");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMsg("评论失败");
			e.printStackTrace();
		}
		return result;
	}
}
