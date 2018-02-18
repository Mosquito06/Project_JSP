package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Client;
import Project_JSP.dto.Reservation;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ReservationDaoService;

public class MyReservationAllHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Client client = (Client) req.getSession().getAttribute("MEMBER");
		Client nonClient = (Client) req.getSession().getAttribute("NONMEMBER");
		ObjectMapper om = new ObjectMapper();
		List<Reservation> result = null;
		String data = "";
		
		if(client != null){
			ReservationDaoService reservService = ReservationDaoService.getInstance();
			result = reservService.selectReservationJoinRoomAndRoomInfo(client.getClientNum());
		}else{
			ReservationDaoService reservService = ReservationDaoService.getInstance();
			result = reservService.selectReservationJoinRoomAndRoomInfo(nonClient.getClientNum());			
		}
		
		if(result.isEmpty()){
			data = om.writeValueAsString("Empty");
		}else{
			data = om.writeValueAsString(result);
		}
				
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(data);
		pw.flush();
		
		return null;
		
	}

}
