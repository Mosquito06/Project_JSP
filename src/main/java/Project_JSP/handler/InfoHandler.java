package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;

public class InfoHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String page = req.getParameter("page");
		if(page.equals("1")){
			return "/WEB-INF/view/info/info.jsp";
		}else if(page.equals("2")){
			return "/WEB-INF/view/info/info_shilla.jsp";
		}else if(page.equals("3")){
			return "/WEB-INF/view/info/info_stairs.jsp";
		}else if(page.equals("4")){
			return "/WEB-INF/view/info/info_map.jsp";
		}
		return null;
	}

}
