package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;
import kr.or.ddit.bnb.reservation.vo.SchedulVO;

/**
 * Servlet implementation class AlreadyUseProd
 */
@WebServlet("/AlreadyUseProd.do")
public class AlreadyUseProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		IReservationService service=ReservationServiceImpl.getInstance();
		String[] prodIdList = request.getParameterValues("prodId[]");
		List<SchedulVO> useUserList = new ArrayList<SchedulVO>();
		for(String x : prodIdList) {
			List<SchedulVO> produseUser = service.alreadayUseProd(x);
			for(SchedulVO vo : produseUser) {
				useUserList.add(vo);
			}
		}
		
		Gson gson=new Gson();
		String result=gson.toJson(useUserList);
		
		 PrintWriter out = response.getWriter();
			
			out.print(result);
			out.flush();
		
	}

}
