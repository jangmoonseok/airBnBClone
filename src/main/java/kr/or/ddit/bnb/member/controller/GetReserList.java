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
import kr.or.ddit.bnb.member.vo.FavorListVO;
import kr.or.ddit.bnb.member.vo.ReserListVO;

/**
 * Servlet implementation class GetMyPage
 */
@WebServlet("/getReserList.do")
public class GetReserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String memId = request.getParameter("memId");
		
		IMemberService service = MemberServiceImpl.getInstance();
		List<ReserListVO> reserList = service.reserList(memId);
		
		Gson gson = new Gson();
		
		String reser = gson.toJson(reserList);
		
		
		
		PrintWriter out = response.getWriter();
		out.print(reser);
		out.flush();
	}

}
