package kr.or.ddit.bnb.prod.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;

import com.google.gson.JsonObject;

import kr.or.ddit.bnb.prod.service.IProdService;
import kr.or.ddit.bnb.prod.service.ProdServiceImpl;
import kr.or.ddit.bnb.prod.vo.ProdConvenVO;
import kr.or.ddit.bnb.prod.vo.ProdVO;

/**
 * Servlet implementation class InsertProd
 */
@WebServlet("/insertProd.do")
public class InsertProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ProdVO prodVo = new ProdVO();
		Map<String, String[]> prodParaMap = request.getParameterMap();
		IProdService service = ProdServiceImpl.getInstance();
		
		try {
			BeanUtils.populate(prodVo, prodParaMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		service.insertProd(prodVo);
		

	}

}
