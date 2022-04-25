package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;
import kr.or.ddit.bnb.reservation.vo.ReservationVO;
import kr.or.ddit.bnb.reservation.vo.SchedulVO;

/**
 * Servlet implementation class PayReservation
 */
@WebServlet("/payReservation.do")
public class PayReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		IReservationService service = ReservationServiceImpl.getInstance();
		 String imp_uid = request.getParameter("imp_uid");
		 String prod_id = request.getParameter("prod_id");
		 String mem_id = request.getParameter("mem_id");
		 String check_in = request.getParameter("check_in");
		 String check_out = request.getParameter("check_out");
		 int sche_price = Integer.parseInt(request.getParameter("sche_price"));
		 String reser_req = request.getParameter("reser_req");
		 int reser_per = Integer.parseInt(request.getParameter("reser_per"));
		
		SchedulVO scheVo = new SchedulVO();
		scheVo.setProd_id(prod_id);
		scheVo.setMem_id(mem_id);
		scheVo.setCheck_in(check_in);
		scheVo.setCheck_out(check_out);
		scheVo.setSche_price(sche_price);
		
		ReservationVO reserVo = new ReservationVO();
		reserVo.setReser_per(reser_per);
		reserVo.setReser_price(sche_price);
		reserVo.setReser_req(reser_req);
		
		String reser_id = service.insertReservation(scheVo, reserVo);
		
		Map<String, String> payParaMap = new HashMap<String, String>();
		payParaMap.put("reser_id", reser_id);
		payParaMap.put("pay_id", imp_uid);
		
		int payResult = service.insertPayment(payParaMap);
		
		PrintWriter out = response.getWriter();
		
		if(payResult > 0) {
			out.print("결제가 완료되었습니다.");
		}else {
			out.print("결제 실패...");
		}
	}

}
