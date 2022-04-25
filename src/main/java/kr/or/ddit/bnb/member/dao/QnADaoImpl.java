package kr.or.ddit.bnb.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;
import kr.or.ddit.bnb.member.vo.QuestionVO;

public class QnADaoImpl implements IQnADao{
	
	private static QnADaoImpl dao;
	private QnADaoImpl() { }
	
	public static QnADaoImpl getInstance() {
		if(dao==null) dao = new QnADaoImpl();
		return dao;
	}

	@Override
	public int insertQuestion(SqlMapClient smc, QuestionVO qnaVo) throws SQLException {
		int Question = 0;
		Object obj = smc.insert("QNA.Question",qnaVo);
		if(obj==null) Question =1;
		return Question;
	}

	@Override
	public QuestionVO SeeQuestion(SqlMapClient smc, QuestionVO qnaVo) throws SQLException {
		QuestionVO question_info = (QuestionVO)smc.queryForObject("QNA.SeeQuestionMem", qnaVo);
		//System.out.println(question_info);
		return question_info;
	}

	
	
	@Override
	public List<QuestionVO> MemQuestionList(SqlMapClient smc) throws SQLException {
		List<QuestionVO> QuestionList = smc.queryForList("QNA.QuestionListmem");
		return QuestionList;
	}

	
	
	@Override
	public List<QuestionVO> QuestionCate(SqlMapClient smc, String cate) throws SQLException {
		List<QuestionVO> QuestionList = smc.queryForList("QNA.QuestionCate", cate);
		return QuestionList;
	}

	@Override
	public QNA_ANSVO SeeAns(SqlMapClient smc, QNA_ANSVO ansVo) throws SQLException {
		QNA_ANSVO ans = (QNA_ANSVO) smc.queryForObject("QNA.SeeAns", ansVo);

		return ans;
	}




}
