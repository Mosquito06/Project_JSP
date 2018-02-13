package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ReservationDaoService;

public class AdminReserveHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReservationDaoService service = ReservationDaoService.getInstance();
		
		List<Reservation> lists=service.selectReservation();
		req.setAttribute("reserve", lists);
		return "/WEB-INF/view/adminpage/adminpage_reservation.jsp";
	}

}
