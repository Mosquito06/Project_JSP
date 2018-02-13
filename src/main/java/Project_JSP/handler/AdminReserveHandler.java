package Project_JSP.handler;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.dto.ReservationState;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ClientDaoService;
import Project_JSP.service.ReservationDaoService;

public class AdminReserveHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReservationDaoService service = ReservationDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			List<Reservation> lists=service.selectReservation();
			String set = req.getParameter("set");
		
			if(set.equals("1")){
				lists = service.selectReservationState(ReservationState.RESERVE);
			}else if(set.equals("2")){
				lists = service.selectReservationState(ReservationState.COMPLETE);
			}else if(set.equals("3")){
				lists = service.selectReservationState(ReservationState.CANCEL);
			}
			req.setAttribute("reserve", lists);
			return "/WEB-INF/view/adminpage/adminpage_reservation.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			Reservation reservation = new Reservation();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			String set = req.getParameter("set");
			List<Reservation> lists = null;
			if(set.equals("1")){
				System.out.println("1");
				String sDay = req.getParameter("sDay");
				String eDay = req.getParameter("eDay");
				reservation.setCheckIn(sd.parse(sDay));
				reservation.setCheckOut(sd.parse(eDay));
				req.setAttribute("sDay", sDay);
				req.setAttribute("eDay", eDay);
				req.setAttribute("set", 1);
				lists=service.selectReservationDate(reservation);
			}else if(set.equals("2")){
				
				String id = req.getParameter("id");
				ClientDaoService clientDaoService = ClientDaoService.getInstance();
				Client client = new Client();
				client.setId(id);
				client=clientDaoService.findClientId(client);
				lists=service.selectReservationUser(client.getClientNum());
				req.setAttribute("id", id);
				req.setAttribute("set", 2); 
			}
			
			
			req.setAttribute("reserve", lists);
			
			return "/WEB-INF/view/adminpage/adminpage_reservation.jsp";
		}
		return null;
	}

}
