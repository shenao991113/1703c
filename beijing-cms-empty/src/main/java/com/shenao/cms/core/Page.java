/**
 * 
 */
package com.shenao.cms.core;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.shenao.cms.utils.StringUtil;
import com.shenao.cms.utils.WebUtil;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *w
 * 2018年1月16日 下午7:36:04
 */
public class Page implements Serializable {

	private static final long serialVersionUID = -625302977128629259L;

	/**URL传递的页码参数名**/
	public static final String PAGE_NUMBER_PARAMETER_NAME = "pageIndex";

	/**URL传递的页数参数名**/
	public static final String PAGE_TOTAL_PARAMETER_NAME  = "pageCount";

	/**作用域中的页对象**/
	public static final String SCOPE_NAME = Page.class.getName() + ".pageBean";

	/**当前页**/
	private int pageIndex;

	/**每页数据量**/
	private int pageSize = 10;

	/**总共数据量**/
	private int totalCount;

	/**页码跳转路径**/
	private String url;

	/**附加参数**/
	private Map<String, Object> attributes;

	//------------------------------------------------------------------------------------

	/**
	 * @param pageIndex 当前页码
	 */
	public Page(int pageIndex){
		if(pageIndex < 1)
			pageIndex = 1;
		this.pageIndex = pageIndex;
	}

	/**
	 * @param pageIndex 当前页码
	 * @param pageSize  每页数量
	 */
	public Page(int pageIndex, int pageSize){
		this(pageIndex);
		this.pageSize = pageSize;
	}
	
	/**
	 * 传入总页数可以减少统计查询操作
	 * @param pageIndex 当前页码
	 * @param pageSize 每页数量
	 * @param pageCount 总页数
	 */
	public Page(int pageIndex, int pageSize, int pageCount){
		this(pageIndex, pageSize);
		this.totalCount = this.pageSize * pageCount;
	}
	
	/**
	 * @param pageIndex 当前页码
	 * @param pageSize  每页数量
	 * @param url       页码上的地址
	 */
	public Page(int pageIndex, int pageSize, String url){
		this(pageIndex, pageSize);
		this.url = url;
	}


	
	/**
	 * 自动填充当前页码和总记录数(传入总页数可以减少统计查询操作)
	 * @param pageIndex  页码
	 * @param pageSize 每页数量
	 * @param pageCount 总页数
	 * @param url      页码上的地址
	 */
	public Page(int pageIndex, int pageSize, int pageCount, String url){
		this(pageIndex, pageSize, url);
		this.totalCount = this.pageSize * pageCount;
	}

	/**
	 * 自动填充当前页码和总记录数
	 * @param request  HttpServletRequest对象
	 * @param pageSize 每页数量
	 * @param url      页码上的地址
	 */
	public Page(HttpServletRequest request, int pageSize, String url){
		this(WebUtil.getIntByRequestParameter(request, PAGE_NUMBER_PARAMETER_NAME, 1), pageSize,
				WebUtil.getIntByRequestParameter(request, PAGE_TOTAL_PARAMETER_NAME, 0));
		if(StringUtil.hasLength( url) ){
			String param = WebUtil.param(request, Page.PAGE_NUMBER_PARAMETER_NAME, Page.PAGE_TOTAL_PARAMETER_NAME);
			if(StringUtil.hasLength(param)){
				url+="?" + param;
			}
			this.url = url;
		}
		if(request.getAttribute(SCOPE_NAME) == null){
			setToScope(request);
		}
	}

	public static Page newInstance(HttpServletRequest request, int pageSize, String url){
		return new Page(request, pageSize, url);
	}

	
	//------------------------------------------------------------------------------------
	
	/**
	 * 将Page对象置入HttpServletRequest域中
	 */
	public void setToScope(HttpServletRequest request){
		request.setAttribute(SCOPE_NAME, this);
	}

	
	
	//------------------------------------------------------------------------------------
	
	
	public void setPageIndex(int pageIndex) {
		if(pageIndex < 1)
			pageIndex = 1;
		this.pageIndex = pageIndex;
	}

	public int getPageIndex() {
		return this.pageIndex;
	}

	/**
	 * 总记录
	 * @return int
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 每页数据大小
	 * @return  int
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 页中的第一条记录
	 * @return int
	 */
	public int getFirstIndex(){
		return (this.pageIndex - 1) * this.pageSize;
	}

	/**
	 * 页中的最后一条记录
	 * @return int
	 */
	public int getLastIndex(){
		int n = getFirstIndex() + this.pageSize;
		if (n > this.totalCount)
			n = this.totalCount;
		return n;
	}

	/**
	 * 总页数
	 * @return int
	 */
	public int getPageCount() {
		if (this.totalCount == 0)
			return 0;
		return this.totalCount / this.pageSize + ((this.totalCount % this.pageSize == 0) ? 0 : 1);
	}

	public boolean isEmpty() {
		return this.totalCount == 0;
	}

	public boolean getHasPrevious() {
		return this.pageIndex > 1;
	}

	public boolean getHasNext() {
		return this.pageIndex < getPageCount();
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public Object getAttribute(String key) {
		return this.attributes == null ? null : this.attributes.get(key);
	}
	
	public void removeAttribute(String key) {
		if(this.attributes != null){
			this.attributes.remove(key);
		}
	}
	
	public Object getAttribute(String key, Object defaultValue) {
		if(this.attributes != null){
			Object result = this.attributes.get(key);
			if(result != null){
				return result;
			}
		}
		return defaultValue;
	}

	public void addAttribute(String key, Object value){
		if(this.attributes == null){
			this.attributes = new LinkedHashMap<>();
		}
		this.attributes.put(key, value);
	}

	
	public String toString(){
		return print();
	}

	/**
	 * 输出分页代码
	 * @return
	 */
	public String print(){
		return print2(1, true, true, true);
	}

	public String print2(
			int styleSize, 
			boolean displayTotalPages, 
			boolean displayTotalRecords,
			boolean displayLastPage
			){
		
		if(getTotalCount() == 0){
			return "";
		}
		
		String style = "";
		if(styleSize == 1){
			style = " pagination-lg";
		}else if(styleSize == -1){
			style = " pagination-sm";
		}
		
		StringBuilder sb = new StringBuilder();
		
		//如果设定了要打印总页数，则在JSP页面中输出当前页和总页数
		if(displayTotalPages){
			sb.append("当前页/总页数："+ getPageIndex() + "/" + getPageCount() + "&nbsp;&nbsp;");
		}
		//标记中调用是否指定输出每页记录数和总记录数
		if(displayTotalRecords){
			sb.append("&nbsp;&nbsp;每页记录数/总记录数：")
			.append(getPageSize())
			.append("/")
			.append(getTotalCount());
		}
		
		if(sb.length() > 0){
			sb.insert(0, "<p align='center'>");
			sb.append("</p>");
		}
		
		//sb.append("页码：");
		
		//如果当前页码大于1时，应该输出开始一页和上一页的连接
		sb.append("<ul class=\"pagination").append(style).append("\">")
			.append("<li").append(getPageIndex() == 1 ? " class=\"disabled\">" : ">")
			.append("<a title=\"开始一页\" href=\"")
			.append(conversionUrl(getUrl(), 1, getPageCount()))
			.append("\">&laquo;</a></li>");
		
		//开始在总页数里循环
		for (int i = 1; i <= getPageCount(); i++){
			
			//假如有几十页、几百页、甚至n多，不能全部将页码输出，这里只取10页
			if(getPageIndex() < 5 && i < 10){
				if(i == getPageIndex()){
					//当前页不应该有连接
					sb.append("<li class=\"active\"><span>").append(i).append(" <span class=\"sr-only\">(current)</span></span></li>");
				}else{
					sb.append("<li><a href=\"")
					.append(conversionUrl(getUrl(), i, getPageCount()))
					.append("\" title=\"第").append(i).append("页\">")
					.append(i)
					.append("</a></li>");
				}
			}else{
				
				if(i > getPageIndex() - 5 && i < getPageIndex() + 5){
					if(i == getPageIndex()){
						sb.append("<li class=\"active\"><span>").append(i).append("<span class=\"sr-only\">(current)</span></span></li>");
					}else{
						sb.append("<li><a href=\"")
						.append(conversionUrl(getUrl(), i, getPageCount()))
						.append("\" title=\"第").append(i).append("页\">")
						.append(i)
						.append("</a></li>");
					}
				}
			}
		}
		
		if(displayLastPage){
			sb.append("<li")
			.append(getPageIndex() == getPageCount() ? " class=\"disabled\">" : ">")
			.append("<a title=\"最后一页\" href=\"")
			.append(conversionUrl(getUrl(), getPageCount(), getPageCount()))
			.append("\">&raquo;</a></li>");
		}
		
		sb.append("</ul>");
		
		return sb.toString();
	}



	/**
	 * 转换URL，携带页数量，可以省去统计步骤
	 * @param url
	 * @param pageindex
	 * @param pageCount
	 * @return
	 */
	public static String conversionUrl(String url, int pageindex, int pageCount){
		if(url == null || url.length() < 1){
			return "index.jsp";
		}

		int index = url.indexOf("?");
		StringBuffer sb = new StringBuffer();

		/*
		 * 如果是REST风格
		 * e.g. http://www.howsun.org/article/list_*.html
		 */
		if(url.indexOf('*') > -1){
			url = url.replace("*", String.valueOf(pageindex));
			return sb.append(url)
					.append(index > -1 ? "&" : "?")
					.append(Page.PAGE_TOTAL_PARAMETER_NAME)
					.append("=")
					.append(pageCount)
					.toString() ;
		}

		sb.append(url);
		if(index > -1){
			char c = sb.charAt(sb.length() - 1);
			if(c != '?' && c != '&'){
				sb.append("&");
			}
		}else{
			sb.append("?");
		}

		sb.append(Page.PAGE_NUMBER_PARAMETER_NAME)
		.append("=")
		.append(pageindex)
		.append("&")
		.append(Page.PAGE_TOTAL_PARAMETER_NAME)
		.append("=")
		.append(pageCount);

		return sb.toString();
	}
}
