package kr.or.ddit.bnb.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.admin.service.IManagementService;
import kr.or.ddit.bnb.admin.service.ManagementService;

@WebServlet("/adminLogin.do")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String adminId = request.getParameter("id");
		String pass = request.getParameter("password");
		
		Cookie user = new Cookie("user", adminId);
		
		IManagementService service = ManagementService.getInstance();
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("admin_id", adminId);
		map.put("admin_pass", pass);
		
		String admin = service.adminLogin(map);
		
		PrintWriter out = response.getWriter();
		
		if(admin != null) {			
			response.addCookie(user);
			out.print("관리자 계정 로그인에 성공했습니다.");
		}else {
			out.print("비밀번호를 잘못 입력하였습니다.");
		}
	}

}

