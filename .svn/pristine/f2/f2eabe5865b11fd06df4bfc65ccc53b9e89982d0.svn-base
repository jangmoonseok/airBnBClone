package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.admin.service.QnAansService;
import kr.or.ddit.bnb.admin.vo.QNAVO;
import kr.or.ddit.bnb.member.service.IQnAService;
import kr.or.ddit.bnb.member.service.QnAServiceImpl;
import kr.or.ddit.bnb.member.vo.QuestionVO;

@WebServlet("/QnAController.do")
public class QnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		String cate = request.getParameter("cate");
		
		IQnAService service = QnAServiceImpl.getInstance();
		List<QuestionVO> questionCate = service.QuestionCate(cate);

		Gson gson = new Gson();
		String result = gson.toJson(questionCate);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

}
