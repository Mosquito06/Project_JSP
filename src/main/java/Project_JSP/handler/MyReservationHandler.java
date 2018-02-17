package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class MyReservationHandler implements CommandHandler {
	private static final String MYPAGE_VIEW = "/WEB-INF/view/mypage/myReservation.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return MYPAGE_VIEW;
		
	}

}
