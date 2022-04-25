package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.bnb.member.service.IMemberService;
import kr.or.ddit.bnb.member.service.MemberServiceImpl;
import kr.or.ddit.bnb.member.vo.MemberVO;

@WebServlet("/findPass.do")
public class findPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String memId = request.getParameter("id");
		String memName = request.getParameter("name");
		String memHint = request.getParameter("hint");
		String memAns = request.getParameter("ans");
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO memVo = service.getMemberHint(memId);
		
		MemberVO memVo2 = new MemberVO();
		
		if(memVo != null) {
			if(memVo.getMem_name().equals(memName)) {
				if(memVo.getMem_hint().equals(memHint)) {
					if(memAns.equals(memVo.getMem_ans())) {
						memVo2.setMem_id(memId);
						memVo2.setMem_name(memName);
						memVo2.setMem_hint(memHint);
						memVo2.setMem_ans(memAns);
						
						MemberVO meVo3 = service.findPass(memVo2);
						
						if(meVo3 != null) {
							out.print("회원정보가 확인됐습니다.");
						}else {
							out.print("비밀번호 찾기 오류");
						}
						
					}else {
						out.print("힌트정답을 다시 입력하세요.");
					}
				} else {
					out.print("힌트질문을 다시 선택하세요.");
				}		
			}else {
				out.print("회원 이름이 일치하지 않습니다.");
			}
			
		}else {
			out.print("입력한 아이디와 일치한 회원이 없습니다.");
		}
		
		out.flush();			
	}
}
