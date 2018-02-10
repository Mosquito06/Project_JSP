package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Room;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomDaoService;

public class ReservationSearchHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String startDate = req.getParameter("sDate");
		String endDate = req.getParameter("eDate");
		
		ObjectMapper om = new ObjectMapper();
		RoomDaoService service = RoomDaoService.getInstance();
		List<Room> room = service.selectAvailabilityRoom(startDate, endDate); 
		
		if(room != null){

			String data = om.writeValueAsString(room);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(data);
			pw.flush();
		}
		
		return null;
		
	}

}
