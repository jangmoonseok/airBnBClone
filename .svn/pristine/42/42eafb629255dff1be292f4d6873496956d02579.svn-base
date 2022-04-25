package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bnb.admin.service.IQnAansService;
import kr.or.ddit.bnb.admin.service.QnAansService;

@WebServlet("/QnADelete.do")
public class QnADelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		String qnaID = request.getParameter("qnaId");

		IQnAansService service = QnAansService.getInstance();

		int cnt1 = service.deleteAns(qnaID);

		if (cnt1 > 0) {
			out.print("관리자 답변 삭제 성공");

			int cnt2 = service.deleteQuestion(qnaID);

			if (cnt2 > 0) {
				out.print("질문 삭제 성공");
			} else {
				out.print("질문 삭제 실패");
			}
		} else {
			out.print("관리자 답변 삭제 실패");
		}
	}

}
