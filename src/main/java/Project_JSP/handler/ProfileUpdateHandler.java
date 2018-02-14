package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class ProfileUpdateHandler implements CommandHandler {
	private static final String PROFILE_UPDATE = "/WEB-INF/view/mypage/profileUpdate.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return PROFILE_UPDATE;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return null;
	}

}
