package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class SecessionProcessHandler implements CommandHandler {
	
	private static final String SECESSIONSUCCESS = "/WEB-INF/view/mypage/secessionSuccess.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			Client c = (Client)req.getSession().getAttribute("MEMBER");
			req.setAttribute("client", c);
			return SECESSIONSUCCESS;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			int num = Integer.parseInt(req.getParameter("hiddenNum"));
			
			Client client = new Client();
			client.setClientNum(num);
			
			ClientDaoService service = ClientDaoService.getInstance();
			service.deleteClient(client);
			req.getSession().removeAttribute("MEMBER");
			
			res.sendRedirect("index.jsp");
		}
			
		return null;
	}

}
