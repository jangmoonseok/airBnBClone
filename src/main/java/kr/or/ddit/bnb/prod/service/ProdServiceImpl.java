package kr.or.ddit.bnb.prod.service;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.bnb.prod.dao.ProdDaoImpl;
import kr.or.ddit.bnb.prod.vo.ProdConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdImgVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;
import kr.or.ddit.bnb.prod.vo.ReviewVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class ProdServiceImpl implements IProdService {

	private ProdDaoImpl dao;
	private static ProdServiceImpl service;
	private SqlMapClient smc;

	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
		smc = SqlMapClientFactory.getsqlMapClient();
	}

	public static ProdServiceImpl getInstance() {
		if (service == null)
			service = new ProdServiceImpl();

		return service;
	}

	@Override
	public int insertProd(ProdVO prodVo) {
		int cnt = 0;

		try {

			cnt = dao.insertProd(smc, prodVo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;

	}

	@Override
	public int insertProdImg(ProdImgVO prodimgVo) {
		int cnt = 0;

		try {
			cnt = dao.insertProdImg(smc, prodimgVo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertProdConven(ProdConvenVO prodconvenVo) {
		int cnt = 0;

		try {
			cnt = dao.insertProdConven(smc, prodconvenVo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int insertRev(ReviewVO revVo) {
		int cnt = 0;
		try {

			cnt = dao.insertRev(smc, revVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateRev(ReviewVO revVo) {
		int cnt = 0;
		try {

			cnt = dao.updateRev(smc, revVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteRev(String review_id) {
		int cnt = 0;
		try {

			cnt = dao.deleteRev(smc, review_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ReviewVO> selectRev(String prod_id) {
		List<ReviewVO> revList = null;

		try {
			revList = dao.selectRev(smc, prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return revList;
	}

	@Override
	public int updateProd(ProdVO prodVo) {
		int cnt = 0;

		try {
			cnt = dao.updateProd(smc, prodVo);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<ProdVO> HostProdList(String memId) {
		List<ProdVO> list = null;

		try {
			list = dao.HostProdList(smc, memId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
