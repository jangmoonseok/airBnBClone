package kr.or.ddit.bnb.reservation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.member.vo.FavorListVO;
import kr.or.ddit.bnb.reservation.serveice.IReservationService;
import kr.or.ddit.bnb.reservation.serveice.ReservationServiceImpl;

/**
 * Servlet implementation class AddFavorite
 */
@WebServlet("/addFavorite.do")
public class AddFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String prod_id = request.getParameter("prod_id");
		String mem_id = request.getParameter("mem_id");
		
		FavorListVO favorVo = new FavorListVO();
		favorVo.setProd_id(prod_id);
		favorVo.setMem_id(mem_id);
		
		IReservationService service = ReservationServiceImpl.getInstance();
		int result = service.addFavor(favorVo);
		
		PrintWriter out = response.getWriter();
		
		if(result > 0) {
			out.print("찜 목록에 추가되었습니다.");
		}else {
			out.print("찜 목록 추가 실패..");
		}
	}

}
