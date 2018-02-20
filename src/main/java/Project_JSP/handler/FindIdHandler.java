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

public class FindIdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String nameEn = req.getParameter("nameEn2").toUpperCase()+" "+req.getParameter("nameEn1").toUpperCase();
	
		Client client = new Client();
		client.setNameEn(nameEn);
		client.setEmail(req.getParameter("email"));
		client.setClientGrade(ClientGrade.MEMBER);
		
		ClientDaoService service  = ClientDaoService.getInstance();
		Client c = service.selectNonClientByNameAndEmil(client);
		
		HashMap<String,Client> map = new HashMap<>();
		map.put("client",c);
		ObjectMapper om = new ObjectMapper();
		
		String json = om.writeValueAsString(map);
		
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(json);
		pw.flush(); //고객에게 돌려줌
		return null;
	}

}
