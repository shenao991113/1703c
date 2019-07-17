package com.bw.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.junit.Test;

public class TestUtils {
	
	//关闭流
	@Test
	public void Test01() throws Exception{
		
		FileInputStream inputStream = new FileInputStream("D:/file.txt");
		
		StreamUtils.closeAll(inputStream);
		
	}
	
	//关闭流
	@Test
	public void Test02() throws Exception{
		
		FileInputStream inputStream = new FileInputStream("D:/file.txt");
		
		FileOutputStream outputStream = new FileOutputStream("inputStream");
		StreamUtils.copy(inputStream, outputStream, true, true);
	}
	
	//关闭流
	@Test
	public void Test03() throws Exception{
		
		FileInputStream inputStream = new FileInputStream("D:/file.txt");
		
		StreamUtils.closeAll(inputStream);
		
		FileOutputStream outputStream = new FileOutputStream("inputStream");
		StreamUtils.copy(inputStream, outputStream, true, true);
	}
}
