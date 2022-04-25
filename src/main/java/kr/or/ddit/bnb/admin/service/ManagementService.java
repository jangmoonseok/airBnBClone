package kr.or.ddit.bnb.admin.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.admin.dao.IManagementDao;
import kr.or.ddit.bnb.admin.dao.ManagementDao;
import kr.or.ddit.bnb.admin.vo.BuyerVO;
import kr.or.ddit.bnb.admin.vo.HostVO;
import kr.or.ddit.bnb.admin.vo.PickBuyerVO;
import kr.or.ddit.bnb.admin.vo.PickHostVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class ManagementService implements IManagementService{
	private IManagementDao dao;
	private SqlMapClient smc;
	
	private static ManagementService service1;
	
	private ManagementService() {
		dao = ManagementDao.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
		
	}
	public static ManagementService getInstance() {
		if(service1==null) service1 = new ManagementService();
		return service1;
	}

	@Override
	public List<HostVO> getHostList() {
		List<HostVO> hostList = null;
		try {
			hostList = dao.getHostList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hostList;
	}

	
	@Override
	public List<BuyerVO> getBuyerList() {
		List<BuyerVO> buyerList = null;
		try {
			buyerList = dao.getBuyerList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyerList;
	}
	

	@Override
	public List<PickBuyerVO> getbuyer(String mem_id) {
		List<PickBuyerVO> buyer_info =null;
		try {
			buyer_info = dao.getbuyer(smc, mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buyer_info;
	}
	@Override
	public List<PickHostVO> getHost(String host_id) {
		List<PickHostVO> host_info=null;
		try {
			host_info = dao.getHost(smc, host_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return host_info;
	}
	
	@Override
	public List<HostVO> getAllHostList() {
		List<HostVO> list = null;
		try {
			list = dao.getAllHostList(smc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<ProdVO> getHostProd(String host_id) {
		List<ProdVO> list = null;
		try {
			list = dao.getHostProd(smc, host_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public String adminLogin(Map<String, String> admin) {
		String admin_id ="";
		
		try {
			admin_id = dao.adminLogin(smc, admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admin_id;
	}


}