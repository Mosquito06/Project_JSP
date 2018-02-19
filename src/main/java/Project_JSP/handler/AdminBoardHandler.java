package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class AdminBoardHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		return "/WEB-INF/view/adminpage/adminpage_board.jsp";
	}

}
