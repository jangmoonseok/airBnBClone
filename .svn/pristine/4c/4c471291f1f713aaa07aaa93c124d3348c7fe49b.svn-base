package kr.or.ddit.bnb.payment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;

/**
 * Servlet implementation class PayTest
 */
@WebServlet("/payTest.do")
public class PayTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String imp_uid = request.getParameter("imp_uid");
		String merchant_uid = request.getParameter("merchant_uid");
		
//		String mem_id = request.getParameter("mem_id");
		String reser_id = request.getParameter("reser_id");
		
		Map<String, String> paramap = new HashMap<String, String>();
		
		paramap.put("pay_id", imp_uid);
//		paramap.put("mem_id", mem_id);
		paramap.put("reser_id", reser_id);
		
		IReservationService service = ReservationServiceImpl.getInstance();
		int insertPayment = service.insertPayment(paramap); //paramap을 넘겨주는 걸로~
		
		Gson gson = new Gson();
		
		String reser = gson.toJson(insertPayment);
		
		PrintWriter out = response.getWriter();
		out.print(reser);
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
