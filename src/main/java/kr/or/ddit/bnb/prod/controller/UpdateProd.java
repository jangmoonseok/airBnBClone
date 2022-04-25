package kr.or.ddit.bnb.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.prod.service.IProdService;
import kr.or.ddit.bnb.prod.service.ProdServiceImpl;
import kr.or.ddit.bnb.prod.vo.ProdVO;

/**
 * Servlet implementation class UpdateProd
 */
@WebServlet("/UpdateProd.do")
public class UpdateProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();		
		
		String prodId=request.getParameter("id");
		
		IProdService service=ProdServiceImpl.getInstance();
		ProdVO prodVo=new ProdVO();
		prodVo.setProd_id(prodId);
		
		int cnt=service.updateProd(prodVo);
		
		if(cnt>0) {
			Gson gson = new Gson();
			String newProdremove = gson.toJson(prodVo);
			out.print(newProdremove);
		}
		
	}

}
