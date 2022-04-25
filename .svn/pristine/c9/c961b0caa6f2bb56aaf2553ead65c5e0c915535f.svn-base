package kr.or.ddit.bnb.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.admin.service.NoticeService;
import kr.or.ddit.bnb.admin.service.NoticeServiceImpl;

@WebServlet("/notiDelete.do")
public class NotiDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String noti_id = request.getParameter("noti_id");
		
//		NoticeVO vo = new NoticeVO();
//		vo.setNoti_id(noti_id);
		
		NoticeService service = NoticeServiceImpl.getInstance();
		
		int delete = service.deleteNo(noti_id);
		
		Gson gson = new Gson();
		String result = gson.toJson(delete);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
