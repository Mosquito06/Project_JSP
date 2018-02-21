package Project_JSP.handler;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import Project_JSP.dto.Activity;
import Project_JSP.dto.ActivityContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.mvc.util.FileUtils;
import Project_JSP.service.ActivityService;

public class ActivityListHandler implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActivityService service = ActivityService.getInstance();
		if(req.getMethod().equalsIgnoreCase("get")){
			List<Activity> list = service.selectList();
			 
			if(list.size() == 0){ 
				req.setAttribute("exist","현재 진행중인 이벤트가 없습니다."); 
				return "/WEB-INF/view/adminpage/adminpage_activityList.jsp";
			}  
			 
			req.setAttribute("list", list);
			return "/WEB-INF/view/adminpage/adminpage_activityList.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")){ 
			ObjectMapper om = new ObjectMapper(); 	 
			 
			String no =req.getParameter("no"); 
			
			HashMap<String, Object> sendData = new HashMap<>(); 
			
			int result = service.delete(new Activity(Integer.parseInt(no)));
			
			if(result < 0){
				sendData.put("error", "삭제를 실패하였습니다.");
				
				String json = om.writeValueAsString(sendData);
				res.setContentType("application/json;charset=utf-8");
				
				PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성
				pw.print(json); //json pw에 넣기
				pw.flush(); //내보내기 
				
				return null;
			}
			
			String uploadPath = req.getRealPath("/img/activity/"+no);
			System.out.println("삭제경로 : " + uploadPath);
			File deletefile = new File(uploadPath);
			FileUtils.deleteDirectory(deletefile); 
			
			sendData.put("result", result);
			
			String json = om.writeValueAsString(sendData);
			res.setContentType("application/json;charset=utf-8");
			
			PrintWriter pw = res.getWriter(); //json을 만들 PrintWriter 생성 
			pw.print(json); //json pw에 넣기
			pw.flush(); //내보내기 
			return null; 
		}
	
		return null;
	}	
}
