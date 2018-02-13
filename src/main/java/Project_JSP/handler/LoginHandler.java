package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.ClientGrade;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;

public class LoginHandler implements CommandHandler {
	private static final String LOGIN_VIEW = "/WEB-INF/view/login/loginForm.jsp";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			req.removeAttribute("noMember");
			req.removeAttribute("admin");
			return LOGIN_VIEW;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			String id = req.getParameter("id");
			String clientGrade = req.getParameter("clientGrade");
			
			Client client = new Client();
			client.setId(id);
		
			if(clientGrade.equals("MEMBER")){
				String pw = req.getParameter("pw");
				client.setClientGrade(ClientGrade.MEMBER);
				client.setPw(pw);
			}else if(clientGrade.equals("NONMEMBER")){
				String name = req.getParameter("name2").toUpperCase()+" "+req.getParameter("name1").toUpperCase();
				client.setClientGrade(ClientGrade.NONMEMBER);
				client.setNameEn(name);
			}else if(clientGrade.equals("ADMIN")){
				String pw = req.getParameter("pw");
				client.setClientGrade(ClientGrade.ADMIN);
				client.setPw(pw);
			}
		
			ClientDaoService service = ClientDaoService.getInstance();
		
			if(clientGrade.equals("MEMBER")){
				
				req.removeAttribute("noMember");
				req.removeAttribute("admin");
				
				Client cId = service.selectClientId(client);
				
				if(cId==null){
					req.setAttribute("error1","* 회원이 아닙니다. 아이디를 확인해주세요");
					return LOGIN_VIEW;
				}else{
					Client cPw = service.selectClientPw(client);
					 if(cPw==null){
						req.setAttribute("error3", "*비밀번호를 확인해주세요");
						return LOGIN_VIEW;
					}
				
					 req.getSession().setAttribute("MEMBER", cPw);
					 req.getSession().removeAttribute("NONMEMBER");
					 req.getSession().removeAttribute("ADMIN");
					 res.sendRedirect("index.jsp");
					 return null;
					 
				}
				
			}
	
			
			if(clientGrade.equals("NONMEMBER")){
				req.setAttribute("noMember", "checked");
				req.removeAttribute("admin");
				
				Client cId = service.selectClientId(client);
				
				if(cId==null){
					req.setAttribute("error2","*예약한 기록이 없습니다.");
					return LOGIN_VIEW;
				}else{
					Client cName = service.selectClientName(client);
					if(cName ==null){
						req.setAttribute("error4", "*이름을 확인해주세요");
						return LOGIN_VIEW;
					}
					
					req.getSession().setAttribute("NONMEMBER", cName);
					req.getSession().removeAttribute("MEMBER");
					req.getSession().removeAttribute("ADMIN");
					 res.sendRedirect("index.jsp");
					 return null;
				}
				
			}
			
			if(clientGrade.equals("ADMIN")){
				req.setAttribute("admin", "checked");
				req.removeAttribute("noMember");
				
				Client cId = service.selectClientId(client);
				if(cId==null){
					req.setAttribute("error5", "*관리자가 아닙니다");
					return LOGIN_VIEW;
				}else{
					Client aPw = service.selectClientPw(client);
					if(aPw==null){
						req.setAttribute("error6", "*비밀번호를 확인해주세요");
						return LOGIN_VIEW;
					}
					
					req.getSession().setAttribute("ADMIN", aPw);
					req.getSession().removeAttribute("MEMBER");
					req.getSession().removeAttribute("NONMEMBER");
					 res.sendRedirect("index.jsp");
					 return null;
				}
			}
			
		
			return LOGIN_VIEW;
	
		}
		return null;
	}

}
