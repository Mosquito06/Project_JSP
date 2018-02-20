package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Event;
import Project_JSP.dto.EventContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.EventContentService;
import Project_JSP.service.EventService;

public class AdminEventReadHandler implements CommandHandler {
	private static final String path = "/WEB-INF/view/adminpage/";
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("get")){
			EventService service = EventService.getInstance();
			EventContentService contentService = EventContentService.getInstance();
			
			int no = Integer.parseInt(req.getParameter("no"));
			
			Event event = service.readEventByNum(new Event(no));
			
			if(event == null){
				req.setAttribute("error", "존재하지 않는 게시물입니다.");
				return path+"adminpage_eventRead.jsp";
			}
			
			EventContent eventContent = contentService.selectEventContentByNum(new EventContent(no));
			
			if(eventContent == null){
				req.setAttribute("error", "게시물을 불러오는데 실패하였습니다.");
				return path+"adminpage_eventRead.jsp";
			}
			
			List<Event> list = service.selectListEvent();
			
			req.setAttribute("list", list);
			req.setAttribute("content", eventContent);
			
			return path+"adminpage_eventRead.jsp";					
		}else if(req.getMethod().equalsIgnoreCase("post")){
		
			return path+"adminpage_eventRead.jsp";	
		}
		
		return null;		
	}

}
