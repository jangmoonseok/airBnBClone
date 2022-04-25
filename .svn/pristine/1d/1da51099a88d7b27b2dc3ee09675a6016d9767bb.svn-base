package kr.or.ddit.bnb.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import kr.or.ddit.bnb.admin.service.IQnAansService;
import kr.or.ddit.bnb.admin.service.QnAansService;
import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;

@WebServlet("/qnaAnsInsert.do")
public class QnaAnsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		
		QNA_ANSVO vo = new QNA_ANSVO();
		
		String qna_id = request.getParameter("qna_id");
		String ans_con = request.getParameter("ans_con");
		
		vo.setQna_id(qna_id);
		vo.setAns_con(ans_con);
		
		IQnAansService service = QnAansService.getInstance();
		int answer = service.insertAnswer(vo);
		
		Gson gson = new Gson();
		String result = gson.toJson(answer);
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
