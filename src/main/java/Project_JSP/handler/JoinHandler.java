package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class JoinHandler implements CommandHandler {
	private static final String JOIN_VIEW = "/WEB-INF/view/join/joinForm.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return JOIN_VIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			return null;
		}
		return null;
	}

}
