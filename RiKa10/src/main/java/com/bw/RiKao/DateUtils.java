package com.bw.RiKao;

import java.sql.Date;

public class DateUtils {
	private static Date date;

	/*
	方法1：根据传入的日期获取年龄
	//示例:*/
	public static int getAge (int src) {
		
			int num=2019;
			int n=(num-src);
			return n;
	}
	
	
	/*方法2：根据传入的参数获取该日期的月初日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-01 00:00:00”
	//示例:*/
	public static Date getDateByMonthInit (Date src) {
		
		if(src !=null){
			
		}
		
		return src;
	}
	
	/*方法3 :根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”，返回“2019-09-30 23:59:59”，注意月大月小以及闰年。
	//示例:*/
	public static void getDateByMonthLast(Date src) {
		
	}

	/*方法4：求未来日期离今天还剩的天数
	//示例:*/
	public static int getDaysByFuture (int future) {
		
			int n=2019;
			int num=(future-n);
		
		return num;
	}
	
	/*方法5：求过去日期离今天过去的天数
	//示例:*/
	public static int getDaysByDeparted (int departed) {
			int n=2019;
			int num=(n-departed);
		return num;
	}
	
	
	public static String getDay (String dbd) {
		
		String n="2019-7-17";
		String num=("n-dbd");
		return "num";
}
}
