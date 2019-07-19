/**
 * 
 */
package com.shenao.cms.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shenao.cms.core.Page;
import com.shenao.cms.domain.Article;
import com.shenao.cms.domain.Category;
import com.shenao.cms.domain.Channel;
import com.shenao.cms.domain.Slide;
import com.shenao.cms.service.ArticleService;
import com.shenao.cms.service.SlideService;

/**
 * 说明:首页
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午8:19:15
 */
@Controller
public class HomeController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		Page _page = new Page(page, 30);
		List<Article> articles = null;
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);

		//默认首页显示热门文章
		if(category == null && channel == null){
			conditions.setHot(true);
			
			//热门文章时显示幻灯片
			List<Slide> slides = slideService.getTops(5);
			model.addAttribute("slides", slides);
		}
		
		//如果频道或分类不为空，则显示分类或频道数据
		if(category != null){
			conditions.setCategory(new Category(category));
		}else if(channel != null){
			conditions.setChannel(new Channel(channel));
		}
		
		articles = articleService.gets(conditions, _page, null);
		model.addAttribute("articles", articles);
		

		//---------------右侧放10条最新文章---------------------
		Article lastArticlesConditions = new Article();
		lastArticlesConditions.setDeleted(false);
		lastArticlesConditions.setStatus(1);
		
		Page lastArticlesPage = new Page(1, 10);
		lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
		
		List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
		model.addAttribute("lastArticles", lastArticles);

		if(channel != null){
			model.addAttribute("channel", new Channel(channel));
		}
		model.addAttribute("category", category);
		
		return "home";
	}

}
