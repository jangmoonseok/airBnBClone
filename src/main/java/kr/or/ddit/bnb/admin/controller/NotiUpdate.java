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
import kr.or.ddit.bnb.admin.vo.NoticeVO;

@WebServlet("/notiUpdate.do")
public class NotiUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String noti_id = request.getParameter("noti_id");
		String noti_title = request.getParameter("noti_title");
		String noti_con = request.getParameter("noti_con");
		
		NoticeVO vo = new NoticeVO();
		vo.setNoti_id(noti_id);
		vo.setNoti_title(noti_title);
		vo.setNoti_con(noti_con);
		
		NoticeService service = NoticeServiceImpl.getInstance();
		
		int update = service.insertNo(vo);
		
		Gson gson = new Gson();
		String result = gson.toJson(update);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
