package Project_JSP.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.RoomInfoDaoService;

public class RoomIndexHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/room/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String imgPath = req.getRealPath("/img/room/Standard");
		
		RoomInfoDaoService service = RoomInfoDaoService.getInstance();
		
		File path = new File(imgPath);
		System.out.println(path.getName());
		File[] files = path.listFiles();

		List<String> fileNames = new ArrayList<>();
		String contextPath = req.getContextPath() + "/img/room/Standard/"; 
		for (File file : files) {
			fileNames.add(contextPath + file.getName()); 
		}  
		fileNames.remove(4);
		req.setAttribute("list", fileNames);
		
		return filePath+"room.jsp";
	}

}
