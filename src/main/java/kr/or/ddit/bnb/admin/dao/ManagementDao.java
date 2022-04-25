package kr.or.ddit.bnb.admin.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.vo.BuyerVO;
import kr.or.ddit.bnb.admin.vo.HostVO;
import kr.or.ddit.bnb.admin.vo.PickBuyerVO;
import kr.or.ddit.bnb.admin.vo.PickHostVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;

public class ManagementDao implements IManagementDao{
	
	private static ManagementDao dao;
	private ManagementDao() { }
	
	public static ManagementDao getInstance() {
		if(dao==null) dao = new ManagementDao();
		return dao;
	}

	@Override
	public List<HostVO> getHostList(SqlMapClient smc) throws SQLException {
		List<HostVO> host = smc.queryForList("manage.getHostList");
		return host;
	}


	@Override
	public List<PickHostVO> getHost(SqlMapClient smc, String host_id) throws SQLException {
		List<PickHostVO> host_info = smc.queryForList("manage.getHost", host_id);
		return host_info;
	}

	
	@Override
	public List<BuyerVO> getBuyerList(SqlMapClient smc) throws SQLException {
		List<BuyerVO> buyer = smc.queryForList("manage.getBuyerList");
		return buyer;
	}


	@Override
	public List<PickBuyerVO> getbuyer(SqlMapClient smc, String mem_id) throws SQLException {
		List<PickBuyerVO> buyer_info = smc.queryForList("manage.getbuyer" ,mem_id);
		return buyer_info;
		
	}

	@Override
	public List<HostVO> getAllHostList(SqlMapClient smc) throws SQLException {
		return smc.queryForList("manage.getAllHostList");
	}

	@Override
	public List<ProdVO> getHostProd(SqlMapClient smc, String host_id) throws SQLException {
		return smc.queryForList("manage.getHostProd", host_id);
	}

	@Override
	public String adminLogin(SqlMapClient smc, Map<String, String> admin) throws SQLException {
		return (String) smc.queryForObject("manage.adminLogin", admin);
	}

	
	
	

}
