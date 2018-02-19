package Project_JSP.handler;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
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
		HashMap<String, Object> resultMap = new HashMap<>();
		RoomDaoService roomService = RoomDaoService.getInstance();
		String data = "";
		
		
		if(select.equals("1")){
			result = roomService.selectRoombyGrade(roomGrade);
			resultMap.put("result", result);
		}else{
			String roomName = req.getParameter("roomName");
			result = roomService.selectRoombyGradeAndName(roomGrade, roomName);
			resultMap.put("result", result);
			if(!result.isEmpty()){
				String roomImgFolderName = result.get(0).getRoomInfoNum().getRoomImg();
				String Path = "img/room/" + roomImgFolderName;
				String realPath = req.getRealPath(Path);
				
				File imgFile = new File(realPath);
				File[] fileList = imgFile.listFiles();
				String[] fileName = new String[fileList.length];
				for(int i = 0; i < fileList.length; i++){
					fileName[i] = fileList[i].getName();
				}
								
				resultMap.put("imgList", fileName);
			}
		}
		
		if(result.isEmpty()){
			resultMap.put("result", "Empty");
			data = om.writeValueAsString(resultMap);
		}else{
			data = om.writeValueAsString(resultMap);
		}
				
		res.setContentType("application/json;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.print(data);
		pw.flush();
				
		return null;
	}

}
