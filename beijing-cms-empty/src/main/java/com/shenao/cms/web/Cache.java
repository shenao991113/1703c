/**
 * 
 */
package com.shenao.cms.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.shenao.cms.domain.Category;
import com.shenao.cms.domain.Channel;
import com.shenao.cms.service.ChannelCategoryService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午10:15:33
 */
@Component
public class Cache {

	@Resource
	private ChannelCategoryService channelCategoryService;
	
	@Resource
	private ServletContext application;
	
	
	/**
	 * 功能说明：缓存数据<br>
	 * 
	 * @PostConstruct注解相当于Spring配置文件的<bean init-method="">
	 * 
	 * void
	 */
	@PostConstruct
	public void init(){
		//缓存所有频道和分类
		Map<Channel, List<Category>> categories = new LinkedHashMap<Channel, List<Category>>();
		List<Channel> channels = channelCategoryService.getChannels();
		for (Channel channel : channels) {
			categories.put(channel, new ArrayList<Category>());
		}
		
		List<Category> _categories = channelCategoryService.getCategories();
		for (Category category : _categories) {
			List<Category> cs = categories.get(category.getChannel());
			if(cs != null){
				cs.add(category);
			}
		}
		
		application.setAttribute("_CHANNELS_AND_CATEGORIES_", categories);
	}
}
