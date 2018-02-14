package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class ProfileHandler implements CommandHandler{
	private static final String PROFILE = "/WEB-INF/view/mypage/profileUpdate.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return PROFILE;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
		}
		return null;
	}

}
