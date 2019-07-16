package com.bw.Utils;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtils {
	
	public static void closeAll(Closeable... closeables) throws Exception {
			
			FileInputStream inputStream = new FileInputStream("");
			
			inputStream.close();
		}
	
	
	public static void copy(InputStream src, OutputStream out, boolean isCloseInputStream, boolean isCloseOutputStream)  throws IOException{
		
			FileInputStream inputStream = new FileInputStream("");
			
			FileOutputStream outputStream = new FileOutputStream("");
			
			
		}
	
	public static String readTextFile(InputStream src) throws IOException{
			
		
			return null;
		}
	
	public static String readStringFromSystemIn(String message){
		
			System.out.println("ÇëÊä³öÄãµÄÐÕÃû£º");
			
			return message;
		}

}
