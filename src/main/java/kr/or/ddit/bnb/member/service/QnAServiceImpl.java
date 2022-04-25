package kr.or.ddit.bnb.member.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.QNA_ANSVO;
import kr.or.ddit.bnb.member.dao.IQnADao;
import kr.or.ddit.bnb.member.dao.QnADaoImpl;
import kr.or.ddit.bnb.member.vo.QuestionVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class QnAServiceImpl implements IQnAService{
	
	private IQnADao dao;
	private SqlMapClient smc;
	
	private static QnAServiceImpl service;
	
	public QnAServiceImpl() {
		dao = QnADaoImpl.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}
	
	public static QnAServiceImpl getInstance() {
		if(service==null) service = new QnAServiceImpl();
		return service;
	}

	@Override
	public List<QuestionVO> MemQuestionList() {
		List<QuestionVO> QuestionList = null;
		try {
			QuestionList = dao.MemQuestionList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return QuestionList;
	}

	@Override
	public int insertQuestion(QuestionVO qnaVo) {
		int Question = 0;
		try {
			Question = dao.insertQuestion(smc, qnaVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Question;
	}

	@Override
	public QuestionVO SeeQuestion(QuestionVO qnaVo) {
		QuestionVO qna = null;
		try {
			qna = dao.SeeQuestion(smc, qnaVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qna;
	}

	@Override
	public List<QuestionVO> QuestionCate(String cate) {
		List<QuestionVO> QuestionList = null;
		try {
			QuestionList = dao.QuestionCate(smc, cate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return QuestionList;
	}

	@Override
	public QNA_ANSVO SeeAns(QNA_ANSVO ansVo) {
		QNA_ANSVO ans = null;
		try {
			ans = dao.SeeAns(smc, ansVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}


}
