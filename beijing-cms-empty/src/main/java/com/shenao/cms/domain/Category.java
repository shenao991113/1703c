/**
 * 
 */
package com.shenao.cms.domain;

import java.io.Serializable;


/**
 * 说明:分类表（cms_category）
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日  下午8:35:45
 */
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键**/
	private Integer id;

	/**分类名称**/
	private String name;
	
	/**排序**/
	private Integer sorted;
	
	/**所属频道**/
	private Channel channel;
	

	
	//------------------------------------------------------
	
	public Category() {
		super();
	}
	public Category(Integer id) {
		super();
		this.id = id;
	}
	

	//------------------------------------------------------

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
	//------------------------------------------------------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
