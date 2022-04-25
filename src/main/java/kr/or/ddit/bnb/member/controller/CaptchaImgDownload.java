package kr.or.ddit.bnb.member.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaImgDownload
 */
@WebServlet("/CaptchaImgDownload.do")
public class CaptchaImgDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fileName = request.getParameter("filename");
		
		String downLoadPath = "d:/d_other/captchaImg";
		String filePath = downLoadPath + File.separator + fileName;
		
		File file = new File(filePath);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		if(file.exists()) {
			try {
				bos = new BufferedOutputStream(response.getOutputStream());
				bis = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while( (len = bis.read(temp)) > 0) {
					bos.write(temp,0,len);
				}
				
				bos.flush();
			} catch (IOException e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bos != null) try {bos.close();} catch(IOException e) {}
				if(bis != null) try {bis.close();} catch(IOException e) {}
			}
		}
		
	}

}
