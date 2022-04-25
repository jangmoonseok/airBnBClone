package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;

/**
 * Servlet implementation class AutoSearch
 */
@WebServlet("/autoSearch.do")
public class AutoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String addr = request.getParameter("addr");
		
		IReservationService service = ReservationServiceImpl.getInstance();
		
		List<ProdVO> result = service.locationReturn(addr);
		
		Gson gson = new Gson();
		
		String list = gson.toJson(result);
		
		PrintWriter out = response.getWriter();
		
		out.print(list);
		out.flush();
	}

}
