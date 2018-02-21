package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class SecessionHandler implements CommandHandler {
	private static final String SECESSIONVIEW = "/WEB-INF/view/mypage/secession.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return SECESSIONVIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			
			Client client = new Client();
			client.setId(id);
			client.setClientGrade(ClientGrade.MEMBER);
			client.setPw(pw);
			
			ClientDaoService service = ClientDaoService.getInstance();
			Client c = service.selectClientPw(client);
			
			if(c==null){
				req.setAttribute("error","※비밀번호가 일치하지 않습니다");
				return SECESSIONVIEW;
			}else{
				res.sendRedirect("secessionProcessing.do");
				return null;
			}
		}
		return null;
	}

}
