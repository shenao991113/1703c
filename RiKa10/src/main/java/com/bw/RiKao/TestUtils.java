package com.bw.RiKao;

import org.junit.Test;

public class TestUtils {
	
	/*���ݴ�������ڻ�ȡ����*/
	
	@Test
	public void test01(){
		
		int age = DateUtils.getAge(1999);
		System.out.println("������"+age);
	}
	
	/*��δ����������컹ʣ������*/
	@Test
	public void test02(){
		
		int age = DateUtils.getDaysByFuture(2022);
		System.out.println("�����ж����꣺"+age);
	}
	
	/*���ȥ���������  ��ȥ������*/
	@Test
	public void test03(){
		
		int age = DateUtils.getDaysByDeparted(1999);
		System.out.println("��������Ѿ���ȥ��"+age+"��");
	}
	
	@Test
	public void test04(){
		
		String age = DateUtils.getDay("1999");
		System.out.println("��������Ѿ���ȥ��"+age+"��");
	}
}
