package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Room;
import Project_JSP.dto.RoomInfo;
import Project_JSP.dto.ViewType;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomDaoService;
import Project_JSP.service.RoomInfoDaoService;

public class ReservationSpecificSearchHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String roomName = req.getParameter("name");
		int index = Integer.parseInt(req.getParameter("index"));

		
		ObjectMapper om =new ObjectMapper();
		RoomDaoService service = RoomDaoService.getInstance();
		List<Room> result = service.selectAvailabilityRoomByRoomName(roomName);
		HashMap<String, Object> map = new HashMap<>();
		
		if(result != null){
			map.put("roomInfo", result);
			map.put("index", index);
			
			String data = om.writeValueAsString(map);
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(data);
			pw.flush();
		}
		
		return null;
		
	}

}
