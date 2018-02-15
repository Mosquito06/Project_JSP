package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;
import Project_JSP.service.ReservationDaoService;

public class AdminUserReadHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReservationDaoService service = ReservationDaoService.getInstance();
		ClientDaoService clientDaoService = ClientDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			
			int num = Integer.parseInt(req.getParameter("num"));
		
			Client client = new Client();
			client.setClientNum(num);
			client = clientDaoService.selectClientNum(client);
			
			List<Reservation> list=service.selectReservationUser(num);
			req.setAttribute("reserve", list);
			req.setAttribute("client", client); 
			return "/WEB-INF/view/adminpage/adminpage_user_read.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			return "/WEB-INF/view/adminpage/adminpage_user_read.jsp"; 
		}
		return null;
	}

}
