package kr.or.ddit.bnb.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;
import kr.or.ddit.bnb.member.vo.QuestionVO;

public interface IQnADao {
	
		//회원용 게시판 작성
		public int insertQuestion(SqlMapClient smc, QuestionVO qnaVo) throws SQLException;
		
		//게시판 상세조회
		public QuestionVO SeeQuestion(SqlMapClient smc, QuestionVO qnaVo) throws SQLException;
		
		public QNA_ANSVO SeeAns(SqlMapClient smc, QNA_ANSVO ansVo) throws SQLException;
		
		//회원용 게시판 조회
		public List<QuestionVO> MemQuestionList(SqlMapClient smc) throws SQLException;
		
		public List<QuestionVO> QuestionCate(SqlMapClient smc, String cate) throws SQLException;
		
}
