package kr.or.ddit.bnb.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.PickBuyerVO;
import kr.or.ddit.bnb.admin.vo.QNAVO;
import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;


public interface IQnAansDao {
	

	//질문 답변
	public int insertAnswer(SqlMapClient smc, QNA_ANSVO answerVO) throws SQLException;
	
	//질문 삭제//
	public int deleteQuestion(SqlMapClient smc, String qna_id) throws SQLException;
	
	//질문 삭제
	public int deleteAns(SqlMapClient smc, String qna_id) throws SQLException;

	//회원용 게시판 작성
	public int insertQuestion(SqlMapClient smc, QNAVO qnaVo) throws SQLException;
	
	//게시판 상세조회
	public List<QNA_ANSVO> SeeQuestion(SqlMapClient smc, String qna_id) throws SQLException;
	
	//회원용 게시판 조회
	List<QNAVO> MemQuestionList(SqlMapClient smc) throws SQLException;
	
	//등록된 질문조회//
	List<QNAVO> QuestionList(SqlMapClient smc) throws SQLException;

	

	

	
	

}
