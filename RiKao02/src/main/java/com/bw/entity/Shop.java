package com.bw.entity;

public class Shop {
	
	private Integer sid;
	private String sname;
	private double price;
	private String stime;
	private String context;
	private Integer tid;
	
	private String tname;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Shop(Integer sid, String sname, double price, String stime,
			String context, Integer tid, String tname) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.price = price;
		this.stime = stime;
		this.context = context;
		this.tid = tid;
		this.tname = tname;
	}

	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Shop [sid=" + sid + ", sname=" + sname + ", price=" + price
				+ ", stime=" + stime + ", context=" + context + ", tid=" + tid
				+ ", tname=" + tname + "]";
	}
	
}
