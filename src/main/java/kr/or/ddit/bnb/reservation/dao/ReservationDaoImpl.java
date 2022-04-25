package kr.or.ddit.bnb.reservation.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.member.vo.FavorListVO;
import kr.or.ddit.bnb.prod.vo.ConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.bnb.reservation.vo.PaymentVO;
import kr.or.ddit.bnb.reservation.vo.ReservationDetailVO;
import kr.or.ddit.bnb.reservation.vo.ReservationVO;
import kr.or.ddit.bnb.reservation.vo.SchedulVO;

public class ReservationDaoImpl implements IReservationDao{
	//싱글톤 패턴
	private static ReservationDaoImpl dao;
	
	private ReservationDaoImpl(){
	}
	
	public static ReservationDaoImpl getInstance(){
		if(dao == null) dao = new ReservationDaoImpl();
		return dao;
	}
	
	//검색 시작시 위치 자동완성반환
	@Override
	public List<ProdVO> locationReturn(SqlMapClient smc, String addr) throws SQLException {
		return smc.queryForList("reservation.locationReturn", addr);
	}

	//숙소목록 검색
	@Override
	public List<ProdVO> searchProd(SqlMapClient smc, Map<String, Object> map) throws SQLException {
		return smc.queryForList("reservation.searchProd", map);
	}

	//목록에서 필터링
	@Override
	public List<ProdVO> filter(SqlMapClient smc, Map<String, Object> map) throws SQLException {
		return smc.queryForList("reservation.filter", map);
	}

	//이미지 
	@Override
	public List<String> getImg(SqlMapClient smc, String prod_id) throws SQLException {
		return smc.queryForList("reservation.getImg", prod_id);
		
	}
	
	//찜 목록 추가
	@Override
	public int addFavor(SqlMapClient smc, FavorListVO favorVO) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("reservation.addFavor", favorVO);
		if(obj==null) cnt = 1;
		
		return cnt;
	}
	
	//별점 평균 구하기
	@Override
	public double getStar(SqlMapClient smc, String prod_id) throws SQLException {
		return (double) smc.queryForObject("reservation.getStar", prod_id);
	}

	//편의시설 구하기
	@Override
	public List<ConvenVO> getConven(SqlMapClient smc, String prod_id) throws SQLException {
		// TODO Auto-generated method stub
		return smc.queryForList("reservation.getConven", prod_id);
	}
	
	//선택한 일정에 대한 금액 구하기
	@Override
	public int getSchePrice(SqlMapClient smc, Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return (int)smc.queryForObject("reservation.getSchePrice", map);
	}
		
	//스케쥴 insert
	@Override
	public String insertSchedule(SqlMapClient smc, SchedulVO scheVo) throws SQLException {
		String sche_id = null;
		sche_id = (String)smc.insert("reservation.insertSchedule", scheVo);

			
		return sche_id;
	}

	//예약 insert
	@Override
	public String insertReservation(SqlMapClient smc, ReservationVO reserVo) throws SQLException {
		String reser_id = null;
		reser_id = (String)smc.insert("reservation.insertReservation", reserVo);

			
		return reser_id;
	}

	//결제 insert
	@Override
	public int insertPayment(SqlMapClient smc, Map<String, String> paramap) throws SQLException {
		int cnt = 0;
		Object obj = smc.insert("reservation.insertPayment", paramap);
		if(obj==null) cnt = 1;
			
		return cnt;
	}

	//결제 insert 후 예약상태 update
	@Override
	public int updateReserv(SqlMapClient smc, String reser_id) throws SQLException {
		return smc.update("reservation.updateReserv", reser_id);
	}
	
	@Override
	public ProdVO getProdDetail(SqlMapClient smc, String prod_id) throws SQLException {
		return (ProdVO)smc.queryForObject("prod.getProdDetail", prod_id);
	}

	@Override
	public int checkSchedule(SqlMapClient smc, SchedulVO scheVo) throws SQLException {
		int cnt = (int)smc.queryForObject("reservation.checkSchedule",scheVo);
		return cnt;
		
	}

	@Override
	public List<SchedulVO> checkReserList(SqlMapClient smc, String prodId) throws SQLException {
		List<SchedulVO> checkReserList = (List<SchedulVO>) smc.queryForList("reservation.checkReserList", prodId);
		
		return checkReserList;
	}

	@Override
	public List<SchedulVO> alreadayUseProd(SqlMapClient smc, String prodId) throws SQLException {
		
      List<SchedulVO> alreadayUseProd = (List<SchedulVO>) smc.queryForList("reservation.alreadayUseProd", prodId);
     
		return alreadayUseProd;
	}

	@Override
	public int removeFavor(SqlMapClient smc, Map<String, String> map) throws SQLException {
		return smc.delete("reservation.removeFavor", map);
	}

	@Override
	public ReservationDetailVO getReserDetail(SqlMapClient smc, String reser_id) throws SQLException {
		ReservationDetailVO reserDetail = (ReservationDetailVO)smc.queryForObject("reservation.getReserDetail", reser_id);
		return reserDetail;
	}

}
