package Project_JSP.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Activity;
import Project_JSP.dto.ActivityContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ActivityService;

public class ActivityReadByAdminHandler implements CommandHandler {
	private static final String filePath = "/WEB-INF/view/adminpage/";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int no = Integer.parseInt(req.getParameter("no")); 
		
		ActivityService service =ActivityService.getInstance();
		
		Map<String,Object> list = service.selectContentByNum(new Activity(no));
		Activity activity = (Activity) list.get("activity");
		ActivityContent content = (ActivityContent) list.get("content"); 
		
		String imgPath = req.getRealPath("/img/activity/" + activity.getNum());

		File path = new File(imgPath); 
		System.out.println(path.getName());
		File[] files = path.listFiles();
		
		List<String> fileNames = new ArrayList<>();
		String contextPath = req.getContextPath()+"/img/activity/" + activity.getNum()+"/";
		for(File file : files){
			fileNames.add(contextPath+file.getName());
		}  
		 
		 
		req.setAttribute("activity", activity);   
		req.setAttribute("content", content);
		req.setAttribute("fileNames", fileNames);
		return filePath+"adminpage_activityRead.jsp";
	}
	
} 
