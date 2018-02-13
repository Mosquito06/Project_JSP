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

public class DuplicateEmailHanlder implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ClientDaoService service  = ClientDaoService.getInstance();
		
		Client client = new Client();
		String email1 = req.getParameter("email1");
		String email2 = req.getParameter("email2");
		String email = email1+"@"+email2;
		client.setEmail(email);
		client.setClientGrade(ClientGrade.MEMBER);
		Client c = service.selectClientEmail(client);
		
		HashMap<String,Client> map = new HashMap<>();
		map.put("email",c);
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(map);
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(json);
		pw.flush(); //고객에게 돌려줌
		return null;
	}

}
