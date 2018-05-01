package Project_JSP.handler;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Project_JSP.dto.Activity;
import Project_JSP.dto.ActivityContent;
import Project_JSP.mvc.controller.CommandHandler;
import Project_JSP.service.ActivityService;

public class ActivityIndexHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));

		ActivityService service = ActivityService.getInstance();

		Map<String, Object> list = service.selectContentByNum(new Activity(no));
		Activity activity = (Activity) list.get("activity");
		ActivityContent content = (ActivityContent) list.get("content");

		String imgPath = req.getRealPath("/img/activity/" + activity.getNum());

		File path = new File(imgPath);
		System.out.println(path.getName());
		File[] files = path.listFiles();

		List<String> fileNames = new ArrayList<>();
		String contextPath = req.getContextPath() + "/img/activity/" + activity.getNum() + "/";
		for (File file : files) {
			fileNames.add(contextPath + file.getName());
		}
		
		List<Activity> menuList = service.selectList();
		System.out.println(menuList);
		Map<String,String[]> map = new HashMap<>();
		String[] camping = {"캠핑&글램핑","cammping"};
		String[] kidzone = {"키즈 시설","kidzone"};
		String[] fitness = {"피트니스","fitness"};
		map.put("cammping",camping);
		map.put("kidzone", kidzone);
		map.put("fitness", fitness);
		 
		req.setAttribute("menuType", map);
		req.setAttribute("menuList", menuList);
		req.setAttribute("activity", activity);
		req.setAttribute("content", content);
		req.setAttribute("list", fileNames);
		
		return "/WEB-INF/view/activity/activity.jsp";
	}

}
