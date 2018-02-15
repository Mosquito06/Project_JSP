package Project_JSP.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class ReservationLoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ObjectMapper om = new ObjectMapper();
		HashMap<String, Object> result = new HashMap<>();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		ClientGrade clientGrade = ClientGrade.MEMBER;

		Client client = new Client();
		client.setId(id);
		client.setClientGrade(clientGrade);
		client.setPw(pw);
		
		ClientDaoService service = ClientDaoService.getInstance();

		Client cId = service.selectClientId(client);

		if (cId == null) {
			result.put("error1", "회원이 아닙니다. 아이디를 확인해주세요.");
			setJson(req, res, result, om);
			return null;
			
		} else {
			Client cPw = service.selectClientPw(client);
			if (cPw == null) {
				result.put("error3", "비밀번호를 확인해주세요.");
				setJson(req, res, result, om);
				return null;
			}

			req.getSession().setAttribute("MEMBER", cPw);
			result.put("success", cPw);
			setJson(req, res, result, om);
			return null;

		}
	}
	
	private void setJson(HttpServletRequest req, HttpServletResponse res, HashMap<String, Object> map, ObjectMapper om){
		try {
			String data = om.writeValueAsString(map);
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(data);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
