package com.bw.entity;

public class User {
	
	private Integer uid;
	private String uname;
	private String upwd;
	private String utype;
	private String phone;
	private String path;
	private Integer sheng;
	private Integer shi;
	private Integer xian;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getSheng() {
		return sheng;
	}
	public void setSheng(Integer sheng) {
		this.sheng = sheng;
	}
	public Integer getShi() {
		return shi;
	}
	public void setShi(Integer shi) {
		this.shi = shi;
	}
	public Integer getXian() {
		return xian;
	}
	public void setXian(Integer xian) {
		this.xian = xian;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd
				+ ", utype=" + utype + ", phone=" + phone + ", path=" + path
				+ ", sheng=" + sheng + ", shi=" + shi + ", xian=" + xian + "]";
	}
	public User(Integer uid, String uname, String upwd, String utype,
			String phone, String path, Integer sheng, Integer shi, Integer xian) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.utype = utype;
		this.phone = phone;
		this.path = path;
		this.sheng = sheng;
		this.shi = shi;
		this.xian = xian;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
