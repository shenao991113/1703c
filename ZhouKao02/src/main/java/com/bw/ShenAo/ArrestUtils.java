package com.bw.ShenAo;

import java.util.Collection;
import java.util.Map;

public class ArrestUtils {
	
	/**
	 * 断言为真
	*/
	public static void IsTrue(boolean exp,String message){
		if(!exp){
			throw new CRunTimeExcpion(message); 
		}
	}
	
	/**
	 * 断言为假
	*/
	public static void IsFalse(boolean exp,String message){
		if(exp){
			throw new CRunTimeExcpion(message);
		}
	}
	
	/**
	 * 断言对象不为空
	*/
	public static void notNull(Object obj, String message){
			if(obj ==null){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * 断言对象为空
	*/
	public static void IsNull(Object obj, String message){
			if(obj !=null){
				throw new CRunTimeExcpion(message);
			}
		}
	
	
	/**
	 * 断言集合不为空，对象不能空
	*/
	public static void notEmpty(Collection<?> coll, String message){
			if(coll ==null || coll.size()==0){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * 断言map集合不为空，对象不能空
	*/
	public static void notEmpty(Map<?,?> map, String message){
			if(map ==null ||map.size()==0){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * 断言字符串必须有值，去掉空格，然后判断字符串长度是否大于0，如果没值，则抛出自定义异常
	*/
	public static void hasText(String condition, String message){
			if(!(condition.trim().length()<0)){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * 断言值必须大于0，如果小于或等于0，则抛出自定义异常
	*/
	public static void greaterThanZero(int num, String message){
			if(num <0 ||num ==0){
				throw new CRunTimeExcpion(message);
			}
		}
}
