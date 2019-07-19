/**
 * 
 */
package com.shenao.cms.service;

import java.util.List;

import com.shenao.cms.domain.Category;
import com.shenao.cms.domain.Channel;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午1:25:25
 */
public interface ChannelCategoryService {
	
	//----------------------------------频道----------------------------

	public void saveChannel(Channel channel);

	public void removeChannel(int id);
	
	public Channel getChannel(int id);

	public List<Channel> getChannels();

	
	//----------------------------------分类----------------------------
	
	public void saveCategory(Category category) ;

	public void removeCategory(int id);
	
	public Category getCategory(int id);

	public List<Category> getCategories(int channelId);

	public List<Category> getCategories() ;

	
}
