package Project_JSP.handler;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.BedType;
import Project_JSP.dto.Room;
import Project_JSP.dto.RoomGrade;
import Project_JSP.dto.RoomInfo;
import Project_JSP.dto.ViewType;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomDaoService;
import Project_JSP.service.RoomInfoDaoService;

public class AdminRoomUpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			String roomNum = req.getParameter("roomNum");
			String roomGrade = req.getParameter("roomGrade");
			String roomInfoName = req.getParameter("roomInfoName");
			String roomSize = req.getParameter("roomSize");
			String bedType = req.getParameter("bedType");
			String viewType = req.getParameter("viewType");
			String roomPrice = req.getParameter("roomPrice");

			String filePath = req.getRealPath("/img/room/" + roomInfoName);
			File file = new File(filePath);
			File[] fileList = file.listFiles();
			String[] roomImgName = new String[fileList.length - 1];
			
			for(int i = 0; i < roomImgName.length; i++){
				roomImgName[i] = fileList[i].getName();
			}
			
			String reservImgName = fileList[fileList.length - 1].getName();
			
			String[] roomGradeArr = {"선택하세요", "STANDARD", "PREMIER", "SUITE"};
			String[] bedTypeArr = {"선택하세요", "SINGLE", "DOUBLE", "TWIN", "FAMILYTWIN"};
			String[] viewTypeArr = {"선택하세요", "MOUNTAIN", "GARDEN", "OCEAN"};
			
			req.setAttribute("roomNum", roomNum);
			req.setAttribute("roomGrade", roomGrade);
			req.setAttribute("roomInfoName", roomInfoName);
			req.setAttribute("roomSize", roomSize);
			req.setAttribute("bedType", bedType);
			req.setAttribute("viewType", viewType);
			req.setAttribute("roomPrice", roomPrice);
			req.setAttribute("roomImgName", roomImgName);
			req.setAttribute("reservImgName", reservImgName);
			req.setAttribute("roomGradeArr", roomGradeArr);
			req.setAttribute("bedTypeArr", bedTypeArr);
			req.setAttribute("viewTypeArr", viewTypeArr);
			
			return "/WEB-INF/view/adminpage/adminpage_room_update.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			req.setCharacterEncoding("UTF-8");
			String folderName = req.getParameter("room_info_name");
			String roomImgPath = req.getRealPath("/img/room/" + folderName);

			File roomImgDir = new File(roomImgPath);
			
			// 객실 이미지 저장 폴더
			if(roomImgDir.exists()){
				File[] existsFile = roomImgDir.listFiles();
				
				for(File f : existsFile){
					f.delete();
				}
				
				roomImgDir.delete();
				roomImgDir.mkdir();
			}else if(!roomImgDir.exists()){
				roomImgDir.mkdir();
			}

			
			// roomImgDir.mkdirs(); 
					
			int maxSize = 1024 * 1024 * 10;
			
			// 객실 이미지 폴더에 저장
			MultipartRequest roomMulti = new MultipartRequest(req, roomImgPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			// 삭제할 이미지 명
			String roomImgUpload = req.getParameter("roomImgUpload");
			String roomImgDelete = req.getParameter("roomImgDelete");
			String reservImgUpload = req.getParameter("reservImgUpload");
			String reservImgDelete = req.getParameter("reservImgDelete");
			String[] romImgDeleteList = roomImgDelete.split(",");
			String[] reservImgDeleteList = reservImgDelete.split(",");
						
			File[] roomImgList = roomImgDir.listFiles();
			for(int i = 0; i < roomImgList.length; i++){
				for(int ii = 0; ii < romImgDeleteList.length; ii++){
					if(roomImgList[i].getName().equals(romImgDeleteList[ii])){
						roomImgList[i].delete();
					}
				}
			}
			
			for(int i = 0; i < roomImgList.length; i++){
				for(int ii = 0; ii < reservImgDeleteList.length; ii++){
					if(roomImgList[i].getName().equals(reservImgDeleteList[ii])){
						roomImgList[i].delete();
					}
				}
			}
			
			
			// insert에 필요한 정보를 가져옴
			RoomInfo roomInfo = new RoomInfo();
			String roomInfoName = folderName;
			roomInfo.setRoomInfoName(roomInfoName);
			
			String roomGrade = roomMulti.getParameter("roomGrade");
			switch(roomGrade){
			case "STANDARD":
				roomInfo.setRoomGrade(RoomGrade.STANDARD);
				break;
			case "PREMIER":
				roomInfo.setRoomGrade(RoomGrade.PREMIER);
				break;
			case "SUITE":
				roomInfo.setRoomGrade(RoomGrade.SUITE);
			}
			
			
			String bedType = roomMulti.getParameter("bedType");
			switch(bedType){
				case "SINGLE":
					roomInfo.setBedType(BedType.SINGLE);
					break;
				case "DOUBLE":
					roomInfo.setBedType(BedType.DOUBLE);
					break;
				case "TWIN":
					roomInfo.setBedType(BedType.TWIN);
					break;
				case "FAMILYTWIN":
					roomInfo.setBedType(BedType.FAMILYTWIN);
					break;
			}
						
			String viewType = roomMulti.getParameter("viewType");
			switch(viewType){
			case "MOUNTAIN":
				roomInfo.setViewType(ViewType.MOUNTAIN);
				break;
			case "GARDEN":
				roomInfo.setViewType(ViewType.GARDEN);
				break;
			case "OCEAN":
				roomInfo.setViewType(ViewType.OCEAN);
			}
			
			
			String roomSize = roomMulti.getParameter("room_size");
			String roomImg = folderName;
			String reservationImg = reservImgUpload;
			
			roomInfo.setRoomImg(roomImg);
			roomInfo.setRoomSize(roomSize);
			roomInfo.setReservationImg(reservationImg);
			
			RoomInfoDaoService roomInfoService = RoomInfoDaoService.getInstance();
			RoomDaoService roomService = RoomDaoService.getInstance();
			roomInfoService.insertRoomInfo(roomInfo);
			
			List<RoomInfo> lastId = roomInfoService.selectLastInsertRoomInfo();

			int roomNum = Integer.parseInt(roomMulti.getParameter("room_num"));
			int roomPrice = Integer.parseInt(roomMulti.getParameter("room_price"));
			Room room = new Room();
			room.setRoomNum(roomNum);
			room.setRoomPrice(roomPrice);
			room.setRoomInfoNum(lastId.get(lastId.size()-1));
			
			int result = roomService.insertRoom(room);
			String Redirect = "";
			if(result <= 0 ){
				Redirect = "/Project_JSP/adminRoomAdd.do?result=0";
				roomInfoService.deleteRoomInfo(lastId.get(lastId.size()-1));
			}else{
				Redirect = "/Project_JSP/adminRoom.do?result=1";
			}
		
			res.sendRedirect(Redirect);
			return null;
		}
		
		return null;
	}

}
