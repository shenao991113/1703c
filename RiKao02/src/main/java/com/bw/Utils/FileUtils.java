package com.bw.Utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	/***
	 * 上传方法
	 * @param photo
	 * @param session
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String upload (MultipartFile photo) throws IllegalStateException, IOException {

		String filePath = "";
		String originalFilename = "";
		String uuid = "";
		if(!photo.isEmpty()) {
			//服务器上真实的路径
			//String realPath = session.getServletContext().getRealPath("upload/");
			String realPath = "G:\\";
			//文件的原始名称
			originalFilename = photo.getOriginalFilename();
			//为了保证文件名的唯一性
			uuid = UUID.randomUUID().toString().replace("-", "");
			if(originalFilename.endsWith("png")||originalFilename.endsWith("jpg")) {
				File file = new File(realPath+"/"+uuid+originalFilename);
				photo.transferTo(file);
			}
		}
		//文件在本地磁盘中
		filePath = "G:\\"+uuid+originalFilename;

		return filePath;
	}
	/***
	 * 查看本地磁盘的图片
	 * @param path
	 * @param request
	 * @param response
	 */
	public static  void lookImg(String path,HttpServletRequest request,
			HttpServletResponse response) {
		FileInputStream fis = null;
		OutputStream os = null;
		try {
			fis = new FileInputStream(path);
			os = response.getOutputStream();
			int count = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((count = fis.read(buffer)) != -1) {
				os.write(buffer, 0, count);
				os.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			fis.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 下载方法
	 * @param filepath
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public static String download(String filepath,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception{

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		OutputStream fos = null;
		InputStream fis = null;

		try {
			// 如果是从服务器上取就用这个获得系统的绝对路径方法。
			//String filepath = request.getRealPath(filepatha);//方法过时了
			//String filepathall = request.getSession().getServletContext().getRealPath(filepath);

			File uploadFile = new File(filepath);

			fis = new FileInputStream(uploadFile);
			bis = new BufferedInputStream(fis);
			fos = response.getOutputStream();
			bos = new BufferedOutputStream(fos);

			//得到文件名
			String filename = filepath.substring(filepath.lastIndexOf("\\")+1);

			// 这个就就是弹出下载对话框的关键代码
			response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));

			int bytesRead = 0;
			// 用输出流去写，缓冲输入输出流
			byte[] buffer = new byte[8192];
			while ((bytesRead = bis.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.flush();
				}
				if (fis != null) {
					fis.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
