package com.bw.Utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtils {
	
	/*�����ر����������ܴ����޸�,���紫��FileInputStream����JDBC��Connection���󶼿��Թرա�*/
	
	public static void closeAll(Closeable... closeables) throws Exception {
			
			FileInputStream inputStream = new FileInputStream("");
			
			inputStream.close();
		}
	
	/*����������InputStream������OutputStream���������ڿ��ٶ����ļ����ϴ����أ�Ϊ��������ܣ���Ҫʹ�û��塣*/
	
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
		
			FileInputStream inputStream = new FileInputStream("");
			
			FileOutputStream outputStream = new FileOutputStream("");
			
			
		}
	
	
	/*����һ���ı��ļ�����Ĭ��ΪUTF-8���룬���ظ��ļ����ݣ�Ҫ�󷽷��ڲ����������2���������������������1�������ر���*/
	
	public static String readTextFile(InputStream src) throws IOException{
			
		
			return null;
		}
	
	/*�ӿ���̨��ȡ�û�������ַ����� */
	
	public static String readStringFromSystemIn(String message){
		
			System.out.println("��������������");
			
			return message;
		}

}
