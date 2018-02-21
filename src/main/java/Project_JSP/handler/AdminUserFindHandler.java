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
			String set = req.getParameter("set");
			List<Client> lists=null;
			if(set.equals("1")){
				lists=service.findClientGrade(ClientGrade.BLACKLIST);
			}else if(set.equals("2")){
				lists=service.findClientGrade(ClientGrade.MEMBER);
			}else if(set.equals("3")){
				lists=service.findClientGrade(ClientGrade.NONMEMBER);
			}else if(set.equals("4")){
				lists=service.findClientGrade(ClientGrade.ADMIN);
			}
			
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
