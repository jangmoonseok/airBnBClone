package kr.or.ddit.bnb.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.NoticeVO;

public interface NoticeDao {
	// 등록
	public int insertNo(SqlMapClient smc, NoticeVO notiVo) throws SQLException;

	// 수정
	public int updateNo(SqlMapClient smc, NoticeVO notiVo) throws SQLException;

	// 목록조회
	public List<NoticeVO> selectNo(SqlMapClient smc) throws SQLException;

	// 상세조회
	public NoticeVO selectDNo(SqlMapClient smc, String noti_id) throws SQLException;

	// 삭제
	public int deleteNo(SqlMapClient smc, String noti_id) throws SQLException;
}
