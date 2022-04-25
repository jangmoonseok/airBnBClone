package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;

/**
 * Servlet implementation class ProdSearch
 */
@WebServlet("/prodSearch.do")
public class ProdSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		Map<String, Object> prodMap = new HashMap<String, Object>();
		
		Map<String, String[]> rqMap = request.getParameterMap();
		
		for(String i : rqMap.keySet()) {
			for(String j : rqMap.get(i)) {
				prodMap.put(i, j);
			}
		}

		
		ReservationServiceImpl service = ReservationServiceImpl.getInstance();
		
		List<ProdVO> prodList = service.filter(prodMap);
		
		
		Gson gson = new Gson();
		String result = gson.toJson(prodList);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

	

}
