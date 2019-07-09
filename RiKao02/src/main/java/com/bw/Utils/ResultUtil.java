package com.bw.Utils;

public class ResultUtil {
	//状态
	private int status;
	//消息
	private String msg;
	//数据
	private Object data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultUtil(int status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public ResultUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResultUtil [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
