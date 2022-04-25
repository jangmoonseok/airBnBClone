package kr.or.ddit.bnb.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/logOut.do")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("user")){
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
	}

}
