package kr.or.ddit.bnb.reservation.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.mapping.sql.Sql;

import kr.or.ddit.bnb.member.vo.FavorListVO;
import kr.or.ddit.bnb.prod.vo.ConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.bnb.reservation.vo.PaymentVO;
import kr.or.ddit.bnb.reservation.vo.ReservationDetailVO;
import kr.or.ddit.bnb.reservation.vo.ReservationVO;
import kr.or.ddit.bnb.reservation.vo.SchedulVO;


public interface IReservationDao {
	/**
	 * 
	 * @param smc
	 * @param addr 
	 * @return
	 * @throws SQLException
	 */
	public List<ProdVO> locationReturn(SqlMapClient smc, String addr) throws SQLException;
	
	/**
	 * 
	 * @param smc
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public List<ProdVO> searchProd(SqlMapClient smc, Map<String, Object> map) throws SQLException;
	
	/**
	 * 
	 * @param smc
	 * @param map
	 * @return
	 * @throws SQLException
	 */
	public List<ProdVO> filter(SqlMapClient smc, Map<String, Object> map) throws SQLException;
	
	/**
	 * 
	 * @param smc
	 * @param prod_id
	 * @return
	 * @throws SQLException
	 */
	public List<String> getImg(SqlMapClient smc, String prod_id) throws SQLException;
	
	/**
	 * 
	 * @param smc
	 * @param favorVO
	 * @return
	 * @throws SQLException
	 */
	public int addFavor(SqlMapClient smc, FavorListVO favorVO) throws SQLException;
	
	/**
	 * 
	 * @param smc
	 * @param prod_id
	 * @return
	 * @throws SQLException
	 */
	public double getStar(SqlMapClient smc, String prod_id) throws SQLException;
	
	/**
	 * 
	 * @param smc
	 * @param prod_id
	 * @return
	 * @throws SQLException
	 */
	public List<ConvenVO> getConven(SqlMapClient smc, String prod_id) throws SQLException;
	
	public String insertSchedule(SqlMapClient smc, SchedulVO scheVo) throws SQLException;

	public String insertReservation(SqlMapClient smc, ReservationVO reserVo) throws SQLException;
	
	public int getSchePrice(SqlMapClient smc, Map<String, Object> map) throws SQLException;
	
	public int insertPayment(SqlMapClient smc, Map<String, String> paramap) throws SQLException;
	
	public int updateReserv(SqlMapClient smc, String reser_id) throws SQLException;
	
	//상품상세정보
	public ProdVO getProdDetail(SqlMapClient smc, String prod_id)throws SQLException;
	
  	//날짜겹치는지 확인
	public int checkSchedule(SqlMapClient smc,SchedulVO scheVo)throws SQLException;
	
	//예약신청한 고객
	public List<SchedulVO>checkReserList(SqlMapClient smc,String prodId)throws SQLException;
	
	//이미사용중인 고객
	public List<SchedulVO>alreadayUseProd(SqlMapClient smc,String prodId)throws SQLException;
	
	//찜 목록 삭제
	public int removeFavor(SqlMapClient smc, Map<String, String> map) throws SQLException;
	
	//예약 상세내역 조회
	public ReservationDetailVO getReserDetail(SqlMapClient smc, String reser_id) throws SQLException;
}
