package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Room;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomDaoService;

public class AdminRoomSearchHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String select = req.getParameter("select");
		String roomGrade = req.getParameter("roomGrade");
		ObjectMapper om = new ObjectMapper();
		List<Room> result = null;
		RoomDaoService roomService = RoomDaoService.getInstance();
		String data = "";
		
		
		if(select.equals("1")){
			result = roomService.selectRoombyGrade(roomGrade);
			
		}else{
			String roomName = req.getParameter("roomName");
			result = roomService.selectRoombyGradeAndName(roomGrade, roomName);
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
