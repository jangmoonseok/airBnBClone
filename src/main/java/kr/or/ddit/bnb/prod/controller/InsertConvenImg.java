package kr.or.ddit.bnb.prod.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.prod.service.IProdService;
import kr.or.ddit.bnb.prod.service.ProdServiceImpl;
import kr.or.ddit.bnb.prod.vo.ProdConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdImgVO;

/**
 * Servlet implementation class InsertConvenImg
 */
@WebServlet("/insertConvenImg.do")
public class InsertConvenImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String[] convenPara = request.getParameterValues("convenPara[]");
		String[] imgPara = request.getParameterValues("imgPara[]");
		
		
		IProdService service = ProdServiceImpl.getInstance();
		
		for(String conven : convenPara) {
			ProdConvenVO convenVo = new ProdConvenVO();
			convenVo.setConven_name(conven);
			service.insertProdConven(convenVo);
		}
		
		for(String img : imgPara) {
			ProdImgVO imgVo = new ProdImgVO();
			imgVo.setImg_link("../image/" + img);
			service.insertProdImg(imgVo);
		}
	}

}
