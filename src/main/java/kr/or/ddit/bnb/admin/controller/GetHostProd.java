package kr.or.ddit.bnb.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.admin.service.IManagementService;
import kr.or.ddit.bnb.admin.service.ManagementService;
import kr.or.ddit.bnb.prod.vo.ProdVO;

@WebServlet("/getHostProd.do")
public class GetHostProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		String host_id = request.getParameter("host_id");
		
		IManagementService service = ManagementService.getInstance();
		
		List<ProdVO> list = service.getHostProd(host_id);
		
		Gson gson = new Gson();
		String result = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
