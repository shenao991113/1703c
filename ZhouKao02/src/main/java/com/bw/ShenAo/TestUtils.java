package com.bw.ShenAo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class TestUtils {
	
	//断言为真  通过
	@Test
	public void TestIsTrue01(){
		try {
			ArrestUtils.IsTrue(true, "断言不是真的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言为真  不通过
	@Test
	public void TestIsTrue02(){
		try {
			ArrestUtils.IsTrue(false, "断言不是真的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言为假  通过
	@Test
	public void TestIsFalse01(){
		try {
			ArrestUtils.IsFalse(false, "断言必须是假的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言为假   不通过
	@Test
	public void TestIsFalse02(){
		try {
			ArrestUtils.IsFalse(true, "断言不是假的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言不为空  通过
	@Test
	public void TestNotNull01(){
		try {
			ArrestUtils.notNull("11", "断言对象不是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言不为空  不通过
	@Test
	public void TestNotNull02(){
		try {
			ArrestUtils.notNull(null, "断言对象是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言为空  通过
	@Test
	public void TestISNull01(){
		try {
			ArrestUtils.IsNull(null, "断言对象是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言为空  不通过
	@Test
	public void TestISNull02(){
		try {
			ArrestUtils.IsNull("111", "断言对象不是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言集合不为空  通过
	@Test
	public void TestnotEmpty01(){
		try {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(111);
			ArrestUtils.notEmpty(list, "断言集合不是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言集合不为空  不通过
	@Test
	public void TestnotEmpty02(){
		try {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			ArrestUtils.notEmpty(list, "断言集合是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言map集合不为空  通过
	@Test
	public void TestnotEmpty1(){
		try {
			
			HashMap<Object,String> map = new HashMap<Object, String>();
			map.put(111, "沈奥");
			
			ArrestUtils.notEmpty(map, "断言map集合不是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言map集合不为空  不通过
	@Test
	public void TestnotEmpty2(){
		try {
			
			HashMap<Object,String> map = new HashMap<Object, String>();
			
			ArrestUtils.notEmpty(map, "断言map集合是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言字符串必须有值  通过
	@Test
	public void TesthasText01(){
		try {
			ArrestUtils.hasText("11", "断言字符串不是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//断言字符串必须有值   不通过
	@Test
	public void TesthasText02(){
		try {
			ArrestUtils.hasText(" ", "断言字符串是空的");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言值必须大于0   通过
	@Test
	public void TestgreaterThanZero01(){
		try {
			ArrestUtils.greaterThanZero(1, "断言值必须大于0");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//断言值必须大于0   通过
	@Test
	public void TestgreaterThanZero02(){
		try {
			ArrestUtils.greaterThanZero(0, "断言值小于等于0");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
