package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class LogOutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getSession().removeAttribute("MEMBER");
		req.getSession().removeAttribute("NONMEMBER");
		req.getSession().removeAttribute("ADMIN");
		res.sendRedirect("index.jsp");
		return null;
	}

}
