package com.shenao.cms.utils;

import com.github.pagehelper.PageInfo;

public class PageHelpUtil {
  public static String page(String url, PageInfo<?> pageInfo, String...params) {
	 if(params!= null && params.length > 0){
		 String first = "<a href=" + url + "?page=1&start=" + params[0] + "&end="+params[1]+">首页</a>";
		    if(pageInfo.getPrePage() == 0){
		    	pageInfo.setPrePage(1);
		    }
		    String prev = "<a href=" + url + "?page=" + pageInfo.getPrePage() + "&start=" + params[0] + "&end="+params[1]+">上一页</a>";
		    String pages = "";
		    for(int i = 1; i <= pageInfo.getPages(); i++){
		    	pages +="<a href=" + url + "?page=" + i
		    			+ "&start=" + params[0] + "&end="+params[1]+">"+i+ " " + "</a>";
		    }
		    if(pageInfo.getNextPage() == 0){
		    	pageInfo.setNextPage(pageInfo.getPages());
		    }
		    String next = "<a href=" + url + "?page=" + pageInfo.getNextPage() +  "&start=" + params[0] + "&end="+params[1]+">下一页</a>";
		    
		    String last = "<a href=" + url + "?page=" + pageInfo.getLastPage() + "&start=" + params[0] + "&end="+params[1]+">尾页</a>";
		    
		    return first + " " + prev + " " + pages + " " +
		    next + " "+ last;
	 } else{
		 String first = "<a href=" + url + "?page=1"+">首页</a>";
		    if(pageInfo.getPrePage() == 0){
		    	pageInfo.setPrePage(1);
		    }
		    String prev = "<a href=" + url + "?page=" + pageInfo.getPrePage()+">上一页</a>";
		    String pages = "";
		    for(int i = 1; i <= pageInfo.getPages(); i++){
		    	pages +="<a href=" + url + "?page=" + i+">"+i+ " " + "</a>";
		    }
		    if(pageInfo.getNextPage() == 0){
		    	pageInfo.setNextPage(pageInfo.getPages());
		    }
		    String next = "<a href=" + url + "?page=" + pageInfo.getNextPage()+">下一页</a>";
		    
		    String last = "<a href=" + url + "?page=" + pageInfo.getLastPage()+">尾页</a>";
		    
		    return first + " " + prev + " " + pages + " " +
		    next + " "+ last;
	 }
  }

 /* *//***
   * 需要定义表单中的name属性值为paramMap的key
   * @param url
   * @param cpage
   * @param pageSize
   * @param count
   * @param paramMap
   * @return
   *//*
  public static Map<String, Object> pageMap(String url, PageInfo<?> pageInfo, Map<String, Object> paramMap) {
    //需要定义表单中的name属性值为map的key
    String param = "";
    Set<String> keySet = paramMap.keySet();
    for (String key : keySet) {
      param += "&" + key + "=" + paramMap.get(key);
    }

    String now = "第" + pageInfo.getPageNum() + "/" + pageInfo.getNavigateLastPage() + "页";
    String first = "<a href=" + url + "?cpage=1" + param + ">首页</a>";

    //没有上一页的话 让上一页设置为1
    if (pageInfo.getPrePage() == 0) {
      pageInfo.setPrePage(1);
    }

    String prev = "<a href=" + url + "?cpage=" + pageInfo.getPrePage() + param + ">上一页</a>";
    //PageInfo中如果没有下一页 nextPage = 0
    if (pageInfo.getNextPage() == 0) {
      pageInfo.setNextPage(pageInfo.getNavigateLastPage());
    }
    String next = "<a href=" + url + "?cpage=" + pageInfo.getNextPage() + param + ">下一页</a>";
    String last = "<a href=" + url + "?cpage=" + pageInfo.getNavigateLastPage() + param + ">尾页</a>";
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("cpage", pageInfo.getPageNum());
    map.put("count", pageInfo.getTotal());
    map.put("pagecount", pageInfo.getPages());
    map.put("page", now + " " + first + " " + prev + " " + next + " " + last);
    return map;
  }*/

}
