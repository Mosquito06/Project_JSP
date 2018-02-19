package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;
import Project_JSP.service.ReservationDaoService;

public class AdminReserveUpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReservationDaoService service = ReservationDaoService.getInstance();
		ClientDaoService clientDaoService = ClientDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			Reservation reservation = new Reservation();
			int num = Integer.parseInt(req.getParameter("num"));
			reservation.setReservationNum(num);
			reservation=service.selectReservationNum(reservation);
			Client client = reservation.getClientNum();
			client = clientDaoService.selectClientNum(client);
			req.setAttribute("reservation", reservation);
			req.setAttribute("client", client);
			
			return "/WEB-INF/view/adminpage/adminpage_reservation_read_update.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			return "/WEB-INF/view/adminpage/adminpage_user.jsp";
		}
		
		return null;
	}

}
