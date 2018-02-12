package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class AdminUserHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ClientDaoService service = ClientDaoService.getInstance();
		
		List<Client> lists=service.selectClient();
		req.setAttribute("client", lists);
		return "/WEB-INF/view/adminpage/adminpage_user.jsp";
	}

}
