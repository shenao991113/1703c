package com.bw.ShenAo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class TestUtils {
	
	//����Ϊ��  ͨ��
	@Test
	public void TestIsTrue01(){
		try {
			ArrestUtils.IsTrue(true, "���Բ������");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����Ϊ��  ��ͨ��
	@Test
	public void TestIsTrue02(){
		try {
			ArrestUtils.IsTrue(false, "���Բ������");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����Ϊ��  ͨ��
	@Test
	public void TestIsFalse01(){
		try {
			ArrestUtils.IsFalse(false, "���Ա����Ǽٵ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����Ϊ��   ��ͨ��
	@Test
	public void TestIsFalse02(){
		try {
			ArrestUtils.IsFalse(true, "���Բ��Ǽٵ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���Բ�Ϊ��  ͨ��
	@Test
	public void TestNotNull01(){
		try {
			ArrestUtils.notNull("11", "���Զ����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���Բ�Ϊ��  ��ͨ��
	@Test
	public void TestNotNull02(){
		try {
			ArrestUtils.notNull(null, "���Զ����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����Ϊ��  ͨ��
	@Test
	public void TestISNull01(){
		try {
			ArrestUtils.IsNull(null, "���Զ����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����Ϊ��  ��ͨ��
	@Test
	public void TestISNull02(){
		try {
			ArrestUtils.IsNull("111", "���Զ����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���Լ��ϲ�Ϊ��  ͨ��
	@Test
	public void TestnotEmpty01(){
		try {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(111);
			ArrestUtils.notEmpty(list, "���Լ��ϲ��ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//���Լ��ϲ�Ϊ��  ��ͨ��
	@Test
	public void TestnotEmpty02(){
		try {
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			ArrestUtils.notEmpty(list, "���Լ����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����map���ϲ�Ϊ��  ͨ��
	@Test
	public void TestnotEmpty1(){
		try {
			
			HashMap<Object,String> map = new HashMap<Object, String>();
			map.put(111, "���");
			
			ArrestUtils.notEmpty(map, "����map���ϲ��ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����map���ϲ�Ϊ��  ��ͨ��
	@Test
	public void TestnotEmpty2(){
		try {
			
			HashMap<Object,String> map = new HashMap<Object, String>();
			
			ArrestUtils.notEmpty(map, "����map�����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�����ַ���������ֵ  ͨ��
	@Test
	public void TesthasText01(){
		try {
			ArrestUtils.hasText("11", "�����ַ������ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����ַ���������ֵ   ��ͨ��
	@Test
	public void TesthasText02(){
		try {
			ArrestUtils.hasText(" ", "�����ַ����ǿյ�");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����ֵ�������0   ͨ��
	@Test
	public void TestgreaterThanZero01(){
		try {
			ArrestUtils.greaterThanZero(1, "����ֵ�������0");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����ֵ�������0   ͨ��
	@Test
	public void TestgreaterThanZero02(){
		try {
			ArrestUtils.greaterThanZero(0, "����ֵС�ڵ���0");
		} catch (CRunTimeExcpion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
