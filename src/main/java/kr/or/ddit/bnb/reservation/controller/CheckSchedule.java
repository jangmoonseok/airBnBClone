package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;
import kr.or.ddit.bnb.reservation.vo.SchedulVO;

/**
 * Servlet implementation class CheckSchedule
 */
@WebServlet("/checkSchedule.do")
public class CheckSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		IReservationService service = ReservationServiceImpl.getInstance();
		
		String prod_id = request.getParameter("prod_id");
		String checkIn = request.getParameter("check_in");
		String checkOut = request.getParameter("check_out");		
		


		SchedulVO scheVo = new SchedulVO();
		scheVo.setCheck_out(checkOut);
		scheVo.setCheck_in(checkIn);
		scheVo.setProd_id(prod_id);
		
		int result = service.checkSchedule(scheVo);
		if(result > 0) {
			out.print("false");
		}else {
			out.print("success");
		}
		out.flush();
	}

}
