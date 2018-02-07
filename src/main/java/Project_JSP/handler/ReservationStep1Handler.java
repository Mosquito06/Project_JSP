package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class ReservationStep1Handler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/reservation/step1.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			return null;
		}
		return null;
		
	}

}
