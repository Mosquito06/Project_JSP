package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.dto.ReservationState;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;
import Project_JSP.service.ReservationDaoService;

public class AdminReserveReadHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReservationDaoService service = ReservationDaoService.getInstance();
		ClientDaoService clientDaoService = ClientDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			Reservation reservation = new Reservation();
			int num = Integer.parseInt(req.getParameter("num"));
			reservation.setReservationNum(num);
			String set= req.getParameter("set");
			reservation=service.selectReservationNum(reservation);
			if(set.equals("1")){
				
			}else if(set.equals("2")){
				
				reservation.setState(ReservationState.COMPLETE);
				service.updateReservation(reservation);
			}else if(set.equals("3")){
				
				reservation.setState(ReservationState.CANCEL);
				service.updateReservation(reservation);
			}else if(set.equals("4")){
				
				reservation.setState(ReservationState.RESERVE);
				service.updateReservation(reservation);
			}
			
			Client client = reservation.getClientNum();
			client = clientDaoService.selectClientNum(client);
			req.setAttribute("reservation", reservation);
			req.setAttribute("client", client);
			return "/WEB-INF/view/adminpage/adminpage_reservation_read.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			return "/WEB-INF/view/adminpage/adminpage_reservation_read.jsp";
		}
		return null;
	}

}
