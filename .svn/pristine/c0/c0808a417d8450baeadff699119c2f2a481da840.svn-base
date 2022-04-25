package kr.or.ddit.bnb.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;
import kr.or.ddit.bnb.member.vo.QuestionVO;

public interface IQnAService {
	//회원용 게시판 조회
	public List<QuestionVO> MemQuestionList();
	
	//회원용 게시판 작성
	public int insertQuestion(QuestionVO qnaVo);
		
	//게시판 상세보기
	public QuestionVO SeeQuestion(QuestionVO qnaVo);
	
	public List<QuestionVO> QuestionCate(String cate);
	
	public QNA_ANSVO SeeAns(QNA_ANSVO ansVo);
	
}
