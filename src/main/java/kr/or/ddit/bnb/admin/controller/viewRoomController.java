//package kr.or.ddit.bnb.admin.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kr.or.ddit.bnb.admin.service.IviewRoomService;
//import kr.or.ddit.bnb.admin.service.viewRoomService;
//import kr.or.ddit.bnb.admin.vo.RoomVO;
//
//
////숙소 조회
//@WebServlet("/viewRoomController.do")
//public class viewRoomController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			request.setCharacterEncoding("utf-8");
//			IviewRoomService service = viewRoomService.getInstance();
//			
//			List<RoomVO> roomList = service.getRoomList();
//			request.setAttribute("roomList", roomList);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/room/AdminroomList.jsp");
//			rd.forward(request, response);
//			
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 
//		doGet(request, response);
//	}
//
//}
