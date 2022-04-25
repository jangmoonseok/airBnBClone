package kr.or.ddit.bnb.member.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.MemberVO;

/**
 * Servlet implementation class GetCaptchaImg
 */
@WebServlet("/register.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String key = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		getKey keyService = getKey.getInstance();
		
		key = keyService.getKeyStr();


			
		CaptchaImg imgService = CaptchaImg.getInstance(); 
		String img = imgService.imgFileName(key);
		  
		PrintWriter out = response.getWriter();
		  
		Gson gson = new Gson(); String result = gson.toJson(img);
		  
		out.print(result); 
		out.flush();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uname = request.getParameter("uname");
		String uid = request.getParameter("uid");
		String password = request.getParameter("password");
		String pwdCheck = request.getParameter("pwdCheck");
		String ubirth = request.getParameter("ubirth");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		String findPwd = request.getParameter("findPwd");
		String answer = request.getParameter("answer");
		
		MemberVO memVo = new MemberVO();
		PrintWriter out = response.getWriter();
	
		memVo.setMem_id(uid);
		memVo.setMem_name(uname);
		memVo.setMem_pass(password);
		memVo.setMem_birth(ubirth);
		memVo.setMem_addr(addr);
		memVo.setMem_ans(answer);
		memVo.setMem_hint(findPwd);
		memVo.setMem_tel(tel);
		memVo.setMem_email(email);
		
		String value = request.getParameter("imgAnswer");
		
		CaptchaResult resultService = CaptchaResult.getInstance();
		String resultString = resultService.result(key, value);
		String[] splitResult = resultString.split(",");
		String result = splitResult[0].substring(10, splitResult[0].length());
		
		if(result.equals("true")) {
			IMemberService service = MemberServiceImpl.getInstance();
			int insertMember = service.insertMember(memVo);
			if(insertMember > 0) {
				out.print("회원가입 성공!");
				
			}else {
				out.print("모든 내용을 입력해주세요.");
			}
		}else {
			out.print("이미지의 문자를 다시 입력해주세요.");
		}
		
	}
}