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

import kr.or.ddit.bnb.member.service.IQnAService;
import kr.or.ddit.bnb.member.service.QnAServiceImpl;
import kr.or.ddit.bnb.member.vo.QuestionVO;

@WebServlet("/QnaInsert.do")
public class QnaInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		response.setContentType("application/json; charset=utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String cate = request.getParameter("cate");
		String userId = request.getParameter("user");
		String title = request.getParameter("title");
		String con = request.getParameter("contest");
		
		IQnAService service = QnAServiceImpl.getInstance();
		QuestionVO quVo = new QuestionVO();
		quVo.setQna_cate(cate);
		quVo.setMem_id(userId);
		quVo.setQna_title(title);
		quVo.setQna_con(con);
		
		int cnt = service.insertQuestion(quVo);
		if(cnt > 0) {
			out.print("질문등록에 성공했습니다.");
		}else {
			out.print("질문등록에 실패했습니다.");
		}
		
		
	}
}
