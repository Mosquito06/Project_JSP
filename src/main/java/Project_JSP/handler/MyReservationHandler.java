package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.dto.ReservationState;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ReservationDaoService;

public class MyReservationHandler implements CommandHandler {
	private static final String MYPAGE_VIEW = "/WEB-INF/view/mypage/myReservation.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Client client = (Client) req.getSession().getAttribute("MEMBER");
		Client nonClient = (Client) req.getSession().getAttribute("NONMEMBER");

		List<Reservation> result = null;
		
		if(client != null){
			ReservationDaoService reservService = ReservationDaoService.getInstance();
			result = reservService.selectReservationOnlyReserv(client.getClientNum());
		
		}else{
			ReservationDaoService reservService = ReservationDaoService.getInstance();
			result = reservService.selectReservationOnlyReserv(nonClient.getClientNum());		
		}
		
		if(result.isEmpty()){
			req.setAttribute("result", "Empty");
		}else{
			req.setAttribute("result", result);
		}
		
		return MYPAGE_VIEW;
		
	}

}
