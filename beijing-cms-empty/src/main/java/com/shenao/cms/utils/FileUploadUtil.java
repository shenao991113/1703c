package com.shenao.cms.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static String upload(HttpServletRequest request,MultipartFile file){
		//获取upload文件夹的路径
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		
		File uploadFile = new File(realPath);
		
		//如果upload文件夹不存在，就创建
		if(!uploadFile.exists()){
			uploadFile.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		String picture = "/upload/" + fileName;
		try {
			file.transferTo(new File(realPath + File.separator + fileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picture;
	}
}
