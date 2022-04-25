package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.MemberVO;

@WebServlet("/findID.do")
public class findID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_name(name);
		memVo.setMem_tel(tel);
		
		IMemberService service = MemberServiceImpl.getInstance();
		String memId = service.findId(memVo);
		
		Gson gson = new Gson();
		String result = gson.toJson(memId);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

}
