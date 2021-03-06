package Project_JSP.handler;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Activity;
import Project_JSP.dto.Banner;
import Project_JSP.dto.Event;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ActivityService;
import Project_JSP.service.BannerService;
import Project_JSP.service.EventService;

public class IndexPageHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ObjectMapper om = new ObjectMapper();
		
		HashMap<String, Object> sendData = new HashMap<>();
		
		BannerService service =BannerService.getInstance();
		List<Banner> bannerlist = service.select();
		
		sendData.put("banner", bannerlist);
		
		EventService eventService = EventService.getInstance();
		
		List<Event> eventList = eventService.selectListEvent();
		
		sendData.put("event", eventList);
		
		ActivityService actService = ActivityService.getInstance();

		List<Activity> actList = actService.selectByType(new Activity("cammping"));
		
		sendData.put("activity", actList);
		
		String json = om.writeValueAsString(sendData);
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성
		pw.print(json); //json pw에 넣기
		pw.flush(); //내보내기 
		
		return null; 
	}

}
