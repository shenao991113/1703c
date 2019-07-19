/**
 * 
 */
package com.shenao.cms.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 说明: 首页广告表或幻灯片表（cms_slide）
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日  上午8:42:13
 */
public class Slide implements Serializable {

	
	private static final long serialVersionUID = 1L;

	/**主键**/
	private Integer id;

	/**标题**/
	private String title;
	
	/**图片**/
	private String picture;

	/**地址**/
	private String url;
	
	/**创建时间：首页幻灯片按时间倒排序**/
	private Date created;

	
	//-----------------------------------------------------------------
	
	public Slide() {
		super();
	}
	
	public Slide(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}
	
	
	//-----------------------------------------------------------------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	
	//-----------------------------------------------------------------
	
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
		Slide other = (Slide) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
