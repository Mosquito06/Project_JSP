package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class AdminUserFindHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ClientDaoService service = ClientDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			List<Client> lists=service.findClientGrade(ClientGrade.BLACKLIST);
			req.setAttribute("lists", lists);
			return "/WEB-INF/view/adminpage/adminpage_user.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			Client client = new Client();
			
			String id=req.getParameter("id");
			 
			client.setId(id);
			client = service.findClientId(client);
			
			req.setAttribute("client", client);
			return "/WEB-INF/view/adminpage/adminpage_user.jsp";
		}
		
		return null;
	}

}
