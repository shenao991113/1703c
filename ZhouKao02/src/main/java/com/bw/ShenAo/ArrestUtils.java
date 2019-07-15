package com.bw.ShenAo;

import java.util.Collection;
import java.util.Map;

public class ArrestUtils {
	
	/**
	 * ����Ϊ��
	*/
	public static void IsTrue(boolean exp,String message){
		if(!exp){
			throw new CRunTimeExcpion(message); 
		}
	}
	
	/**
	 * ����Ϊ��
	*/
	public static void IsFalse(boolean exp,String message){
		if(exp){
			throw new CRunTimeExcpion(message);
		}
	}
	
	/**
	 * ���Զ���Ϊ��
	*/
	public static void notNull(Object obj, String message){
			if(obj ==null){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * ���Զ���Ϊ��
	*/
	public static void IsNull(Object obj, String message){
			if(obj !=null){
				throw new CRunTimeExcpion(message);
			}
		}
	
	
	/**
	 * ���Լ��ϲ�Ϊ�գ������ܿ�
	*/
	public static void notEmpty(Collection<?> coll, String message){
			if(coll ==null || coll.size()==0){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * ����map���ϲ�Ϊ�գ������ܿ�
	*/
	public static void notEmpty(Map<?,?> map, String message){
			if(map ==null ||map.size()==0){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * �����ַ���������ֵ��ȥ���ո�Ȼ���ж��ַ��������Ƿ����0�����ûֵ�����׳��Զ����쳣
	*/
	public static void hasText(String condition, String message){
			if(!(condition.trim().length()<0)){
				throw new CRunTimeExcpion(message);
			}
		}
	
	/**
	 * ����ֵ�������0�����С�ڻ����0�����׳��Զ����쳣
	*/
	public static void greaterThanZero(int num, String message){
			if(num <0 ||num ==0){
				throw new CRunTimeExcpion(message);
			}
		}
}
