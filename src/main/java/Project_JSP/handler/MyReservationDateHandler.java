package Project_JSP.handler;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ReservationDaoService;

public class MyReservationDateHandler implements CommandHandler {
	private static final String MYPAGE_VIEW = "/WEB-INF/view/mypage/myReservation.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String sDate = req.getParameter("sDate");
		String eDate = req.getParameter("eDate");
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyyMMdd");
		Client client = (Client) req.getSession().getAttribute("MEMBER");
		Client nonClient = (Client) req.getSession().getAttribute("NONMEMBER");
		List<Reservation> result = null;
		Reservation reservation = new Reservation();

		
		if(client != null){
			reservation.setClientNum(client);
			reservation.setCheckIn(sm.parse(sDate));
			reservation.setCheckOut(sm.parse(eDate));
			ReservationDaoService reservService = ReservationDaoService.getInstance();
			result = reservService.selectReservationDateByClientNum(reservation);
		}else{
			reservation.setClientNum(nonClient);
			reservation.setCheckIn(sm.parse(sDate));
			reservation.setCheckOut(sm.parse(eDate));
			ReservationDaoService reservService = ReservationDaoService.getInstance();
			result = reservService.selectReservationDateByClientNum(reservation);
		}
		
		if(result.isEmpty()){
			req.setAttribute("result", "Empty");
		}else{
			req.setAttribute("result" , result);
		}
						
		return MYPAGE_VIEW;
		
	}

}
