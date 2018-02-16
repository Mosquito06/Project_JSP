package Project_JSP.handler;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class NewPasswordHandler implements CommandHandler {
	private static final String NEWPASSWORD = "/WEB-INF/view/mypage/newPassword.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return NEWPASSWORD;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			Client client = new Client();
			client.setId(req.getParameter("id"));
			client.setClientGrade(ClientGrade.MEMBER);
			client.setPw(req.getParameter("pw"));
			
			ClientDaoService service = ClientDaoService.getInstance();
			
			Client newClient = service.selectClientPw(client);
			
			ObjectMapper om = new ObjectMapper();
			if(newClient == null){
				
				String json = om.writeValueAsString(false);
				
				res.setContentType("application/json;charset=utf-8");
				PrintWriter pw = res.getWriter();
				pw.print(json);
				pw.flush(); //고객에게 돌려줌
			}else{
				newClient.setPw(req.getParameter("newPw"));
				
				service.updatePassword(newClient);
			
				String json = om.writeValueAsString(true);
				
				res.setContentType("application/json;charset=utf-8");
				PrintWriter pw = res.getWriter();
				pw.print(json);
				pw.flush(); //고객에게 돌려줌
			}
			
		}
		return null;
	}

}
