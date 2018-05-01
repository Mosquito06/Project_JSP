package Project_JSP.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Room;
import Project_JSP.dto.RoomInfo;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomDaoService;
import Project_JSP.service.RoomInfoDaoService;

public class AdminRoomDeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int roomNum = Integer.parseInt(req.getParameter("roomNum"));
		
		RoomInfoDaoService roomInfoService = RoomInfoDaoService.getInstance();
		RoomDaoService roomService = RoomDaoService.getInstance();
		
		Room room = new Room();
		room.setRoomNum(roomNum);
		
		Room targetRoom = roomService.selectRoomByNum(room);
		RoomInfo targetRoomInfo = roomInfoService.selectRoomInfoByNum(targetRoom.getRoomInfoNum());
		
		roomService.deleteRoom(targetRoom);
		roomInfoService.deleteRoomInfo(targetRoomInfo);
						
		res.sendRedirect("/Project_JSP/adminRoom.do?result=3");
		return null; 
	}

}
