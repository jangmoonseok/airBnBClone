package kr.or.ddit.bnb.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.NoticeVO;
import kr.or.ddit.bnb.member.vo.ReserDetailVO;
import kr.or.ddit.bnb.member.vo.ReserListVO;

public class NoticeDaoImpl implements NoticeDao {
	private static NoticeDaoImpl noDao;
	
	private NoticeDaoImpl() {
		
	}
	
	public static NoticeDaoImpl getInstance(){
		if(noDao==null) noDao = new NoticeDaoImpl();
		
		return noDao;
	}
	
	@Override
	public int insertNo(SqlMapClient smc, NoticeVO notiVo) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("notice.insertNo", notiVo);
		if(obj==null) cnt = 1;
			
		return cnt;
	}

	@Override
	public int updateNo(SqlMapClient smc, NoticeVO notiVo) throws SQLException {
		int cnt = 0;
		
		cnt = smc.update("notice.updateNo", notiVo);
		
		return cnt;
	}

	@Override
	public List<NoticeVO> selectNo(SqlMapClient smc) throws SQLException {
		List<NoticeVO> noVo = smc.queryForList("notice.selectNo");
		
		return noVo;
	}

	@Override
	public NoticeVO selectDNo(SqlMapClient smc, String noti_id) throws SQLException {
		NoticeVO noVo = (NoticeVO) smc.queryForObject("notice.selectDNo", noti_id);
		
		return noVo;
	}

	@Override
	public int deleteNo(SqlMapClient smc, String noti_id) throws SQLException {
		int cnt = 0;
		
		cnt = smc.delete("notice.deleteNo", noti_id);
		
		return cnt;
	}

}
