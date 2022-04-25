package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;
import kr.or.ddit.bnb.reservation.vo.ReservationDetailVO;

/**
 * Servlet implementation class GetReserDetail
 */
@WebServlet("/getReserDetail.do")
public class GetReserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String reser_id = request.getParameter("reser_id");
		
		IReservationService service = ReservationServiceImpl.getInstance();
		ReservationDetailVO reserDetail = service.getReserDetail(reser_id);
		Gson gson = new Gson();
		String result = gson.toJson(reserDetail);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

}
