package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class ProfileUpdateHandler implements CommandHandler {
	private static final String PROFILE_UPDATE = "/WEB-INF/view/mypage/profileUpdate.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return PROFILE_UPDATE;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			Client client = new Client();
			
			String address = req.getParameter("addr1")+"/"+req.getParameter("addr2")+"/"+req.getParameter("addr3");
			String email = req.getParameter("email1")+"@"+req.getParameter("email2");
			client.setId(req.getParameter("id"));
			client.setPhone(req.getParameter("phone"));
			client.setHome(req.getParameter("home"));
			client.setAddress(address);
			client.setEmail(email);
			client.setClientGrade(ClientGrade.MEMBER);
			
			ClientDaoService service = ClientDaoService.getInstance(); 
			
			service.updateProfile(client);
			System.out.println(client);
			Client newClient = new Client();
			newClient.setId(req.getParameter("id"));
			newClient.setClientGrade(ClientGrade.MEMBER);
			
			Client c = service.selectClientId(newClient);
			
			System.out.println(c);
			
			HashMap<String,Client> map = new HashMap<>();
			map.put("client",c);
			ObjectMapper om = new ObjectMapper();
			
			String json = om.writeValueAsString(map);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(json);
			pw.flush(); //고객에게 돌려줌
		}
		return null;
	}

}
