package kr.or.ddit.bnb.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.prod.service.IProdService;
import kr.or.ddit.bnb.prod.service.ProdServiceImpl;
import kr.or.ddit.bnb.prod.vo.ReviewVO;

/**
 * Servlet implementation class GetReview
 */
@WebServlet("/getReview.do")
public class GetReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String prod_id = request.getParameter("prod_id");
		
		IProdService service = ProdServiceImpl.getInstance();
		List<ReviewVO> reviewList = service.selectRev(prod_id);
		
		Gson gson = new Gson();
		String result = gson.toJson(reviewList);
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
	}

}
