package kr.or.ddit.bnb.admin.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.dao.NoticeDaoImpl;
import kr.or.ddit.bnb.admin.vo.NoticeVO;
import kr.or.ddit.bnb.member.vo.FavorListVO;
import kr.or.ddit.bnb.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDaoImpl dao;  
	private static NoticeServiceImpl noService;
	private SqlMapClient smc;

	public NoticeServiceImpl() {
		dao = NoticeDaoImpl.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	} 
	
	public static NoticeService getInstance() {
		if(noService==null) noService = new NoticeServiceImpl();
		return noService;
	}
	
	@Override
	public int insertNo(NoticeVO notiVo) {
		int cnt = 0;
		try {
			
			cnt = dao.insertNo(smc, notiVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateNo(NoticeVO notiVo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateNo(smc, notiVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<NoticeVO> selectNo() {
		List<NoticeVO> noVo = new ArrayList<NoticeVO>();
		
		try {
			noVo = dao.selectNo(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noVo;
	}

	@Override
	public NoticeVO selectDNo(String noti_id) {
		NoticeVO noVO = null;
		
		try {
			noVO = dao.selectDNo(smc, noti_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return noVO;
	}

	@Override
	public int deleteNo(String noti_id) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteNo(smc, noti_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

}
