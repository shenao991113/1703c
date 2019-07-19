/**
 * 
 */
package com.shenao.cms.domain;

import java.io.Serializable;


/**
 * 说明:栏目表（cms_channel）
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日 下午8:35:45
 */
public class Channel implements Serializable{

	private static final long serialVersionUID = 1L;

	/**主键**/
	private Integer id;
	
	/**名称**/
	private String name;
	
	/**描述**/
	private String description;

	/**图标**/
	private String icon;
	
	/**排序**/
	private Integer sorted;

	
	//------------------------------------------------------
	
	public Channel() {
		super();
	}
	public Channel(Integer id) {
		super();
		this.id = id;
	}

	public Channel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Channel(Integer id, String name, int sorted) {
		super();
		this.id = id;
		this.name = name;
		this.sorted = sorted;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
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
		Channel other = (Channel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
