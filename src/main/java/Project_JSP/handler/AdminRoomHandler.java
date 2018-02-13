package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.RoomInfo;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomInfoDaoService;

public class AdminRoomHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		RoomInfoDaoService service = RoomInfoDaoService.getInstance();
		List<RoomInfo> lists= service.selectRoomInfo();
		req.setAttribute("roomInfo", lists);
		return "/WEB-INF/view/adminpage/adminpage_room.jsp";
	}

}
