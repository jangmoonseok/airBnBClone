package kr.or.ddit.bnb.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.PickRoomVO;
import kr.or.ddit.bnb.admin.vo.RoomVO;
import kr.or.ddit.bnb.prod.vo.ConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;

public interface IviewRoomDao {

	//숙소관리-숙소조회-숙소삭제
	
		//숙소삭제
		public int deleteRoom(SqlMapClient smc, String prod_id) throws SQLException;
		
		//숙소조회
		public List<RoomVO> getRoomList(SqlMapClient smc) throws SQLException;
		
		//숙소 상세보기
		public List<PickRoomVO> room(SqlMapClient smc, String prod_id) throws SQLException;

		//등록요청된 숙소 조회
		public List<ProdVO> waitingRoomList(SqlMapClient smc) throws SQLException;
		
		//등록 승인
		public int permissionRoom(SqlMapClient smc, String prod_id) throws SQLException;
		
		//등록 거절
		public int denyRoom(SqlMapClient smc ,String prod_id) throws SQLException;

		public List<ConvenVO> getConven(SqlMapClient smc, String prod_id) throws SQLException;

		public List<String> getImg(SqlMapClient smc, String prod_id) throws SQLException;
		
		//이름검색
		public List<ProdVO> search(SqlMapClient smc, String prod_name) throws SQLException;
		

}
