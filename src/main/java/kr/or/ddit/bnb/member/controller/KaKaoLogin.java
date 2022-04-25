package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.MemberVO;

@WebServlet("/KaKaoLogin.do")
public class KaKaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String memid = request.getParameter("id");
		String memname = request.getParameter("name");
		String memmail = request.getParameter("mail");
		
		Cookie user = new Cookie("user", memid);
		IMemberService service = MemberServiceImpl.getInstance();
		
		String getmail = service.getEmail(memmail);
		
		MemberVO memVo = new MemberVO();	
		if(getmail == null) {
			memVo.setMem_id(memid);
			memVo.setMem_name(memname);
			memVo.setMem_email(memmail);
			
			int cnt = service.insertMember(memVo);
			
			if(cnt > 0) {
				response.addCookie(user);
				out.println(memname + "님 대덕비앤비에 오신 것을 환영합니다.");	
			} else {
				out.println("회원가입 실패");
			}	
			
			
		} else if(getmail != null){
			response.addCookie(user);
			out.println(memname + "님 대덕비앤비에 오신 것을 환영합니다.");		
		}
	}
}
