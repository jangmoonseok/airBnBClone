package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.MemberVO;

@WebServlet("/changeMem.do")
public class changeMem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String memId = request.getParameter("memId");
		String memPass = request.getParameter("pass");
		String memMail = request.getParameter("email");
		String memBirth = request.getParameter("birth");
		String memTel = request.getParameter("tel");
		String memAdd = request.getParameter("add");
		String memHint = request.getParameter("hint");
		String memAns = request.getParameter("ans");
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_email(memMail);
		memVo.setMem_birth(memBirth);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAdd);
		memVo.setMem_hint(memHint);
		memVo.setMem_ans(memAns);
		
		int cnt = service.updateMember(memVo);
		
		if(cnt > 0) {
			Gson gson = new Gson();
			String result = gson.toJson(memVo);
			out.print(result);
		}
	}
}
