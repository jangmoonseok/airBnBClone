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

/**
 * Servlet implementation class RemoveFavorite
 */
@WebServlet("/removeFavorite.do")
public class RemoveFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mem_id = request.getParameter("mem_id");
		String prod_id = request.getParameter("prod_id");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("prod_id", prod_id);
		
		IReservationService service = ReservationServiceImpl.getInstance();
		int result = service.removeFavor(map);
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.print("찜 목록에서 삭제되었습니다.");
		}else {
			out.print("찜 목록에서 삭제를 실패했습니다.");
		}
	}

}
