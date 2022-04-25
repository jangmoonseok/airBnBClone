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

import kr.or.ddit.bnb.admin.service.NoticeServiceImpl;
import kr.or.ddit.bnb.admin.vo.NoticeVO;

@WebServlet("/NotiController.do")
public class NotiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		NoticeServiceImpl service = (NoticeServiceImpl) NoticeServiceImpl.getInstance();
		
		List<NoticeVO> notiList = service.selectNo();
		
		Gson gson = new Gson();
		String result = gson.toJson(notiList);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

}
