package kr.or.ddit.bnb.admin.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.PickRoomVO;
import kr.or.ddit.bnb.admin.vo.RoomVO;
import kr.or.ddit.bnb.prod.vo.ConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;

public class viewRoomDao implements IviewRoomDao{

	private static viewRoomDao dao;
	private viewRoomDao() { }
	
	public static viewRoomDao getInstance() {
		if(dao==null) dao = new viewRoomDao();
		return dao;
	}
	
	@Override
	public int deleteRoom(SqlMapClient smc,  String prod_id) throws SQLException {
		//숙소조회 -> 숙소삭제
		return smc.delete("room.deleteRoom", prod_id);
	}

	@Override
	public List<RoomVO> getRoomList(SqlMapClient smc) throws SQLException {
		//숙소조회(리스트)
		List<RoomVO> room = smc.queryForList("room.getroomList");
		return room;
	}

	@Override
	public List<ProdVO> waitingRoomList(SqlMapClient smc) throws SQLException {
		List<ProdVO> waitingroom = smc.queryForList("room.waitingRoomList");
		return waitingroom;
	}

	@Override
	public int permissionRoom(SqlMapClient smc, String prod_id) throws SQLException {
		int ok=0;
		Object obj = smc.insert("room.permissionRoom", prod_id);
		if(obj==null) ok =1;
		return ok;
		
	}

	@Override
	public int denyRoom(SqlMapClient smc, String prod_id) throws SQLException {
		
		return smc.delete("room.denyRoom",prod_id);
	}

	@Override
	public List<PickRoomVO> room(SqlMapClient smc,String prod_id) throws SQLException {
		List<PickRoomVO> room = smc.queryForList("room.room");
		return room;
	}

	//편의시설 구하기
	@Override
	public List<ConvenVO> getConven(SqlMapClient smc, String prod_id) throws SQLException {
		// TODO Auto-generated method stub
		return smc.queryForList("reservation.getConven", prod_id);
	}
	
	//이미지 
	@Override
	public List<String> getImg(SqlMapClient smc, String prod_id) throws SQLException {
		return smc.queryForList("reservation.getImg", prod_id);
		
	}

	@Override
	public List<ProdVO> search(SqlMapClient smc, String prod_name) throws SQLException {
		return smc.queryForList("room.search", prod_name);
	}


}
