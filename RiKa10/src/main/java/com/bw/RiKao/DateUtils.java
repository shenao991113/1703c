package com.bw.RiKao;

import java.sql.Date;

public class DateUtils {
	private static Date date;

	/*
	����1�����ݴ�������ڻ�ȡ����
	//ʾ��:*/
	public static int getAge (int src) {
		
			int num=2019;
			int n=(num-src);
			return n;
	}
	
	
	/*����2�����ݴ���Ĳ�����ȡ�����ڵ��³����ڣ��������������Ϊ��2019-09-19 19:29:39�������ء�2019-09-01 00:00:00��
	//ʾ��:*/
	public static Date getDateByMonthInit (Date src) {
		
		if(src !=null){
			
		}
		
		return src;
	}
	
	/*����3 :���ݴ���Ĳ�����ȡ����������ĩ���ڣ��������������Ϊ��2019-09-19 19:29:39�������ء�2019-09-30 23:59:59����ע���´���С�Լ����ꡣ
	//ʾ��:*/
	public static void getDateByMonthLast(Date src) {
		
	}

	/*����4����δ����������컹ʣ������
	//ʾ��:*/
	public static int getDaysByFuture (int future) {
		
			int n=2019;
			int num=(future-n);
		
		return num;
	}
	
	/*����5�����ȥ����������ȥ������
	//ʾ��:*/
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
