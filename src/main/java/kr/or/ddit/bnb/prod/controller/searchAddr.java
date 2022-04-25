package kr.or.ddit.bnb.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchAddr
 */
@WebServlet("/searchAddr.do")
public class searchAddr extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String addr = request.getParameter("addr");
		
		searchAddrService service = searchAddrService.getInstance();
		
		String searchInfo = service.getSearchInfo(addr);
		
		PrintWriter out = response.getWriter();
		
		out.print(searchInfo);
		out.flush();
	}



}
