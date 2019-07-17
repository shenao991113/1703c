package com.bw.RiKao;

import org.junit.Test;

public class TestUtils {
	
	/*根据传入的日期获取年龄*/
	
	@Test
	public void test01(){
		
		int age = DateUtils.getAge(1999);
		System.out.println("今年多大："+age);
	}
	
	/*求未来日期离今天还剩的天数*/
	@Test
	public void test02(){
		
		int age = DateUtils.getDaysByFuture(2022);
		System.out.println("今距今还有多少年："+age);
	}
	
	/*求过去日期离今天  过去的天数*/
	@Test
	public void test03(){
		
		int age = DateUtils.getDaysByDeparted(1999);
		System.out.println("距离今天已经过去："+age+"年");
	}
	
	@Test
	public void test04(){
		
		String age = DateUtils.getDay("1999");
		System.out.println("距离今天已经过去："+age+"年");
	}
}
