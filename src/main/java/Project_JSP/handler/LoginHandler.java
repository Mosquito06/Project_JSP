package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class LoginHandler implements CommandHandler {
	private static final String LOGIN_VIEW = "/WEB-INF/view/login/loginForm.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return LOGIN_VIEW;
		}else if(req.getMethod().equals("post")){
			
		}
		return null;
	}

}
