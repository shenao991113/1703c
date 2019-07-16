package com.bw.Utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtils {
	
	/*批量关闭流，参数能传无限个,例如传入FileInputStream对象、JDBC中Connection对象都可以关闭。*/
	
	public static void closeAll(Closeable... closeables) throws Exception {
			
			FileInputStream inputStream = new FileInputStream("");
			
			inputStream.close();
		}
	
	/*拷贝流，将InputStream流拷到OutputStream，可以用于快速读与文件、上传下载，为了提高性能，需要使用缓冲。*/
	
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
		
			FileInputStream inputStream = new FileInputStream("");
			
			FileOutputStream outputStream = new FileOutputStream("");
			
			
		}
	
	
	/*传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，要求方法内部调用上面第2个方法拷贝流，结束后第1个方法关闭流*/
	
	public static String readTextFile(InputStream src) throws IOException{
			
		
			return null;
		}
	
	/*从控制台读取用户输入的字符串。 */
	
	public static String readStringFromSystemIn(String message){
		
			System.out.println("请输出你的姓名：");
			
			return message;
		}

}
