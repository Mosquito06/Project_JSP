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

public class ReservationSearchHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String startDate = req.getParameter("sDate");
		String endDate = req.getParameter("eDate");
		
		ObjectMapper om = new ObjectMapper();
		RoomDaoService service = RoomDaoService.getInstance();
		RoomInfoDaoService infoService = RoomInfoDaoService.getInstance();
		
		List<Room> room = service.selectAvailabilityRoom(startDate, endDate); 
		List<List<RoomInfo>> result = new ArrayList<>();
		List<StringBuffer> roomView = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		
		for(Room r: room){
			result.add(infoService.selectViewTypeByRoomGrade(r.getRoomInfoNum().getRoomInfoName()));
		};
		
		for(List<RoomInfo> i : result){
			StringBuffer sb = new StringBuffer();
			Iterator<RoomInfo> ii = i.iterator();
			while(ii.hasNext()){
				RoomInfo item = ii.next();
				if(item.getViewType().equals(ViewType.MOUNTAIN)){
					sb.append("산");
				}else if(item.getViewType().equals(ViewType.GARDEN)){
					sb.append("정원");
				}else{
					sb.append("바다");
				}
				if(ii.hasNext()){
					sb.append(", ");
				}
			}
			roomView.add(sb);
		}
		
		if(room != null){
			map.put("resultRoom", room);
			map.put("resultViewType", roomView);
			
			String data = om.writeValueAsString(map);
			
			res.setContentType("application/json;charset=utf-8");
			PrintWriter pw = res.getWriter();
			pw.print(data);
			pw.flush();
		}
		
		return null;
		
	}

}
