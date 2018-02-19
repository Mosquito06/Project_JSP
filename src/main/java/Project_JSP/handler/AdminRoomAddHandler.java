package Project_JSP.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.RoomInfo;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomInfoDaoService;

public class AdminRoomAddHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		return "/WEB-INF/view/adminpage/adminpage_room_add.jsp";
	}

}
