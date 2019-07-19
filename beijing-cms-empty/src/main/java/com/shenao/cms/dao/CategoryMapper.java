/**
 * 
 */
package com.shenao.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shenao.cms.domain.Category;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月27日 下午2:56:07
 */
public interface CategoryMapper {

	public void insert(Category category);

	public void deleteById(int id);

	public Category selectById(int id);
	
	public List<Category> selectAll();
	
	public List<Category> selectByChannel(@Param("channel_id") int channelId);
	
	
}
