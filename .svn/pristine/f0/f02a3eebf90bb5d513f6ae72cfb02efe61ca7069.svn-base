package kr.or.ddit.bnb.admin.controller;

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

@WebServlet("/guestList.do")
public class GuestList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		List<MemberVO> guestList = service.getAllMemberList();

		Gson gson = new Gson();
		String result = gson.toJson(guestList);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
