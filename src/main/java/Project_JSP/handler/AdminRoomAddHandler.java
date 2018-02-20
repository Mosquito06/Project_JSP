package Project_JSP.handler;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Project_JSP.dto.RoomInfo;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomInfoDaoService;

public class AdminRoomAddHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")){
			return "/WEB-INF/view/adminpage/adminpage_room_add.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){
			req.setCharacterEncoding("UTF-8");
			String folderName = req.getParameter("room_info_name");
			String uploadPath = req.getRealPath("/img/room/" + folderName);
			
			File dir = new File(uploadPath);
			if(dir.exists()){
				dir.delete();
				dir.mkdirs(); // 폴더 만들기
			}else{
				dir.mkdirs();
			}

			int maxSize = 1024 * 1024 * 10;
			
			MultipartRequest multi = new MultipartRequest(req, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());

			String roomImgUpload = req.getParameter("roomImgUpload");
			String roomImgDelete = req.getParameter("roomImgDelete");
			String reservImgUpload = req.getParameter("reservImgUpload");
			String reservImgDelete = req.getParameter("reservImgDelete");
			

			
			
			
			return null;
		}
		
		return null;
	}

}
