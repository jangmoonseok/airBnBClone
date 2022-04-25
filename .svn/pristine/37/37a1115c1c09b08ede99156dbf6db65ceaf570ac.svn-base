package kr.or.ddit.bnb.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.admin.service.IviewRoomService;
import kr.or.ddit.bnb.admin.service.viewRoomService;

@WebServlet("/permissionProd.do")
public class PermissionProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String prod_id = request.getParameter("prod_id");
		IviewRoomService service = viewRoomService.getInstance();
		
		int permissionRoom = service.permissionRoom(prod_id);
		
		Gson gson = new Gson();
		String result = gson.toJson(permissionRoom);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
