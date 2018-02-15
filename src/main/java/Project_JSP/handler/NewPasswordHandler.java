package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class NewPasswordHandler implements CommandHandler {
	private static final String NEWPASSWORD = "/WEB-INF/view/mypage/newPassword.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return NEWPASSWORD;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return null;
	}

}
