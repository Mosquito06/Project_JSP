package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class AdminUserDeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ClientDaoService service = ClientDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			Client client = new Client();
			
			int set = Integer.parseInt(req.getParameter("set"));
			if(set==1){
				int no = Integer.parseInt(req.getParameter("num"));
				client.setClientNum(no);
				service.deleteClient(client);
				res.sendRedirect("adminUser.do");
			}else if(set==2){
				String list = req.getParameter("list");
				String[] arr=list.split(",");
				for(int i=0;i<arr.length;i++){
					int no=Integer.parseInt(arr[i]);
					client.setClientNum(no);
					service.deleteClient(client);
				}
				res.sendRedirect("adminUser.do");
			}
			
			return null;
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
