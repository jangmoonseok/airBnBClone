package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("id");
		String pass = request.getParameter("password");
		
		Cookie user = new Cookie("user", userId);
		IMemberService service = MemberServiceImpl.getInstance();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(pass);
		
		MemberVO member = service.getMember(memVo);
		PrintWriter out = response.getWriter();
		
		if(member != null) {			
			response.addCookie(user);
			out.print(member.getMem_name() + "님 대덕비앤비에 오신걸 환영합니다.");
		}else {
			out.print("아이디 또는 비밀번호를 잘못 입력하였습니다.");
		}
	}

}
