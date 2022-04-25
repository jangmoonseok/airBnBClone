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

@WebServlet("/myInfo.do")
public class myInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String memId = request.getParameter("memId");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO memvo2 = service.getMemberList(memId);
		
		System.out.println(memvo2);
		Gson gson = new Gson();
		String result = gson.toJson(memvo2);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

}
