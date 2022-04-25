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

import com.google.gson.Gson;

import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;

/**
 * Servlet implementation class GetProdDetail
 */
@WebServlet("/getProdDetail.do")
public class GetProdDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; utf-8");
		request.setCharacterEncoding("utf-8");
		
		IReservationService service = ReservationServiceImpl.getInstance();
		
		String prod_id = request.getParameter("prod_id");
		String check_in = request.getParameter("check_in");
		String check_out = request.getParameter("check_out");
		
		int schePrice = 0;
		if(!check_in.equals("") && !check_out.equals("")) {
			Map<String, Object> paraMap = new HashMap<String, Object>();
			paraMap.put("prod_id", prod_id);
			paraMap.put("check_in", check_in);
			paraMap.put("check_out", check_out);
			schePrice = service.getSchePrice(paraMap);
		}
		
		ProdVO prodDetail = service.getProdDetail(prod_id);
		double star = service.getStar(prod_id);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("schePrice", schePrice);
		resultMap.put("prodDetail", prodDetail);
		resultMap.put("star", Math.round(star * 10) / 10);
		
		Gson gson = new Gson();
		String detail = gson.toJson(resultMap);
		
		PrintWriter out = response.getWriter();
		
		out.print(detail);
		out.flush();
	}

}
