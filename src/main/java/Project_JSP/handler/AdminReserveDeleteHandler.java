package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ReservationDaoService;

public class AdminReserveDeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ReservationDaoService service = ReservationDaoService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			Reservation reservation = new Reservation();
			
			int set = Integer.parseInt(req.getParameter("set"));
			if(set==1){
				int no = Integer.parseInt(req.getParameter("num"));
				reservation.setReservationNum(no);
				service.deleteReservation(reservation);
				
				res.sendRedirect("adminReservation.do?set=0");
			}else if(set==2){
				String list = req.getParameter("list");
				String[] arr=list.split(",");
				for(int i=0;i<arr.length;i++){
					int no=Integer.parseInt(arr[i]);
					reservation.setReservationNum(no);
					service.deleteReservation(reservation);
				}
				res.sendRedirect("adminReservation.do?set=0");
			}
			
			return null;
		}else if(req.getMethod().equalsIgnoreCase("post")){
			
			return "/WEB-INF/view/adminpage/adminpage_user.jsp";
		}
		
		return null;
	}

}
