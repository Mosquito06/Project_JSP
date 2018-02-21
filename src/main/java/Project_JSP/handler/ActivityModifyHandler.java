package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class ActivityModifyHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			
			return filePath + "adminpage_activityModify.jsp";	
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			res.sendRedirect(req.getContextPath() + "/adminActivityList.do");
			return null;
		}
		
		return null; 
	}

}
